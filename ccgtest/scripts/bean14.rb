class Root
	attr_accessor :sourceFile
	attr_accessor :targetBaseFolder

	attr_accessor :packages
	attr_accessor :packagesByName
	
	def initialize(sourceFile, targetBaseFolder, configElement)
		puts("Root")
		@sourceFile = sourceFile
		@targetBaseFolder = targetBaseFolder

		@packages = []
		@packagesByName = {}
		
		configElement.childElements("package").each {
			|packageElement|
			package = Package.new(self, packageElement)
			@packages << package
			@packagesByName[package.name] = package
		}
	end
	
	def findBean(type)
		if !type.include?('.')
			return
		end
		dotIndex = type.rindex('.')
		packageName = type.slice(0..dotIndex-1)
		package = @packagesByName[packageName]
		if package.nil?
			return
		end
		beanName = type.slice(dotIndex+1..type.length)
		return package.findBean(beanName)
	end
	
	def resolve()
		@packages.each {
			|package|
			package.resolve()
		}
	end
	
	def write(monitor)
		puts("write Root")
		@packages.each {
			|package|
			package.write(monitor)
		}
	end
end

class Package
	attr_accessor :root
	attr_accessor :name
	attr_accessor :clean
	attr_accessor :folder
	
	attr_accessor :beans
	attr_accessor :beansByName
	
	def initialize(root, configElement)
		puts("Package")
		@root = root
		@name = configElement.getRequiredAttribute("name")
		@clean = configElement.getAttributeAsBoolean("clean")
		
		folderPath = @name.gsub('.', '/')
		@folder = @root.targetBaseFolder.getFolder(folderPath)
		puts("package.folder is #{folder.fullPath}")

		@beans = []
		@beansByName = {}
		
		configElement.getChildElements("bean").each {
			|beanElement|
			bean = Bean.new(self, beanElement)
			@beans << bean
			@beansByName[bean.name] = bean
		}
	end
	
	def findBean(type)
		if type.include?('.')
			return root.findBean(type)
		end
		return @beansByName[type]
	end
	
	def resolve()
		@beans.each {
			|bean|
			bean.resolve()
		}
	end
	
	def write(monitor)
		puts("write Package #{name}")
		files = Array.new
		@beans.each {
			|bean|
			content = bean.file.createContentBuffer()
			content.p("package " + @name + ";")
			content.p()
			bean.write(content, monitor)
			bean.file.write(content.content, true, monitor)
			files << bean.file
		}
		if @clean
			puts("clean Package #{name} NYI")
			members = @folder.members();
			members.each {
				|member|
				if member.isFile() && member.isDerived() && !files.include?(member)
					member.delete(false, monitor)
				end
			}
		end
	end
end

class Bean
	attr_accessor :package
	attr_accessor :name
	attr_accessor :description
	attr_accessor :abstract	
	attr_accessor :extends
	attr_accessor :extendsBean
	attr_accessor :implements

	attr_accessor :file
	attr_accessor :properties
	attr_accessor :propertiesByName
	attr_accessor :subclasses
	
	def initialize(package, configElement)
		puts("Bean")
		@package = package
		@name = configElement.getRequiredAttribute("name")
		@description = configElement.getAttribute("description")
		@abstract = configElement.getAttributeAsBoolean("abstract", false)
		@extends = configElement.getAttribute("extends")
		@implements = []
		configElement.getChildElements("implements").each {
			|implementsElement|
			@implements << implementsElement.getTextContent()
		}
		
		@file = @package.folder.getFile(@name + ".java")
		puts("bean.file is #{file.fullPath}")

		@properties = []
		@propertiesByName = {}
		@subclasses = []
		
		configElement.getChildElements("property").each {
			|propertyElement|
			cardinality = propertyElement.getAttribute("cardinality", "1")
			if cardinality == "1"
				property = SingleProperty.new(self, propertyElement)
			elsif cardinality == "*"
				property = MultiProperty.new(self, propertyElement)
			else
				raise "invalid kind: #{kind}"
			end
			@properties << property
			@propertiesByName[property.name] = property
		}
	end

	def getFullName()
		return "#{@package.name}.#{@name}"
	end

	def getJavaDocFullName()
		return "{@link #{getFullName()}"
	end
	
	def resolve()
		if !@extends.nil?
			@extendsBean = @package.findBean(@extends)
			if !@extendsBean.nil?
				extendsBean.subclasses << self
			end
		end
		@properties.each {
			|property|
			property.resolve()
		}
	end
	
	def write(content, monitor)
		puts("write Bean #{name}")
		content.pi("/**", " * ")
		if !@description.nil?
			content.p("#{@description}")
			content.p()
		end
		if @subclasses.size > 0
			content.pi("Subclasses are:<ul>")
			@subclasses.each {
				|bean|
				content.p("<li>#{bean.getJavaDocFullName()}</li>")
			}
			content.pu("</ul>")
		end
		content.p("Generated by CommentCodeGen: #{package.root.sourceFile.fullPath}")
		content.pu(" */")
		content.a("public ")
		if @abstract
			content.a("abstract ")		
		end
		content.a("class #{name} ")
		if !@extends.nil?
			content.a("extends #{extends} ")
		end
		if @implements.size > 0
			content.a("implements ")
			first = true		
			@implements.each {
				|element|
				if first
					first = false
				else
					content.a(", ")
				end
				content.a("#{element}")
			}
			content.a(" ")
		end
		content.pi("{")
		@properties.each {
			|property|
			property.write(content, monitor)
		}
		content.pu("}")
	end
end

class Property
	attr_accessor :bean
	attr_accessor :name
	attr_accessor :description
	attr_accessor :varName
	attr_accessor :capName
	attr_accessor :type
	attr_accessor :backref
	attr_accessor :backrefProperty
	attr_accessor :getterVisibility
	attr_accessor :setterVisibility

	def initialize(bean, configElement)
		@bean = bean
		@name = configElement.getRequiredAttribute("name")
		@description = configElement.getAttribute("description")
		@varName = "_#{name}"
		@capName = @name.dup
		@capName[0,1] = @capName[0,1].upcase
		@type = configElement.getAttribute("type")
		@backref = configElement.getAttribute("backref")
		@getterVisibility = "public"
		@setterVisibility = "public"
	end
	
	def resolve()		
		if !@backref.nil?
			typeBean = @bean.package.findBean(@type)
			if typeBean.nil?
				raise "Unknown type for backref #{@type}"
			end
			@backrefProperty = typeBean.propertiesByName[@backref]
			if @backrefProperty.nil?
				raise "Unknown property for backref #{@backref}"
			end
			if !@backrefProperty.backrefProperty.nil? and @backrefProperty.backrefProperty != self
				raise "Backref of backref #{@backref} is not #{@name}, but #{@backrefProperty.backrefProperty.name}"
			end
			puts("backref of #{getFullName()} is #{@backrefProperty.getFullName()}")
		end
	end
	
	def getNameConstant()
		return "PROPERTY_#{@name.upcase()}_NAME"
	end
	
	def getTypeConstant()
		return "PROPERTY_#{@name.upcase()}_TYPE"
	end
	
	def getFullName()
		return "#{@bean.getFullName()}.#{@name}"
	end
	
	def getJavaDocFullName()
		return "{@link #{@bean.getFullName()}\##{@varName}}"
	end

	def write(content, monitor)
		content.p("//")
		content.p("// ########## PROPERTY #{@name} follows ##########")
		content.p("//")

		#
		# constants
		#
		content.pi("/**", " * ")
		content.p("Name of property #{@name}.")
		content.pu(" */")
		content.p("public static final String #{getNameConstant()} = \"#{@name}\";")

		content.pi("/**", " * ")
		content.p("Type of property #{@name}.")
		content.pu(" */")
		content.p("public static final Class #{getTypeConstant()} = #{@type}.class;")
		content.p()
	end
end

class SingleProperty < Property
	attr_accessor :getterPrefix
	
	def initialize(bean, configElement)
		super
		if @type == "boolean"
			@getterPrefix = "is"
		else
			@getterPrefix = "get"
		end
	end
	
	def getGetterCall(instance)
		return "#{instance}.#{@getterPrefix}#{@capName}()"
	end
	
	def getAdderCall(instance, value)
		return "#{instance}.set#{@capName}(#{value})"
	end
	
	def getRemoverCall(instance, value)
		return "#{instance}.set#{@capName}(null)"
	end
	
	def write(content, monitor)
		super
		
		#
		# variable
		#
		content.p("/** Value of property #{@name}. */")
		
		content.p("private #{@type} #{@varName};")
		
		content.p()
		
		#
		# getter
		#
		content.pi("/**", " * ")
		content.p("Return the value of property #{@name}.")
		if !@description.nil?
			content.p()
			content.p("#{@description}")
		end
		content.p()
		content.p("@return The value of property #{@name}.")
		content.pu(" */")
		
		content.pi("#{@getterVisibility} final #{@type} #{@getterPrefix}#{@capName}() {")
		content.p("return #{@varName};")
		content.pu("}")
		
		content.p()
		
		#
		# setter
		#
		content.pi("/**", " * ")
		content.p("Set the value of property #{@name} to the specified value.")
		if !@backrefProperty.nil?
			content.p("Referred from #{@backrefProperty.getJavaDocFullName()}, which will be updated by this method.")
		end
		if !@description.nil?
			content.p()
			content.p("#{@description}")
		end
		content.p()
		content.p("@param #{@name} The new value for property #{@name}.")
		content.pu(" */")
				
		content.pi("#{@setterVisibility} final void set#{@capName}(final #{@type} #{@name}) {")
		if @backrefProperty.nil?
			content.p("#{@varName} = #{@name};")
		else
			content.pi("if (#{@varName} == #{@name}) {")
			content.p("return;")
			content.pu("}")
			oldName = "old#{@capName}"
			content.p("#{@type} #{oldName} = #{@varName};")
			content.pi("if (#{@varName} != null) {")
			content.p("#{@varName} = null;")
			content.p("#{@backrefProperty.getRemoverCall(oldName, "this")};")
			content.pu("}")
			content.p("#{@varName} = #{@name};")
			content.pi("if (#{@name} != null) {")
			content.p("#{@backrefProperty.getAdderCall(@name, "this")};")
			content.pu("}")
		end
		content.pu("}")

		content.p()
	end
end

class MultiProperty < Property
	def initialize(bean, configElement)
		super
	end
	
	def getAdderCall(instance, value)
		return "#{instance}.add#{@capName}(#{value})"
	end
	
	def getRemoverCall(instance, value)
		return "#{instance}.remove#{@capName}(#{value})"
	end
	
	def write(content, monitor)
		super
		
		#
		# variable
		#
		content.p("/** Value of property #{@name}. */")
				
		content.p("private final java.util.List #{@varName} = new java.util.ArrayList();")

		content.p()
				
		#
		# getter
		#
		content.pi("/**", " * ")
		content.p("The value of property #{@name} at the specified index.")
		if !@description.nil?
			content.p()
			content.p("#{@description}")
		end
		content.p()
		content.p("@param index The index, which must be valid.")
		content.p("@return The value of property #{@name} at the specified index.")
		content.p("@see java.util.List#get(int)")
		content.pu(" */")

		content.pi("#{@getterVisibility} final #{@type} get#{@capName}(int index) {")
		content.p("return (#{@type}) #{@varName}.get(index);")
		content.pu("}")
		
		content.p()
		
		#
		# iterator
		#
		content.pi("/**", " * ")
		content.p("Returns an {@link java.util.Iterator} for all values of property #{@name}.")
		content.p()
		content.p("@return An {@link java.util.Iterator} for all values of property #{@name}.")
		content.p("@see java.util.List#iterator()")
		content.pu(" */")
		
		content.pi("#{@getterVisibility} final java.util.Iterator #{@name}Iterator() {")
		content.p("return #{@varName}.iterator();")
		content.pu("}")
				
		content.p()
		
		#
		# size
		#
		content.pi("/**", " * ")
		content.p("Returns the number of values of property #{@name}.")
		content.p()
		content.p("@return The number of values of property #{@name}.")
		content.p("@see java.util.List#size()")
		content.pu(" */")

		content.pi("#{@getterVisibility} final int #{@name}Size() {")
		content.p("return #{@varName}.size();")
		content.pu("}")
		
		content.p()
		
		#
		# adder
		#
		content.pi("/**", " * ")
		content.p("Add the specified value to property #{@name}.")
		if !@backrefProperty.nil?
			content.p("Referred from #{@backrefProperty.getJavaDocFullName()}, which will be updated by this method.")
		end
		if !@description.nil?
			content.p()
			content.p("#{@description}")
		end
		content.p()
		content.p("@param #{@name} The additional value for property #{@name}.")
		content.p("@see java.util.List#add(Object)")
		content.pu(" */")

		content.pi("#{@setterVisibility} final void add#{@capName}(final #{@type} #{@name}) {")
		if @backrefProperty.nil?
			content.p("#{@varName}.add(#{@name});")
		elsif @backrefProperty.backrefProperty.nil?
			content.p("#{@varName}.add(#{@name});")
			content.p("#{@backrefProperty.getAdderCall(@name, "this")};")
		else
			content.pi("if (#{@varName}.contains(#{@name})) {")
			content.p("return;")
			content.pu("}")
			content.p("#{@varName}.add(#{@name});")
			content.p("#{@backrefProperty.getAdderCall(@name, "this")};")
		end
		content.pu("}")
		
		content.p()
		
		#
		# remover
		#
		content.pi("/**", " * ")
		content.p("Remove the specified value of property #{@name}.")
		if !@backrefProperty.nil?
			content.p("Referred from #{@backrefProperty.getJavaDocFullName()}, which will be updated by this method.")
		end
		if !@description.nil?
			content.p()
			content.p("#{@description}")
		end
		content.p()
		content.p("@param #{@name} The value to remove from property #{@name}.")
		content.p("@see java.util.List#remove(Object)")
		content.pu(" */")

		content.pi("#{@setterVisibility} final void remove#{@capName}(final #{@type} #{@name}) {")
		if @backrefProperty.nil?
			content.p("#{@varName}.remove(#{@name});")
		elsif @backrefProperty.backrefProperty.nil?
			content.p("#{@varName}.remove(#{@name});")
			content.p("#{@backrefProperty.getRemoverCall(@name, "this")};")
		else
			content.pi("if (!#{@varName}.contains(#{@name})) {")
			content.p("return;")
			content.pu("}")
			content.p("#{@varName}.remove(#{@name});")
			content.p("#{@backrefProperty.getRemoverCall(@name, "this")};")
		end
		content.pu("}")
				
		content.p()
	end
end

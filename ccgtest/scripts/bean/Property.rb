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

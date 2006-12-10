require("Property")

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

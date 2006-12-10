require("Property")

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

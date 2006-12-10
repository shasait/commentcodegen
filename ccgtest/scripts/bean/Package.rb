require("Bean")

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

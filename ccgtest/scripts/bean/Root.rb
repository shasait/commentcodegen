require("Package")

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

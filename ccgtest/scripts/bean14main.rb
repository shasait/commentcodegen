puts("load")
load $scriptFile.getFile("bean14.rb").location.toOSString()

puts("new")
root = Root.new($sourceFile, $targetBaseFolder, $configElement)
puts("resolve")
root.resolve()
puts("write")
root.write($monitor)

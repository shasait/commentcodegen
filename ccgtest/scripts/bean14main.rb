puts("load")
load $resources.getRelativeFile($scriptFile, "bean14.rb").location.toOSString()

puts("new")
root = Root.new($sourceFile, $element)
puts("resolve")
root.resolve()
puts("write")
root.write()

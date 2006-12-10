oldpwd = Dir.pwd
newpwd = $scriptFile.parent.location.toString()
puts("chdir to folder of this script: #{newpwd}")
Dir.chdir(newpwd)
begin
	puts("create Root")
	require("Root")
	root = Root.new($sourceFile, $targetBaseFolder, $configElement)
	puts("resolve")
	root.resolve()
	puts("write")
	root.write($monitor)
ensure
	puts("restore previous pwd: #{oldpwd}")
	Dir.chdir(oldpwd)
end

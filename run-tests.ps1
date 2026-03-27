$env:JAVA_HOME = 'C:\Program Files\Java\jdk-20'
$env:Path = $env:JAVA_HOME + '\bin;' + $env:Path
cd $PSScriptRoot
mvn -q test
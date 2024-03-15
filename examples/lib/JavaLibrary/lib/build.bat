@echo off
:: JAVA_HOME must be set
:: %JAVA_HOME%\bin must be in the %PATH%

set dest=target

rmdir /S /Q %dest%
mkdir %dest%

javac -cp deps/* src\main\java\org\example\*.java -encoding utf8 -parameters -d %dest%
copy MANIFEST.MF %dest%
pushd %dest%
jar cfm ..\javalib.jar MANIFEST.MF org/
popd %dest%

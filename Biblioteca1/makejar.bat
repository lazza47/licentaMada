@echo off

set ANT_HOME=c:\ant
set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_51
set PATH=%PATH%;%ANT_HOME%\bin
call ant -f %~dp0

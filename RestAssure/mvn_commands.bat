@echo off
: In cmd, navigate to user.dir
: Clean- It would clean the target folder, i.e. the folder where the previous build’s libraries, build files(war, tar or jar files), reports, output files, etc are saved. On executing mvn -clean this target folder will be deleted.

: Install- It would install all the dependencies, in case of missing jars, and create the deployment file(war/jar files in case of JAVA) and then it’ll run the test.

: Test- It will simply run the test without creating any deployment file.

echo !!!Begin of  Cleaning !!!
call mvn clean
echo !!!End of  Cleaning !!!

echo !!!Begin of  Install !!!
call mvn install
echo !!!End of  Install !!!
: call mvn test
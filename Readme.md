#Installation (pre-requisites)
JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
Eclipse
Eclipse Plugins for Maven

#IDE: 
1. Eclipse

#Dependencies:
1. maven build tool

Cmmd line execution:
1. Open Terminal
2. Go to project directory 
3. use "mvn clean install test"
     or 
       "mvn clean install"
 
 
 
#Eclipse IDE Testrunner execution: 
1. Open eclipse IDE
2. import project: Go to File > import project > select Maven existing project > Next > Root directoty of project > Next
3. Go to `src/test/java/testRunner` folder 
4. Right click on `SerenityTestSuite` > Run As > Junit Test
     
     
#Eclipse IDE maven execution: 
1. Open eclipse IDE
2. import project: Go to File > import project > select Maven existing project
3. Right click on `ProjectDirectory` > Run As > Maven clean
4. Right click on `ProjectDirectory` > Run As > Maven install

#Reports:
1. Reports will be generated in `Serenity-UITest/target/site/serenity` folder
2. File: `Serenity-UITest/target/site/serenity/index.html`




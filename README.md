# Instructions for Installation Setup and Test Execution

According to the user story I have written the Automated positive and negative Tests as regular java test methods under  test package of “ATBAutomation” project folder. This folder has a batch file called  “ATBAutomation.bat” to execute the these tests on Command line

-Make sure you have latest java installed
-Make sure you have an Eclipse installed
-Make sure you have chrome browser
-After you download the Project  from github link, save it folder under your workspace
-Import “ATBAutomation” folder into eclipse
-On eclipse Right click  on the project select BuildPath> Configure Buildpath to add all the necessary jars to the project from “JARS” folder located under the project folder
-Also MakeSure you have testNG installed here and Apache Ant Configured to your system
-If you don’t have ant configured into your system, follow the steps:

  1.Go to >> https://ant.apache.org/bindownload.cgi
  2.Download .zip archive and extract it
  3.Place the extracted file under c drive
  4.Copy the path: C:\Program Files\apache-ant-1.9.7
  5.Go to Environment variables page from System Properties
  6.Create new system variables and name it ANT_HOME and paste the path from step 4: http://screencast.com/t/iSnEFnTR
  7.Then Double click on Path under System variables
  8.Click on New and Type %ANT_HOME%/bin   è: http://screencast.com/t/fm5qYFga5K
  9.EXIT out from everything and open CMD and type ANT -verison  http://screencast.com/t/zB0JZ900ol
  10.Type ant in cmd prompt
  11.If you get tools.jar is not present then follow this
  12.Go to C:\Program Files\Java
  13.Go to  C:\Program Files\Java\jdk1.8.0_74\lib and copy tools.jar file
  14.Then go back to C:\Program Files\Java\jre1.8.0_74\lib and paste the tools.jar file http://screencast.com/t/xwpC4jRlGlH7
  15.Now fire ant in cmd again
  16.You will get build.xml does not exit! – which is normal

 -“ATBAutomation.bat”  file contains cmd commands for the project path and targets for build.xml  to execute the test suit
-Change the project  path inside this batch file, save and execute
-Testng xslt report will be available from XSLT_Report folder and regular html report inside test-output folder under the project.
-Also you can check the test execution flow from logs inside Automation.logs under the project.

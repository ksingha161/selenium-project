## Installation
- You will need JDK 11 to run this project
- You'll need maven to run via commandline, but you can run without it by right clicking on the spotify_suite.xml and selecting run.
- I've executed this project only in Intellij and I'd suggest doing the same, community or ultimate edition doesn't matter.

## Email & password
- test.properties file contains the username and password value, replace *** secret *** with actual email and password. 

## To run
- From commandline - mvn clean test -Dsurefire.suiteXmlFiles=src\test\java\com\octave\suites\spotify_suite.xml
- Or right click and execute this file src\test\java\com\octave\suites\spotify_suite.xml

## Info
- Package src\main\java\com\octave\octave_demo provides all the page objects for three pages this test
interacts with.
- Package src\main\java\utils provides basic utility methods used everywhere.
- Package src\test\java\com\octave\octave_demo contains the test itself.
- src\test\java\com\octave\suites\spotify_suite.xml is the file to be executed

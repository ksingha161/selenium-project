## Installation
- You will need Java 8 to run this project
- You'll probably need maven too, but give it a try without it.

## Email & password
- test.properties file contains the username and password value, replace **secret** with actual email and password. 

## To run
- From commandline - mvn clean test -Dsurefire.suiteXmlFiles=src\test\java\com\octave\suites\spotify_suite.xml
- right click and execute this file src\test\java\com\octave\suites\spotify_suite.xml

## Info
- Package src\main\java\com\octave\octave_demo provides all the page objects for three pages this test
interacts with.
- Package src\main\java\utils provides basic utility methods used everywhere.
- Package src\test\java\com\octave\octave_demo contains the test itself.
- src\test\java\com\octave\suites\spotify_suite.xml is the file to be executed

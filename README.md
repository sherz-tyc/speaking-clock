## Introduction
This is a solution for a code challenge set by Wowcher. It will be 
published to GitHub for submission unless requested otherwise.
- Candidate name: **Sherman Tam**


## Building the project
1) Clone/Pull via Git or download zip file of this project (and un-zip) 
to a directory;


2) Make sure you have Maven installed on your machine, you can check 
this by inspecting the version of installed Maven via the following
command (using command line tool):

``mvn -version``

3) Using command line tool, navigate to the root directory where this
README.md file and, specifically, the pom.xml file is located;

4) Run the following maven command via the command line:

``mvn clean install``    (Also runs Tests)

or

``mvn clean install -DskipTests``    (Does not run Tests)



## Notes regarding this submission
This **Speaking Clock** project is a demo application developed with 
limited time and resources available. There are 2 ways to verify the
validity of the conversion from digital 24-hr clock representation
to a verbal text-based clock:
1) Run this project's main class (user interaction within the console):


2) Run the tests written for this application.



## Running the application's main class
You may execute the main class by running the following maven command via 
the command line:

``mvn exec:java``


## Run Tests Only
To run tests only, run the following command on command line:

``mvn test``



##Thank you for taking an interest in this project.


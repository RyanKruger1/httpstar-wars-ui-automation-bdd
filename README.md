# Star Wars UI automation with BDD

This repository was created to showcase the author's test automation skills.

This repo consists of a Java framework using RestAssured.

## Requirements:

- Java(JDK 11 or Higher)
- Browser (Chrome, Firefox, or Edge)
- Yarn

## System under test

The SUT is (repo)[https://github.com/MindfulMichaelJames/star-wars/tree/main]

## Java Automation Framework

### Prerequisites

This automation framework only uses Selenium in conjunction with TestNg & Cucumber
The application is run from localhost:3000
Instruction to run the application can be found here: https://github.com/MindfulMichaelJames/star-wars/tree/main

### Running

The Java framework uses Gradle as the main building tool.

On a Windows operating system, navigate to the root of the project in your file system via command line.
Then run :
`gradlew runCucumberTests`

On Mac machine navigate to the repository via terminal. Run `chmod +x gradlew`, this will allow the gradlew file to become executable. To run the solution run command:
`./gradlew runCucumberTests`

### Reporting

A test report is generated after each run in the /test-reports/ folder in the base repository of the repo.

### Notes
Currently chrome is set to run headless mode, to allow CI/CD pipelines to be ran successfully.

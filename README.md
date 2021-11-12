# Front-End Automation

# Requirements
1. JDK 1.8
2. Maven
3. Git
4. Chrome version 95.x
5. IntelliJ IDE (optional)

# How to run using Maven
- Clone project: git clone https://github.com/daividsimoes/front-end-automation.git
- Go to project directory
- Execute the command: mvn test or mvn clean test

Note: At first run, maven will download all dependencies

# How to run using IntelliJ IDE
- Clone project: git clone https://github.com/daividsimoes/front-end-automation.git
- Open project in IntelliJ IDE
- Right click on Runner class: src/test/java/br/com/frontend/automation/test/runner/AmazonRunnerTest.java
- Click: Run 'AmazonRunnerTest.java'

Note: At first run, maven will download all dependencies

# In case of error with Maven dependency
- Delete 'target' folder
- Execute: mvn clean
- Execute: mvn install

# Report
- A report will be generated on {Project_Folder}/target/report/report.html
- Report screenshot will be storage on {Project_Folder}/target/report/screenshots
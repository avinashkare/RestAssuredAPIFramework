# RestAssured + Cucumber Framework

This is an API testing framework built using **RestAssured** for API interactions, **Cucumber** for Behavior-Driven Development (BDD) testing, and **Maven** for build automation.

---

## Features:

- **RestAssured** for API request and response validation.
- **Cucumber** for writing feature files and automating test scenarios.
- **Maven** for dependency management, building, and testing the project.
- **GitHub integration** for version control and **Jenkins CI/CD** for automation.
- **Parallel Test Execution** using the **cucumber-jvm-parallel-plugin**.
- **HTML and JSON Reporting** for test results.

---

## Framework Structure:

- **`src/main/java`**: Contains core logic and utility classes for interacting with APIs.
  - **stepDefinitions**: Contains Cucumber step definition files that connect the feature files with executable code.
  - **testDataBuilder**: Contains classes that build the payloads for API requests.
  - **utils**: Contains helper methods like logging, request specification, etc.

- **`src/test/resources`**: Contains the feature files used by Cucumber.
  - **features**: Contains `.feature` files with Cucumber scenarios.
  - **testResources**: Contains other test-related resources (e.g., JSON files for test data).

- **`pom.xml`**: Maven configuration file containing dependencies and plugin configurations.

---

## Getting Started:

Follow these instructions to set up and run the framework on your local machine:

### Prerequisites

Before using this framework, ensure that the following tools are installed:

- **Java 11 or higher**
- **Maven**: For project management and running tests.
- **Git**: For version control.
- **IDE**: IntelliJ IDEA or Eclipse (for development purposes).
- **Jenkins**: For Continuous Integration.

---

## Running Tests in Parallel:

The framework is configured to run tests in parallel using **cucumber-jvm-parallel-plugin**. To run tests in parallel, simply use the standard Maven command, and the tests will be executed across multiple threads based on the configuration.

---

## Jenkins Integration:

To run tests on Jenkins, follow these steps:

1. **Configure Jenkins** with the Git repository for the project.
2. **Add the Maven build step** to your Jenkins job.
3. **Configure your build trigger**, such as using **GitHub Webhooks** or **SCM polling**.
4. **Add a Cucumber report plugin** to generate HTML and JSON reports.
5. **Add environment variables or parameters** as needed (e.g., branch names, tags).

Jenkins will automatically pull the latest code from the repository, run tests, and provide reports.

---

## Report Generation:

- **JSON Report**: The results are stored in `target/jsonReports/cucumber-report.json`.
- **HTML Report**: A detailed HTML report is generated in `target/cucumber-reports.html`.

You can also configure the **cucumber-jvm-parallel-plugin** to generate parallel execution reports.

---

### Installing Dependencies:

Clone the repository and install the required dependencies using Maven:

git clone https://github.com/avinashkare/RestAssuredAPIFramework.git

cd RestAssuredAPIFramework

mvn clean install

---

### Running Tests:

You can run the tests using the following Maven command:

mvn test

---

### Running Tests with Cucumber Reporting

You can run the tests using the following Maven command:

mvn test verify

---

### Running scripts with specific tag

You can run the tests using the following Maven command:

mvn test -Dcucumber.filter.tags="@Regression"

This will execute only the tests with the `@Regression` tag.



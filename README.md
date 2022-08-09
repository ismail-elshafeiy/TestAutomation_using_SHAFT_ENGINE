### 🔧 Technologies

* Java Development Kit [JDK-17](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) as a Development
  Environment.
* [Maven](https://maven.apache.org/) as a build tool, that automate the process of compiling computer source code into
  binary code.
* [TestNG](https://testng.org/) as a Unit Test Automation framework.
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/) for Web App GUI Test Automation.
* [Appium](https://appium.io/) for Mobile App GUI Test Automation.
* [Rest assured](https://javadoc.io/doc/io.rest-assured/rest-assured/latest/index.html) for REST/GraphQl API Test
  Automation.
* [SHAFT_Engine Framework](https://github.com/ShaftHQ/SHAFT_ENGINE.git)
* [Allure Report Framework](https://docs.qameta.io/allure/) for generating test execution report.
* [Extent Report Framework](https://www.extentreports.com/docs/versions/4/java/) for generating test execution report.
* [Data Driven Testing framework](https://www.guru99.com/data-driven-testing.html) to read from data files and store
  them in variables in test scripts.
* [Docker](https://docs.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/overview/) for running Selenium Grid.
* [Selenium Grid](https://www.selenium.dev/documentation/grid/) for remote execution.
* [GitHub Actions](https://docs.github.com/en/actions) for continuous integration.
* Applying Hybrid Test Automation Framework

---

## 📝 Project Design patterns:

* [WebElement Extension Methods](https://toolsqa.com/selenium-webdriver/c-sharp/webelement-extensions-method/) (Selenium
  Wrapper).
* Implementing the ***Test Automation Pyramid*** by have 2 different test automation levels which are SERVICE and GUI
  layers
* Applying
  the [Page Object Model (POM) design pattern](https://www.browserstack.com/guide/page-object-model-in-selenium#:~:text=Page%20Object%20Model%2C%20also%20known,application%20as%20a%20class%20file.)
  .
* Applying the [Fluent design](https://java-design-patterns.com/patterns/fluentinterface/) approach.
* Configurations.Set from [Properties File](src/main/resources/properties)
* [Managing test data](https://www.ontestautomation.com/managing-test-data-in-end-to-end-test-automation/?fbclid=IwAR3JVpSg8jkhxVMgcPzihHDPzSWebbPxLZ7RxX22QQeJlSwQBNhNiXq-koU)
  in end-to-end test automation by approach `Creating test data during test execution`.

---

## ✏ Project Structure:

``` bash
  ├── main
  │   ├── com.dentolize 
  │   │   └── modules
  │   │       ├── api
  │   │       └── gui --> pages
  │   ├── utils 
  │   └── resources
  │       └──  properties -> configerations
  ├── test
  │   ├── testcases 
  │   │   ├── modules --> Test Functions
  │   └── resources
  │       ├── testData
  │       ├── testSuits
  │       ├── uploads files
  │       └── docker-compose.yml
  ├── pom.xml
  └── README.md
```

---
<br/>
  <details>
    <summary>
      <strong> 👉 Click here Run to the Test cases locally using IntelliJ IDEA </strong> 
    </summary>


Pre-requisites: jdk-17 and maven should be installed

* Set the [properties](src/main/resources)  including all the configurations
* Set the test Data from [TestData](src/test/resources/testDataFiles)
* Edit your run configuration templates before running your tests by following these steps:
  <br/>- Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
  <br/>- Select <b>TestNG</b> > Listeners > and add this listener:
  <br/>`com.shaft.tools.listeners.AlterSuiteListener`, `com.shaft.tools.listeners.SuiteListener`
  , `com.shaft.tools.listeners.InvokedMethodListener`

* Execute All tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn clean test
```

* After executing,The report will be generated automatically after running the test.
* Find the Extent Report [ExtentReports.html](ExtentReports.html) in the project root path for the latest execution and
  open by any browser

  </details>

---
<br/>
  <details>
    <summary>
      <strong> 👉 Click here to the Run the Test remotely using Selenium-Grid and Docker: </strong> 
    </summary>

Pre-requisites: Docker Desktop should be installed.

* To start selenium-grid using docker-compose; at the root directory of the project, run the following command:

```bash
docker-compose -f src/test/resources/docker-compose.yml up --scale chrome=2 --remove-orphans -d
```

* Open [http://localhost:4444/grid/console](http://localhost:4444/grid/console) to monitor selenium grid.
* Run the test using the following command:

```bash
mvn test
```

* To end/down selenium grid; at the root directory, run the following command:

```bash:
docker-compose -f src/test/resources/docker-compose.yml down --remove-orphans
```

</details>

---

<br/>
  <details>
    <summary>
      <strong> 👉  Click here to show the Test Cases: </strong> 
    </summary>

```bach
* Verify the user Can "Register" via email.
* Verify the user Can "Login" via email.
* Verify the user can "Change password".
* Verify the user can "Login with New Password".
* Verify the user Can "Search" with Keyword.
* Verify the user can "Search" via auto complete.
* Verify the user can "ContactUs" and send Message.
* Verify the user can "Add Product to Cart"
* Verify the user can "Add Product to Wishlist"
* Verify the user can "Add Products to Compare".
* Verify the user can "Email Product to Friend".
* Verify the user can "Check out Product".
```

</details>

---
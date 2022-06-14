# Automation-Practice
This is where I practice Test Automation Using Shaft Engine framework!

## Pre-requestes
* Install Java JDK 17 and then add it on the Env. variable 
  https://www.oracle.com/java/technologies/downloads/#jdk17-windows
* Install Maven and then add it on the Env. variable
  https://maven.apache.org/download.cgi
* Install Allure Report


## Install and Execution:
* git clone
  https://github.com/ismail-elshafeiy/NopCommerce_TestAutomation.git

### The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Extent Reports
* Apachi POI

### Project Design:
* Page Object Model (POM) design pattern
* Fluent design approach
* Data Driven framework. Read data from JSON File src/test/resources/TestDataFiles/

### How to set the project configuration: (Test Data , .env Url )
* A properties file ***"NopCommerce.properties"*** can be found it. src/main/resources/properties/nopCommerce.properties

### Test Cases
* Verify the user Can "Register" via email.
* Verify the user Can "Login" via email.
* Verify the user can "Change password".
* Verify the user can "Login with New Password".
* Verify the user Can "Search" with Keyword.
* Verify the user can "Search" via auto complete.
* Verify the user can "ContactUs" and send Message.
* Verify the user can "Add Product to Cart"
* Verify the user can "Add Product to Wishlist"
* Verify the user can "Add Products to Compare"
* Verify the user can "Email Product to Friend"
* Verify the user can "Check out Product"
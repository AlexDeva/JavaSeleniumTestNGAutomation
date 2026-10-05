# Java Selenium TestNG Automation Framework

This project is a modular UI test automation framework built with Java, Selenium WebDriver, TestNG, and Maven. It is designed to support scalable browser automation for web applications with page object model (POM), reusable utility classes, and cross-browser execution.

## Overview

The goal of this framework is to provide a clean and maintainable structure for end-to-end UI automation testing. It separates test logic, page objects, driver management, configuration, and reporting so that tests can be written consistently and executed efficiently.

## Tech Stack

- Java 17+
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager or Selenium Manager
- Apache POI (for Excel-based data-driven tests)
- ExtentReports or Allure
- Lombok
- Chrome, Firefox, and Edge support

## Project Structure

```text
JavaSeleniumTestNGAutomation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   ├── config/
│   │   │   ├── driver/
│   │   │   ├── pages/
│   │   │   ├── utils/
│   │   │   └── listeners/
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   └── data/
│       └── resources/
│           └── testng.xml
├── pom.xml
├── .gitignore
├── readme.md
├── requirements.md
└── screenshots/
```

## Prerequisites

Before running the framework, make sure the following are installed:

- Java JDK 17 or later
- Maven 3.8+
- IDE such as IntelliJ IDEA or Eclipse
- Browser drivers or WebDriverManager support
- Internet access for dependency downloads

## Configuration

Create a `config.properties` file under `src/main/resources/` with values similar to:

```properties
base.url=https://example.com
browser=chrome
headless=true
page.load.timeout=30
element.timeout=10
```

This file should be loaded by the framework configuration utility to manage environment-specific values.

## Core Framework Features

- Thread-safe WebDriver management using `ThreadLocal`
- Cross-browser setup for Chrome, Firefox, and Edge
- POM-based page classes for maintainable UI automation
- Reusable wrapper methods for waits, clicks, typing, and scroll actions
- Data-driven testing using TestNG `@DataProvider`
- Screenshot capture on test failure
- Test reports via ExtentReports or Allure
- Parallel execution support with `testng.xml`

## Execution Commands

Run the default suite:

```bash
mvn clean test
```

Run a specific TestNG XML file:

```bash
mvn clean test -DtestngXml=src/test/resources/testng.xml
```

Example cross-browser run:

```bash
mvn test -Dbrowser=firefox -Dheadless=true
```

## Example TestNG Suite

```xml
<suite name="RegressionSuite" parallel="tests" thread-count="3">
    <test name="Login Test">
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

## Best Practices Used in This Framework

- Use explicit waits instead of static sleeps
- Use Page Object Model for reusability and readability
- Keep test logic separated from page logic
- Use descriptive assertion messages
- Capture screenshots on failure for debugging
- Use data providers for multiple test inputs
- Keep configuration externalized in properties files

## Notes

This repository is intended to serve as a clean starting point for building an enterprise-level Selenium automation framework. The original detailed specification has been preserved in [requirements.md](requirements.md).

## Recommended Next Steps

1. Add actual page classes for your application
2. Create test packages for login, registration, and checkout flows
3. Set up reporting and screenshot capture
4. Add additional test data sources such as Excel or JSON
5. Expand support for CI/CD execution through Jenkins, GitHub Actions, or Azure DevOps

---

This README is intentionally structured as a practical starting point for a working Java Selenium TestNG project.

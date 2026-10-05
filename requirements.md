Act as a Principal Automation Architect. I am building an enterprise UI Test Automation Framework using Java, Selenium WebDriver, TestNG, and Maven. 

Please generate:
1. A complete `pom.xml` file containing essential dependencies with non-conflicting stable versions for:
   - Selenium Java
   - TestNG
   - WebDriverManager (or Selenium Manager setup)
   - ExtentReports or Allure TestNG
   - Apache POI (for Excel data handling)
   - Lombok
   - Maven Surefire Plugin (configured to execute testng.xml)
2. A standard Maven project directory tree structure following industry best practices (separating core framework code in `src/main` from tests in `src/test`).

Provide clean, production-ready Java code for the core configuration and driver management setup in my Selenium-TestNG-Maven framework:

1. `ConfigReader.java`: A utility class to read environment properties (e.g., URL, browser, timeout) from a `config.properties` file using Java's Properties class.
2. `DriverManager.java`: A ThreadLocal-based driver manager class ensuring thread-safe parallel execution of `WebDriver` instances across tests.
3. `BaseTest.java`: A TestNG Base Test class implementing `@BeforeMethod` and `@AfterMethod` hooks to initialize and tear down the WebDriver instance cleanly per test. Include cross-browser initialization logic (Chrome, Firefox, Edge) using ChromeOptions/FirefoxOptions (e.g., headless mode, maximize on startup, incognito).

Demonstrate how to implement the Page Object Model (POM) pattern in Java Selenium with Page Factory/Explicit Waits:

1. Create a `BasePage.java` parent class providing reusable wrapper methods for core user actions (e.g., `click`, `sendKeys`, `waitForElementVisible`, `waitForElementClickable`, `selectDropdownByVisibleText`, `scrollToElement`). Always use `WebDriverWait` and `ExpectedConditions` rather than static thread sleeps.
2. Create a concrete `LoginPage.java` class extending `BasePage`:
   - Define Locators using `@FindBy` or standard `By` locators.
   - Encapsulate page elements with private access modifiers.
   - Provide explicit public business methods like `login(String username, String password)` and getter/validation methods.
   
Generate a TestNG Test class that demonstrates Data-Driven testing and assertion best practices:

1. Create a `LoginTest.java` class that extends `BaseTest`.
2. Implement a TestNG `@DataProvider` method (either using a 2D Object array or reading from Excel/JSON) to pass multiple credential combinations.
3. Include test methods covering:
   - Successful login validation (verify page URL or dashboard header).
   - Unsuccessful login validation (verify explicit error message displayed).
4. Use standard TestNG assertions (`Assert.assertEquals`, `Assert.assertTrue`) with clear, descriptive assertion failure messages.

Implement robust test logging, listener integration, and automated failure capturing:

1. Create a TestNG Listener class implementing `ITestListener`:
   - On test failure (`onTestFailure`), capture a full-page screenshot using `TakesScreenshot`.
   - Save the screenshot to a `./screenshots/` directory with a unique timestamped filename.
2. Integrate ExtentReports (or Allure) inside the listener to log test status (`PASS`, `FAIL`, `SKIP`), test steps, stack traces, and attach the captured screenshot directly to the report on failure.

Provide execution setup files and CLI commands for this framework:

1. A complete `testng.xml` suite configuration configured for parallel test execution at the `<test>` or `<classes>` level (thread count = 3).
2. Sample Maven CLI commands to run:
   - The default `testng.xml` execution: `mvn clean test`
   - Specific TestNG xml files passed via command line parameter.
   - Specific cross-browser flags via CLI (e.g., `mvn test -Dbrowser=firefox -Dheadless=true`).
   
Act as a Lead QA Automation Engineer. Create a modular TestNG test class in Java and Selenium WebDriver that performs comprehensive UI visual and functional element checks on a web page (e.g., User Registration or Profile page).

Include test cases with explicit TestNG assertions for:
1. Header & Navigation Bar: Verify presence, text correctness, and visibility of logo, navigation links, and action buttons.
2. Form Input Fields: Verify default placeholder text, field state (enabled/disabled/readonly), and input value validation.
3. Interactive Components: Verify state changes for checkboxes (checked/unchecked), radio buttons (selected state/group mutual exclusivity), and dropdowns (default selected option vs list of options).
4. CTA Buttons: Verify primary and secondary buttons are enabled, visible, and have correct text labels.
5. Tooltips & Modals: Verify hover tooltips appear with correct text and modal popups display expected title and body text upon action.

Ensure all elements use explicit waits (WebDriverWait) before assertion and include descriptive assertion error messages.

Generate a TestNG test script in Java Selenium focused on UI form validation and error message handling for a registration or checkout form.

Please implement the following UI validation scenarios:
1. Mandatory Field Validation: Trigger form submission with empty fields and verify inline error messages appear under each required input with exact text and proper visibility.
2. Format Rules Validation: Enter invalid formats (e.g., malformed email address, weak password, invalid phone number length) and assert that format error messages display dynamically.
3. Field Boundary & Character Limit Checks: Input string exceeding max length and verify input is either truncated or an error indicator appears.
4. Error State Clearing: Correct an invalid entry and verify that the inline error message disappears or updates to a success state.
5. Toast Notifications / Alert Banners: Verify global error banners or success toast messages appear, display correct copy, and auto-dismiss or disappear when manually closed.

Organize the test using the Page Object Model structure and standard TestNG soft assertions (`SoftAssert`) where multiple field validations occur on a single form submission.

Provide a specialized Java Selenium test suite using TestNG to validate layout integrity, alignment, and responsiveness across standard screen viewports.

Implement test cases covering:
1. Multi-Resolution Viewport Testing: Test page loading across Desktop (1920x1080), Tablet (768x1024), and Mobile (375x812) viewports using `driver.manage().window().setSize()`.
2. Responsive Menu Toggle: On tablet/mobile viewports, verify that desktop navigation links collapse into a hamburger menu and that clicking the hamburger icon opens/closes the mobile menu tray.
3. Dynamic Element Visibility: Verify that specific desktop-only elements (e.g., wide banners, desktop sidebars) hide on small viewports while mobile alternatives render correctly.
4. CSS & Styling Checks: Extract and validate key computed CSS properties using `element.getCssValue()` (e.g., primary button background color in HEX/RGBA, font size, or visibility state).

Create a robust UI validation test script for an interactive Data Table / Grid component in Java Selenium with TestNG.

Cover the following table UI interaction flows:
1. Column Headers & Order: Assert table header labels match expected column names and order.
2. Data Row Count & Empty State: Validate row count per page matches pagination selection (e.g., 10 rows per page), and verify "No Data Available" message displays when a filter returns zero records.
3. Sorting Functionality: Click a column header (e.g., "Name" or "Date") and assert that table rows sort alphabetically or chronologically ascending/descending.
4. Search & Dynamic Filtering: Enter search criteria into table search bar and verify only matching rows are displayed in the results grid.
5. Pagination Navigation: Verify Previous/Next controls, active page number styling, and total record counter display (e.g., "Showing 1 to 10 of 50 entries").


# TradeMeTests
An automation test solution that has a combination of both UI and API tests.

## Usage

- Clone repository
- Import Maven project into IntelliJ
    - In IntelliJ, right-click the pom.xml file then click Maven > Reload project
- In IntelliJ, create a new run configuration
  - Configuration type: TestNG
  - Under 'configuration' tab
    - For the 'Type' dropdown, select 'Suite'
    - Select the suite file located in `src/test/resources/suites/AllTests.xml`
  - Save configuration
  - Run the configuration
  - After all tests complete, the test report will be created in `target/report.html`

## Depdendencies

- TestNG
- RestAssured
- WebDriverManager
- Hamcrest
- ExtentReports

## References
- ACCAutomation implementation
- [Wrapping WebElement 1](http://elisarver.com/2012/12/09/wrapping-webelement-1/), Eli Sarver
- [Wrapping WebElement 2](http://elisarver.com/2012/12/10/wrapping-webelement-2), Eli Sarver
- [Page Object Model](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/), Selenium Blog
- [Using Custom Web Element Models In Selenium Testing Framework](https://www.maestralsolutions.com/using-custom-web-element-models-in-selenium-testing-framework/), Enes Kuhn
- Javadoc for ElementHandler, DefaultFieldDecorator, Proxy (`java.lang.reflect`)
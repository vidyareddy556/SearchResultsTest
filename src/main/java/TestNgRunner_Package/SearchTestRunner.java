package TestNgRunner_Package;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = "com.example.stepdefs", plugin = {"pretty", "html:target/cucumber-html-report"})
public class SearchTestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    }

    @AfterClass
    public void tearDown() {
        // Close WebDriver
    }

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

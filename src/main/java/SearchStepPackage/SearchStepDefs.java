package SearchStepPackage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SearchStepDefs {

    private WebDriver driver;

    @Given("I am on the homepage")
    public void navigateToHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchForSomething(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement element = driver.findElement(By.name("q"));
       // WebElement element = driver.findElement(By.xpath("//input[@type='search']"));
        WebElement element = driver.findElement(By.xpath("//*[@title='Search']"));
        // Enter something to search for
        element.sendKeys(query);
        element.submit();
    }

    @Then("I should see results for {string}")
    public void verifyResults(String searchResults) {
        WebElement resultsContainer = driver.findElement(By.id("main"));
        int results = resultsContainer.findElements(By.tagName("li")).size();
        assertTrue(results > 0);
        driver.quit();
    }

    @Then("I should see a message {string}")
    public void verifyNoResultsMessage(String searchResults){
        WebElement resultsContainer = driver.findElement(By.id("main"));
        int results = resultsContainer.findElements(By.tagName("li")).size();
        assertTrue(results > 0);
    }

}

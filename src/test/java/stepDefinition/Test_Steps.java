package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Steps {
    private static WebDriver driver;

    @Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        System.setProperty("webdriver.chrome.driver","J:\\repository\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        driver.close();
    }

    @Given("User has navigated to <url>")
    public void user_has_navigated_to_url() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        String bodyText = driver.findElement(By.className("myaccount")).getText();
        Assert.assertTrue("page contains login notice", bodyText.contains("You must be logged in to use this page. Please use the form below to login to your account."));
    }

    @When("User enters <username> and <password>")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("log")).sendKeys("cuctest");
        driver.findElement(By.id("pwd")).sendKeys("Test123");

    }

    @When("User clicks login button")
    public void user_clicks_login_button() throws InterruptedException {
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);
    }

    @Then("My Account page is displayed")
    public void my_Account_page_is_displayed() {
        String accountDetails = driver.findElement(By.className("user-profile-links")).getText();
        Assert.assertTrue("Page contains account details", !accountDetails.isEmpty());
    }


}

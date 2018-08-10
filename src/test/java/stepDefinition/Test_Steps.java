package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Steps {
    private static WebDriver driver;

    @Before
    public void beforeScenario() throws Exception{
        System.out.println("This is the before Scenario initialization");
        System.setProperty("webdriver.chrome.driver", Test_Steps.class.getResource("/chromedriver/chromedriver.exe").getFile());
        driver = new ChromeDriver();
    }

    @After
    public void afterScenario() throws Exception{
        System.out.println("This is the after Scenario cleanup");
        driver.quit();
    }

    @Given("User has navigated to (.*) with message (.*)$")
    public void user_has_navigated_to_url(String url, String loginMessage) throws Exception{
        driver.get(url);
        String bodyText = driver.findElement(By.className("myaccount")).getText();
        Assert.assertTrue("Page contains login notice", bodyText.contains(loginMessage));
    }

    @When("User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) throws Exception{
        driver.findElement(By.id("log")).sendKeys(username);
        driver.findElement(By.id("pwd")).sendKeys(password);

    }

    @When("User clicks login button")
    public void user_clicks_login_button() throws Exception {
        WebElement login = driver.findElement(By.id("login"));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        login.click();
        wait.until(ExpectedConditions.stalenessOf(login));
    }

    @Then("My Account page is displayed")
    public void my_Account_page_is_displayed() throws Exception{
        String accountDetails = driver.findElement(By.className("user-profile-links")).getText();
        Assert.assertTrue("Page contains account details", !accountDetails.isEmpty());
    }


    @Given("User has navigated to (.*) with page title (.*)")
    public void user_has_navigated_to_homepage(String url, String homeTitle) {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), homeTitle);
    }

    @When("User selects (.*) from header menu")
    public void user_selects_menu_item_from_header_menu(String menuItemId) {
        driver.findElement(By.id(menuItemId)).click();
    }

    @Then("Apropriate page with correct (.*) is loaded")
    public void apropriate_page_with_correct_page_title_is_loaded(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }


}

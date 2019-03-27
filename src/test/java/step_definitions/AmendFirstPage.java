package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmendFirstPage {
    WebDriver driver;
    dataProviders.ConfigFileReader configFileReader;

    @Given("^I open the settings page$")
    public void I_open_the_settings_page() throws Throwable {
        configFileReader = new ConfigFileReader();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // URL set to the NetD Demo site - change to the AWS instance for test
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
        // Find the H2 text value of the login box
        assertTrue(driver.findElement(By.cssSelector("#login-box > h2")).isDisplayed());
        String loginPage = driver.findElement(By.cssSelector("#login-box > h2")).getText();
        assertEquals("LOGIN",loginPage);

        driver.findElement(By.cssSelector("#UID")).sendKeys(configFileReader.getUserName());
        driver.findElement(By.cssSelector("#PWD")).sendKeys(configFileReader.getPassword());
        driver.findElement(By.cssSelector("#login-box > form > input[type=\"submit\"]:nth-child(6)")).click();
        //driver.switchTo().alert().accept();

        //click on admin
        driver.findElement(By.linkText("ADMINISTRATOR System")).click();
    }

    @Given("^amend the user preference first screen to Learn$")
    public void amend_user_preference_first_screen_to_Learn() throws Throwable {
        //select Learn from dropdown
        Select firstScreen = new Select(driver.findElement(By.id("IU")));
        firstScreen.selectByVisibleText("Learn");
        //click on Submit button
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/form/div/input[1]")).click();
        //click ok on popup
        driver.switchTo().alert().accept();
    }

    // Add a properties file to manage login info, refactor this section
    @When("^I re-login$")
    public void I_re_login() throws Throwable {
        //log out
        driver.findElement(By.xpath("//*[@id=\"navigation-container\"]/div[4]/ul/li[5]/a")).click();

        driver.manage().window().maximize();
        // Find the H2 text value of the login box
        assertTrue(driver.findElement(By.cssSelector("#login-box > h2")).isDisplayed());
        String loginPage = driver.findElement(By.cssSelector("#login-box > h2")).getText();
        assertEquals("LOGIN",loginPage);

        driver.findElement(By.cssSelector("#UID")).sendKeys(configFileReader.getUserName());
        driver.findElement(By.cssSelector("#PWD")).sendKeys(configFileReader.getPassword());
        driver.findElement(By.cssSelector("#login-box > form > input[type=\"submit\"]:nth-child(6)")).click();
        //driver.switchTo().alert().accept();
    }

    @Then("^I am on the Learn page$")
    public void I_am_on_the_learn_page() throws Throwable {
        assertTrue(driver.getTitle().contains("Learn"));

        driver.quit();
    }

}
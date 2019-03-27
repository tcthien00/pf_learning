package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Login {
    WebDriver driver;
    dataProviders.ConfigFileReader configFileReader;

    @Given("^I am on the login page$")
    public void I_am_on_the_login_page() throws Throwable {
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
    }

    @When("^I input the login details$")
    public void I_input_the_login_details() throws Throwable {
        driver.findElement(By.cssSelector("#UID")).sendKeys(configFileReader.getUserName());
        driver.findElement(By.cssSelector("#PWD")).sendKeys(configFileReader.getPassword());
        driver.findElement(By.cssSelector("#login-box > form > input[type=\"submit\"]:nth-child(6)")).click();
        //driver.switchTo().alert().accept();
    }

    @Then("^I am on the landing page$")
    public void I_am_on_the_landing_page() throws Throwable {
        String h2Value = driver.findElement(By.cssSelector("#column_0 > div > div.widget-header.row_0 > span")).getText();
        //switch the statement below to use the NetD shared env (other one is for a new AWS env)
        //assertEquals("ACTIVITY LOG",h2Value);
        assertEquals("RECENT ACTIVITY",h2Value);
        driver.quit();
    }
}
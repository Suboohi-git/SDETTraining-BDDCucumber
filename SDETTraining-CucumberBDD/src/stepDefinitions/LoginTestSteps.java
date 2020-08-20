package stepDefinitions;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Log page$")
    public void loginPage() {
        //Setup instances
    	String drivePath= System.getProperty("user.dir")
    			+File.separator
    			+"drivers"
    			+File.separator
    			+"geckodriver.exe";
        //System.out.println();
    	System.out.println(drivePath);
    	System.setProperty("webdriver.gecko.driver", drivePath);
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    
    @When("^User enter username and password$")
    public void enterCredentialss() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    
    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
    	System.out.println("This part is complete "+ username);
        driver.findElement(By.id("username")).sendKeys(username);
        System.out.println(driver.getTitle());
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("This part is complete");
    }
    
    @Then("^Read the page title and confirm message$")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

        //Assertion
        //Assert.assertEquals(confirmMessage, "Welcome Back, admin");
        if(confirmMessage.contains("admin")) {
            Assert.assertEquals(confirmMessage, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmMessage, "Invalid Credentials");
        }
    }
    
    @And("^Close all Browser$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}
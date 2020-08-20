package stepDefinitions;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuiteCRMAct1 {
	
	WebDriver driver;
    WebDriverWait wait;
    List<WebElement> dashElem;
    
    @Given("^User is on CRM Login page1$")
    public void loginPage() {
        //Setup instances
    	String drivePath= System.getProperty("user.dir")
				+File.separator
				+"drivers"
				+File.separator
				+"geckodriver.exe";
		System.out.println(drivePath);
		
		System.setProperty("webdriver.gecko.driver", drivePath);
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }
    
    @When("^User enters username and password1$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("bigbutton")).click();
    }
    
    @Then("^Count the dashlet numbers$")
    public void getdashletelement() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dashletPanel']")));
        //Thread.sleep(5000);
        //Read the page title and heading
        String pageTitle = driver.getTitle();      
        System.out.println("Page title is: " + pageTitle);
        
        dashElem=driver.findElements(By.xpath("//*[@class='dashlet-title']"));
        System.out.println(dashElem.size());
        
    }
    
    
    @And("^print dashlet number and title$")
    public void printDashletDetails() {
    	int i=1;
    	for (WebElement dashitem : dashElem) {
    		
    		System.out.println("Item num: " + i +" has title: "+dashitem.getText());
    		//findElement(By.xpath("//*[starts-with(@class,'suitepicon suitepicon-module')]")).getText()
        	i++;
        } 	
        
    }
    
    @And("^Close the Browser1$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
    
}

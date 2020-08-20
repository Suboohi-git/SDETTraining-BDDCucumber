package stepDefinitions;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuiteCRMAct2 {
	
	WebDriver driver;
    WebDriverWait wait;
    
    
    @Given("^User is on CRM Login page2$")
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
    
    @When("^User enters username and password2$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("bigbutton")).click();
    }
    
    @Then("^Navigate to sales and create lead$")
    public void CreateLead() throws InterruptedException {
    	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dashletPanel']")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();   
        System.out.println("Page title is: " + pageTitle);
        
        Actions action= new Actions(driver);
        WebElement sales=driver.findElement(By.xpath("//*[@id='grouptab_0']"));
        action.moveToElement(sales).perform();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id='moduleTab_9_Leads']")).click();
        driver.findElement(By.linkText("Leads")).click();
       /* WebElement leads=driver.findElement(By.xpath("//*[@id='moduleTab_9_Leads']"));
        action.moveToElement(leads).perform();
        leads.click();
        */
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-action-name='Create']")));
	
        driver.findElement(By.xpath("//*[@data-action-name='Create']")).click();
             
        
    }
    
    
        
    @And("^fill the details \"(.*)\" and \"(.*)\" save$")
    public void enterPleadandSave(String frName, String lsName) {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("salutation"))); 	
    	
    	WebElement Selectele= driver.findElement(By.id("salutation"));
        Select selObj= new Select(Selectele);
        selObj.selectByIndex(1);
        driver.findElement(By.id("first_name")).sendKeys(frName);;
        driver.findElement(By.id("last_name")).sendKeys(lsName);;
    	driver.findElement(By.id("SAVE")).click();
        
    	
        
    }
    
    @And("^Navigate to lead page see the result$")
    public void printDashletDetails1() {
    	
    	driver.findElement(By.xpath("//*[@data-action-name='List']")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='oddListRowS1'][1]")));
    	
    	
    }
    
    @And("^Close the Browser2$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}

package stepDefinitions;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuiteCRMAct4 {
	
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String PName;
    
    
    @Given("^User is on CRM Login page4$")
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
        js = (JavascriptExecutor) driver;
    }
    
    @When("^User enters username and password4$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("bigbutton")).click();
    }
    
    @Then("^Navigate to product create product$")
    public void CreateLead() throws InterruptedException {
    	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dashletPanel']")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();   
        System.out.println("Page title is: " + pageTitle);
        
        Actions action= new Actions(driver);
        WebElement activitiesss=driver.findElement(By.xpath("//*[@id='grouptab_5']"));
        action.moveToElement(activitiesss).perform();
        Thread.sleep(2000);
        
        WebElement leads=driver.findElement(By.linkText("Products"));
        action.moveToElement(leads).perform();
        leads.click();
        //driver.findElement(By.id("moduleTab_9_Meetings")).click();
        //driver.findElement(By.linkText("Meetings")).click();
       
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-action-name='Create']")));
	
        driver.findElement(By.xpath("//*[@data-action-name='Create']")).click();
             
        
    }
    
    
    @And("^Retrive \"(.*)\" and \"(.*)\" and enter product and save$")
    public void enterPleadandSave(String ProdName, String strPrice) throws InterruptedException {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("name"))); 	
    	
    	PName=ProdName;
    	driver.findElement(By.id("name")).sendKeys(ProdName);
    	driver.findElement(By.id("price")).sendKeys(strPrice);
    	
    	WebElement scrFname=driver.findElement(By.id("SAVE"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrFname);
    	//js.executeScript("arguments[0].scrollIntoView();", scrFname);
    	//js.executeScript("window.scrollBy(0,1000)");
    	  	
    	//click save
    	scrFname.click();    	
    	
    }
    
    @And("^Goto view product and see the product$")
    public void printDashletDetails1() {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Email Settings")));
        driver.findElement(By.xpath("//*[@data-action-name='List']")).click();
    	
        
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
    	String frstProd= driver.findElement(By.partialLinkText(PName)).getText();
    	System.out.println(frstProd);
    	
    	Assert.assertEquals(PName, frstProd);
    	
    	
    }
    
    @And("^Close the Browser4$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }



}

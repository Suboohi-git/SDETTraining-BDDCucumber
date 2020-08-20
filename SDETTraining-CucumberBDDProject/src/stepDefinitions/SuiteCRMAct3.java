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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuiteCRMAct3 {
	
	WebDriver driver;
    WebDriverWait wait;
    String Subline;
    JavascriptExecutor js;
    
    
    @Given("^User is on CRM Login page3$")
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
    
    @When("^User enters username and password3$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("bigbutton")).click();
    }
    
    @Then("^Navigate to meeting Schedule Meeting$")
    public void CreateLead() throws InterruptedException {
    	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dashletPanel']")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();   
        System.out.println("Page title is: " + pageTitle);
        
        Actions action= new Actions(driver);
        WebElement activitiesss=driver.findElement(By.xpath("//*[@id='grouptab_3']"));
        action.moveToElement(activitiesss).perform();
        Thread.sleep(2000);
        
        WebElement leads=driver.findElement(By.xpath("//*[@id='moduleTab_9_Meetings']"));
        action.moveToElement(leads).perform();
        leads.click();
        //driver.findElement(By.id("moduleTab_9_Meetings")).click();
        //driver.findElement(By.linkText("Meetings")).click();
       
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-action-name='Schedule_Meeting']")));
	
        driver.findElement(By.xpath("//*[@data-action-name='Schedule_Meeting']")).click();
             
        
    }
    
    
    @And("^search for user \"(.*)\" , \"(.*)\" and \"(.*)\" , \"(.*)\" add and save$")
    public void enterPleadandSave(String UFname1, String ULname1, String UFname2, String ULname2) throws InterruptedException {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("name"))); 	
    	
    	Subline="This is a test meet2";
    	driver.findElement(By.id("name")).sendKeys(Subline);
    	
    	WebElement scrFname=driver.findElement(By.id("search_first_name"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrFname);
    	//js.executeScript("arguments[0].scrollIntoView();", scrFname);
    	//js.executeScript("window.scrollBy(0,1000)");
    	
    	//Add first user
    	scrFname.sendKeys(UFname1);;
        driver.findElement(By.id("search_last_name")).sendKeys(ULname1);;
    	driver.findElement(By.id("invitees_search")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("invitees_add_1")).click();
    	
    	//Add second user
    	scrFname.clear();
    	scrFname.sendKeys(UFname2);
    	driver.findElement(By.id("search_last_name")).clear();
        driver.findElement(By.id("search_last_name")).sendKeys(ULname2);;
    	driver.findElement(By.id("invitees_search")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("invitees_add_1")).click();
    	
        //Saving the meeting
    	
    	driver.findElement(By.id("SAVE_HEADER")).click();
    	
    }
    
    @And("^Navigate to meeting page and confirm meeting creation$")
    public void printDashletDetails1() {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Email Settings")));
        driver.findElement(By.xpath("//*[@data-action-name='List']")).click();
    	
        
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("module-title-text")));
    	String Firstmeet= driver.findElement(By.partialLinkText(Subline)).getText();
    	System.out.println(Firstmeet);
    	
    	Assert.assertEquals(Subline, Firstmeet);
    	
    	
    }
    
    @And("^Close the Browser3$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }


}

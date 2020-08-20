package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobPortalAct {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Alchemy Jobs Login page$")
    public void loginPage() {
    	
    	String drivePath= System.getProperty("user.dir")
				+File.separator
				+"drivers"
				+File.separator
				+"geckodriver.exe";
		System.out.println(drivePath);
		
		System.setProperty("webdriver.gecko.driver", drivePath);
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-login.php?");
    }
    
    @Given("^Open browser with Alchemy Jobs site and navigate to Jobs page$")
    public void openJobSite() throws InterruptedException {
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu-item-24\"]/a")));
        
        driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
        Thread.sleep(3000);
    }
    
    @Given("^Open browser with Alchemy Jobs site and navigate to Post Jobs page$")
    public void openJobPostSite() throws InterruptedException {
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu-item-24\"]/a")));
        
        driver.findElement(By.xpath("//*[@id=\"menu-item-26\"]/a")).click();
        Thread.sleep(3000);
    }
    
    @When("^fill in the details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void fillInJobDetails(String email, String job_title, String job_location, String job_description, String company) throws InterruptedException {
    	driver.findElement(By.id("create_account_email")).sendKeys(email);
    	driver.findElement(By.id("job_title")).sendKeys(job_title);
    	driver.findElement(By.id("job_location")).sendKeys(job_location);
    	driver.findElement(By.id("job_description_ifr")).sendKeys(job_description);
    	driver.findElement(By.id("application")).sendKeys(email);
    	driver.findElement(By.id("company_name")).sendKeys(company);
    	Thread.sleep(2000);
    }
    
    @And("^submit the details$")
    public void submitDetails() {
    	driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_preview_submit_button")));
    	driver.findElement(By.id("job_preview_submit_button")).click();
    }
    
    
    @Then("^Go to the Jobs page and Confirm job listing is shown on page$")
    public void moveToJobPage() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"menu-item-25\"]/a")).click();
    	Thread.sleep(3000);
    	List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='job_title']"));
    	list1.contains("Automation Analyst");
    	String jobTitle = list1.get(0).getText();
    	System.out.println(jobTitle);
    	
    }
    
    @Then("^Go to the Jobs page and Confirm job \"(.*)\" listing is shown on page$")
    public void moveJobPage(String job_title) throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"menu-item-25\"]/a")).click();
    	Thread.sleep(3000);
    	List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='job_title']"));
    	list1.contains(job_title);
    	String jobTitle = list1.get(0).getText();
    	System.out.println(jobTitle);
    	
    }
    
    @When("^Type in keywords to search for jobs and change the Job type to \"Full Time\" jobs$")
    public void searchJobKeyword() throws InterruptedException {
    	driver.findElement(By.id("search_keywords")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    	Thread.sleep(3000);
    	WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"job_type_full-time\"]"));
    	if(checkBox.isSelected()==true) {
    		System.out.println("CheckBox already selected..!");
    	}else {
    	driver.findElement(By.xpath("//*[@id=\"job_type_full-time\"]")).click();
    	Thread.sleep(3000);
    	}
    }
    
    @Then("^Find the title of the job listing using XPath and print it to the console$")
    public void printJobTitleOnConsle() {
    	driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]/a")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type = 'button']")));
    	String JobTitle = driver.findElement(By.xpath("//*[@class='entry-title']")).getText();
    	System.out.println("Title of the Job: "+JobTitle);
    	
    }
    
    @And("^Find and Click on the \"Apply for job\" button$")
    public void applyForJob() {
    	driver.findElement(By.xpath("//input[@type = 'button']")).click();
    	
    }
    
    
    
    
    @When("^User enters username and password$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("user_login")).sendKeys("root");
        //Enter password
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("wp-submit")).click();
    }
    
    
    @Then("^Locate the \"Add New\" button and click it$")
    public void readTitleAndHeading() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu-users\"]")));
        
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        driver.findElement(By.xpath("//*[@id=\"menu-users\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"menu-users\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);
        
    }
    
    @And("^Fill in the necessary details$")
    public void fillDetails() throws InterruptedException {
    	driver.findElement(By.id("user_login")).sendKeys("Test23");
    	driver.findElement(By.id("email")).sendKeys("tester123@gmail.com");
    	driver.findElement(By.id("first_name")).sendKeys("Test1");
    	driver.findElement(By.id("last_name")).sendKeys("Test2");
    	WebElement roleId = driver.findElement(By.id("role"));
    	Select role = new Select(roleId);
    	role.selectByIndex(5);
    	
    	
    }
    
    @And("^Click the \"Add New User\" button$")
    public void clickAddButton() throws InterruptedException {
    	driver.findElement(By.id("createusersub")).click();
    	Thread.sleep(5000);
    	
    	
        
    }
    
    @And("^Verify that the user was created$")
    public void verifyDetailsAdded() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/ul/li[2]/a")).click();
    	Thread.sleep(5000);
    	String name = driver.findElement(By.partialLinkText("Jags46")).getText();
    	assertEquals("Jags46", name);
        
    }
    
    
    @And("^close the browser$")
    public void teardown() {
    	driver.close();
    }
    
	
}

package webAppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

public class BrowserTest {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver" , "D:\\Users\\Umakiran\\Desktop\\WebApp-SOBI\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://localhost:9090/WebApp-SOBI/index.jsp");

	}*/
	
	public static WebDriver driver=null;
	public static  ExtentHtmlReporter htmlReporter ;
	public static  ExtentReports extent;
	public static  ExtentTest test ;
	public static  ExtentTest test1 ;

	@BeforeSuite
	public void beforeSuite() {
	 htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
	    
     // create ExtentReports and attach reporter(s)
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);

     // creates a toggle for the given test, adds all log events under it    
      test = extent.createTest("SOBI Web Application Test", "This is a test to validate Service Ops Web Application");
      test.log(Status.INFO, "Starting the test");
      test1 = extent.createTest("SOBI Login Valiadation", "Login Validation on Webpage");
      test1.log(Status.INFO, "Starting the test");
	}
	
	@Test (priority=1)
	public static void launchBrowser() {
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver" , projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
	    driver=new FirefoxDriver();
	    test.pass("Firefox Browser Launched");
	}
	
	@Test (priority=2)
	public static void launchApplication() {
		driver.get("http://localhost:9090/WebApp-SOBI/index.jsp");
		Assert.assertEquals("Service Ops",driver.getTitle());	
		test.pass("Navigated to Service Ops URL");
	}
	@Test (priority=3) 
	public static void launchLogin() { 
		
		driver.findElement(By.name("btn")).click();
		Assert.assertTrue(driver.findElement(By.name("loginbtn")).isDisplayed());
		test1.pass("Login Form Launched");
		
	}
	@Test (priority=4) 
	public static void loginValidation() { 
		
		driver.findElement(By.name("uname")).sendKeys("sobiadmin");
		driver.findElement(By.name("psw")).sendKeys("admin123");
		driver.findElement(By.name("loginbtn")).click();
		Assert.assertEquals("SOBI Home Page",driver.getTitle());
		test1.pass("Login is successfull");
		//Assert.assertTrue(driver.findElement(By.name("loginbtn")).isDisplayed());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test (priority=5) 
	public static void videoValidation() {
		driver.findElement(By.id("video")).click();
		test1.pass("Play video on the page");
		//Assert.assertTrue(driver.findElement(By.name("loginbtn")).isDisplayed());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test (priority=6) 
	public static void logoutValidation() {
		driver.findElement(By.name("logoutbtn")).click();
		Assert.assertEquals("Service Ops",driver.getTitle());
		test1.pass("Logout validation");
		test.fail("Logout failed");
		//Assert.assertTrue(driver.findElement(By.name("loginbtn")).isDisplayed());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (priority=7)
	public static void closeBrowser() {
		driver.close();
		test.pass("Browser closed");
		//driver.quit();
		extent.flush();
		
		
	}
}

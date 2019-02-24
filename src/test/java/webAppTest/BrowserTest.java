package webAppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BrowserTest {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver" , "D:\\Users\\Umakiran\\Desktop\\WebApp-SOBI\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://localhost:9090/WebApp-SOBI/index.jsp");

	}*/
	
	public static WebDriver driver=null;
	
	@Test (priority=1)
	public static void launchBrowser() {
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver" , projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
	    driver=new FirefoxDriver();
	}
	
	@Test (priority=2)
	public static void launchApplication() {
		driver.get("http://localhost:9090/WebApp-SOBI/index.jsp");
		Assert.assertEquals("Service Ops",driver.getTitle());	
	}
	@Test (priority=3) 
	public static void launchLogin() { 
		
		driver.findElement(By.name("btn")).click();
		Assert.assertTrue(driver.findElement(By.name("loginbtn")).isDisplayed());
		
	}
	@Test (priority=4) 
	public static void loginValidation() { 
		
		driver.findElement(By.name("uname")).sendKeys("sobiadmin");
		driver.findElement(By.name("psw")).sendKeys("admin123");
		driver.findElement(By.name("loginbtn")).click();
		Assert.assertEquals("SOBI Home Page",driver.getTitle());
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
		
	}
}

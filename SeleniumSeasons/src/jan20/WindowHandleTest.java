package jan20;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleTest {
	WebDriver driver;
	@BeforeMethod 
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void Test() throws InterruptedException 
	{
		
String homeWindowId=driver.getWindowHandle();
driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).
click();




switchToWindow("NotFound");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		Thread.sleep(5000);
driver.findElement(By.xpath("//input[@value='Search']")).click();
Thread.sleep(5000);
		driver.switchTo().window(homeWindowId);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).
		click();
		Thread.sleep(5000);
		
		
	
		switchToWindow("TestFlight-Apple");
		driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().window(homeWindowId);
		Thread.sleep(5000);
	
		switchToWindow("Legal - Apple Media Services - Apple");
driver.findElement(By.xpath("//a[text()='Choose your country/region']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().window(homeWindowId);
		Thread.sleep(5000);
		
		
		
		
	}
	public void switchToWindow(String expectedtitle) throws InterruptedException {
		// TODO Auto-generated method stub
		Set<String> allWindowIds=driver.getWindowHandles();

		for(String windowId:allWindowIds)
		{
			driver.switchTo().window(windowId);
			Thread.sleep(5000);
			
			if(driver.getTitle().equalsIgnoreCase("NotFound")) {
				break;
			}
		}
	}

	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}

package jan16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {

	
		// TODO Auto-generated method stub
		WebDriver driver;
		@BeforeMethod
		public void setUp(){
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
		 driver=new ChromeDriver(options);
		driver.get("https://www.kvb.co.in/");
		driver.manage().window().maximize();
	}
		
		@Test
		public void mouseHoverTest() throws InterruptedException{
			Actions actions=new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[text()='Personal']")))
			.pause(3000)
		
			.moveToElement(driver.findElement(By.xpath("//a[text()='Loans ']")))
			.perform();
			Thread.sleep(6000);
		
		
			
		}
			@AfterMethod
			public void tearDown() {
				driver.quit();

	}

}

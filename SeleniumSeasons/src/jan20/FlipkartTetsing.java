package jan20;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FlipkartTetsing {
WebDriver driver;
	@BeforeMethod

public void setUp() {
	driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
}
	@Test
	public void FlipkartTetsing1() throws InterruptedException
	{
	driver.findElement(By.xpath("//input[@class='Pke_EE' and @title='Search for Products, Brands and More']")).sendKeys("samsung galaxy f05 twilight blue 64 gb");
	
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	//String homeWindowId=driver.getWindowHandle();
	
	driver.findElement(By.xpath("//img[@alt='SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)' and @class='DByuf4']")).click();
	
	switchToWindow("SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)  (4 GB RAM)");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	
	//button[@class='QqFHMw vslbG+ In9uk2' and text()='GO TO CART']
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	
	Thread.sleep(5000);
	}

	
	
	private void switchToWindow(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		Set<String> allWindowIds=driver.getWindowHandles();

		for(String windowId:allWindowIds)
		{
			driver.switchTo().window(windowId);
			Thread.sleep(5000);
			
			if(driver.getTitle().equalsIgnoreCase("SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)  (4 GB RAM)")) {
				break;
			}
		}
	}
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

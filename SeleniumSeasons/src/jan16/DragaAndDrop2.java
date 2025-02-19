package jan16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragaAndDrop2 {
	WebDriver driver;
	@BeforeMethod 
	public void setUp() {
		driver=new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void dragAndDrop() {
	//	driver.switchTo().frame(0);
		Actions action =new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loanamountslider']/span")	
			), 105, 0).pause(8000)
		.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loaninterestslider']/span")	
				), 105, 0).pause(9000)
		.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loantermslider']/span")	
				), 0, -100).pause(7000)
		.perform();
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

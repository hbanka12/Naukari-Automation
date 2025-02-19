package jan16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
WebDriver driver;
	@BeforeMethod 
	public void setUp() {
		driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void dragAndDrop() {
		driver.switchTo().frame(0);
		Actions action =new Actions(driver);
		action.dragAndDrop(driver.findElement(By.xpath("//p[text()='Drag me to my target']")	
				),driver.findElement(By.xpath("//div[@id='droppable']"))).perform();
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

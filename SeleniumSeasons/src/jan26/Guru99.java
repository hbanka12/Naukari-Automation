package jan26;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99 {
	
	WebDriver driver;
@BeforeMethod
public void setUp()
{
	driver =new ChromeDriver();
	driver.get("https://demo.guru99.com/test/guru99home/");
	driver.manage().window().maximize();
}
@Test
public void mainMethod() throws InterruptedException
{
	

	 driver.switchTo().frame("a077aa5e");
	 driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
	 Thread.sleep(3000);
	 //String homeWindowId=driver.getWindowHandle();
	 switchToWindow("Selenium Live Project for Practice");
	
	 List<WebElement> titles = driver.findElements(By.xpath("//p[text()='Top Tutorials']/ancestor::div[@class='wp-block-kadence-column inner-column-1 kadence-column_d1271a-a3']/descendant::span[@class='kt-blocks-info-box-title'][1]"));
	 
     // Loop through each book title and print it
  
     //   System.out.println(titles.getText());
	 for (WebElement title : titles) {
         System.out.println(title.getText());
     }
	 
     
	 
   
   //p[text()='Top Tutorials']/ancestor::div[@class='wp-block-kadence-column inner-column-1 kadence-column_d1271a-a3']/descendant::span[@class='kt-blocks-info-box-title']
}
private void switchToWindow(String string) throws InterruptedException {
	// TODO Auto-generated method stub
	Set<String> allWindowIds=driver.getWindowHandles();

	for(String windowId:allWindowIds)
	{
		driver.switchTo().window(windowId);
		Thread.sleep(5000);
		
		if(driver.getTitle().equalsIgnoreCase("Selenium Live Project for Practice")) {
			break;
			
			
		}}
		
}
@AfterMethod()
public void tearDown(){
	driver.quit();
}
{
	
}
}

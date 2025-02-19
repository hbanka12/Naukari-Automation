package dec26;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLinkTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
WebElement block=driver.findElement(By.xpath("//div[text()='CONSUMER POLICY']/parent::div"));
	List <WebElement> allLinks=block.findElements(By.tagName("a"));
	
	System.out.println("No of Links in CONSUMER POLICY Module "+allLinks.size());
	for(int i=0;i<allLinks.size();i++) 
	{
		try {
			driver.findElement(By.xpath("//span[@role='button']")).click();
			Thread.sleep(3000);
			}
			
			catch(NoSuchElementException e){
				
			}
		
		WebElement links=allLinks.get(i);
		System.out.println(links.getText());
		System.out.println(links.getAttribute("href"));
		links.click();
		   Thread.sleep(3000);
		   System.out.println(driver.getCurrentUrl());
		   System.out.println(driver.getTitle());
		   driver.navigate().back();
		   Thread.sleep(3000);
		   
		  block= driver.findElement(By.xpath("//div[text()='CONSUMER POLICY']/parent::div"));
			allLinks=block.findElements(By.tagName("a"));
	}
	
	
	driver.quit();
	
	
	}

}

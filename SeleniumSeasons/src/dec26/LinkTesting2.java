package dec26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LinkTesting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver=new EdgeDriver();
		   driver.get("https://www.amazon.com/");
		   driver.manage().window().maximize();
		 WebElement block = driver.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
	
	
	List <WebElement> allLinks=block.findElements(By.tagName("a"));
	System.out.println(allLinks.size());
	for(WebElement temp:allLinks)
	{
		System.out.println(temp.getText());
	
	
	
	}
driver.quit();
}}

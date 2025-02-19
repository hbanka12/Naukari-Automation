package dec26;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   WebDriver driver=new ChromeDriver();
   driver.get("https://adactinhotelapp.com/");
   driver.manage().window().maximize();
   List<WebElement> allLinks=driver.findElements(By.tagName("a"));
   System.out.println(allLinks.size());
   
   for(int i=0;i<allLinks.size();i++)
   {
	   System.out.println(allLinks.get(i).getText());
   }
	}

}

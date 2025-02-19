package dec27;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DropdownTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver =new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
List<WebElement> allItems=drop.findElements(By.tagName("option"));

System.out.println(allItems.size());

for(int i=0;i<allItems.size();i++)
{

	System.out.println(allItems.get(i).getText());
}
driver.quit();
	}}


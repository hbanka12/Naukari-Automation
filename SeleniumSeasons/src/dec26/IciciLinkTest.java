package dec26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IciciLinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.icicibank.com/");
driver.manage().window().maximize();
//Find the block containing the "Customer Service" text
WebElement block = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]/ancestor::div[2]"));
//Find all <a> elements inside the block
List<WebElement> allLinks = block.findElements(By.tagName("a"));

System.out.println(allLinks.size());
for(WebElement temp:allLinks)
{
	System.out.println(temp.getText());
}
driver.quit();
	}

}

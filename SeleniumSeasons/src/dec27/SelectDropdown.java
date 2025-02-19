package dec27;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   WebDriver driver=new EdgeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
WebElement drop =driver.findElement(By.id("searchDropdownBox"));
Select s1=new Select(drop);
List<WebElement> allIteams=s1.getOptions();

System.out.println(allIteams.size());
driver.findElement(By.id("searchDropdownBox")).sendKeys("Alexa Skills");
driver.findElement(By.id("nav-search-submit-button")).click();
/*for(int i=0;i<allIteams.size();i++)
{
	
	System.out.println(allIteams.get(i).getText());
}*/
driver.quit();
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Startrone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.google.com/");
WebElement element=driver.findElement(By.xpath("//textarea[@name='q' and @role='combobox']"));
element.sendKeys("Selenium WebDriver");
element.submit();
String pagetitle=driver.getTitle();
System.out.println(pagetitle);
driver.quit();
	}

}

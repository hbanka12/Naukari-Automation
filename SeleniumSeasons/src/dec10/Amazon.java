package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harry potter books");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.quit();
	}

}

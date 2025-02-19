package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverInMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hbanka");
		//Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("hbanka@123");
		driver.findElement(By.id("login")).click();
		//System.out.println(driver.findElement(By.id("username_span")).getText());
		Thread.sleep(3000);
		driver.quit();
		
		
		
		

	}

}

package feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Naukari {
	WebDriver driver;
	@BeforeSuite
	public void Login() throws InterruptedException
	{
		driver=new ChromeDriver ();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
@Test
public void Update() throws InterruptedException
{
	driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("harikabanka805@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Banka@123");
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	
	driver.findElement(By.linkText("View profile")).click();
	driver.findElement(By.xpath("//em[text()='editOneTheme']")).click();
	WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
	ele.clear();
		
			
			driver.findElement(By.id("saveBasicDetailsBtn")).click();
	Thread.sleep(3000);
}

@AfterTest
public void Teardown()
{
	driver.quit();
}
}

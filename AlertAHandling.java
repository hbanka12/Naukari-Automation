package feb17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertAHandling {
WebDriver driver;
	
	@BeforeSuite
	public void Login()
	{
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
	}
	@Test
	public void Alert()
	{
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		org.openqa.selenium.Alert al=driver.switchTo().alert();
		Assert.assertEquals(al.getText(), "Please enter a valid user name");
		al.accept();
	
	}
	
	@AfterSuite
	public void Teardown()
	{
		driver.quit();
	}
}

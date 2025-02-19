package jan26;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewGuru99 {
WebDriver driver;
@BeforeMethod
public void setUp()
{
	driver=new ChromeDriver();
	driver.get("https://demo.guru99.com/V4/");
	driver.manage().window().maximize();
	
}
@Test
public void mainMethod() throws InterruptedException
{
	driver.findElement(By.name("uid")).sendKeys("mngr610594");
	driver.findElement(By.name("password")).sendKeys("perYqer");
	driver.findElement(By.name("btnLogin")).click();
	
	
	driver.findElement(By.xpath("//a[text()='Delete Customer']")).click();
	driver.findElement(By.name("cusid")).sendKeys("608681");
	driver.findElement(By.name("AccSubmit")).click();
	Alert a1=driver.switchTo().alert();
	Assert.assertEquals(a1.getText(), "Do you really want to delete this Customer?");
	a1.accept();

	Assert.assertEquals(a1.getText(), "Customer does not exist!!");
	a1.accept();
	Thread.sleep(3000);
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}

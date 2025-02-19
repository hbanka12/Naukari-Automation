package jan9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLogin {
	
	WebDriver driver;
@BeforeMethod
public void start(){
	 driver=new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}
	
	@Test
	public void validateLoginUsingValidUserNameAndValidPassword() {
		
		driver.findElement(By.id("username")).sendKeys("reyaz0806");
			driver.findElement(By.name("password")).sendKeys("reyaz123");
	driver.findElement(By.id("login")).click();
	
	Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
	
	
	}
	@Test
	public void validateLoginUsingInValidUserNameAndValidPassword() {
		
		driver.findElement(By.id("username")).sendKeys("reyaz006");
			driver.findElement(By.name("password")).sendKeys("reyaz123");
	driver.findElement(By.id("login")).click();
	
	Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
	
	
	}
	@Test
	public void validateLoginUsingInValidUserNameAndInValidPassword(){
		
		driver.findElement(By.id("username")).sendKeys("reaz0806");
			driver.findElement(By.name("password")).sendKeys("reaz123");
	driver.findElement(By.id("login")).click();
	
	Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
	
	
	}
	@Test
	public void validateLoginUsingValidUserNameAndInValidPassword() {
		
		driver.findElement(By.id("username")).sendKeys("reyaz0806");
			driver.findElement(By.name("password")).sendKeys("reaz123");
	driver.findElement(By.id("login")).click();
	
	Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
	
	
	}
}

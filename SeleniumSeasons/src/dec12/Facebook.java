package dec12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
  WebDriver driver=new ChromeDriver();
  driver.get("https://www.facebook.com/");
  driver.manage().window().maximize();
  //driver.findElement(By.id("u_0_0_vX")).click();
//driver.findElement(By.id("email")).sendKeys("harika.ban@gmail.com");
		
	//driver.findElement(By.id("pass")).sendKeys("Banka@123");
 
		//driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
		 driver.findElement(By.name("firstname")).sendKeys("Martin");
		  driver.findElement(By.name("lastname")).sendKeys("Konkala");
new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText("13");
new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText("Mar");
new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("2000");
Thread.sleep(3000);
//driver.findElement(By.linkText("Female")).click();
Thread.sleep(3000);
driver.findElement(By.name("reg_email__")).sendKeys("martinkonakala@gmail.com");
Thread.sleep(3000);
driver.findElement(By.name("reg_passwd__")).sendKeys("martin123");
Thread.sleep(3000);
driver.findElement(By.linkText("Sign Up")).click();


Thread.sleep(10000);
		driver.quit();
	}

}

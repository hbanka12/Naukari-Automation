package dec12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodsInWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("harika");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("banka");
		Thread.sleep(6000);
		driver.findElement(By.id("login")).click();
		System.out.println(driver.getTitle());
		
        
		
		///WebElement textBox = driver.findElement(By.id("username"));
		//textBox.sendKeys("oldusername");
		
		//Thread.sleep(6000);
		//textBox.clear(); // Clears the existing text
		//textBox.sendKeys("newusername"); // Types new text into the textbox
		
	}

}

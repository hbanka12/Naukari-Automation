package dec9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextGenInspectors {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		// TODO Auto-generated method stub
		
		driver.get("https://www.nextgeninspectors.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.linkText("Schedule Your Inspection")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("Schedule Online")).click();
		
		//Thread.sleep(3000);
		//driver.navigate().back();
		
		driver.quit();

	}

}

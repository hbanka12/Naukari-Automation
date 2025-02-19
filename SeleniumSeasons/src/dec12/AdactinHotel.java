package dec12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdactinHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("harika");
		List<WebElement> links = driver.findElements(By.tagName("a"));//// Find all links on the page
		System.out.println("Total links: " + links.size());
		System.out.println(driver.getCurrentUrl());//URL of the page currently loaded in the browser
		System.out.println(driver.getPageSource());//// Prints the HTML source code of the page
		
		System.out.println(driver.getTitle());// Prints the title of the page
		System.out.println(driver.getWindowHandle());//returns a unique identifier for the current browser window. This is useful when you have multiple windows/tabs open.
		
		
		
		System.out.println(driver.getWindowHandles());//same as bove but this is for two or more
		
		
		driver.manage().window().maximize(); // Maximize the browser window
		driver.findElement(By.linkText("New User Register Here")).click();
		
		driver.navigate().back(); // Go back to the previous page (Google)
		driver.navigate().forward(); // Go forward to the next page (YouTube)
		driver.navigate().refresh();
		driver.navigate().to("https://www.youtube.com"); // Navigate to YouTube
		 // Refresh the page
		driver.switchTo().alert().accept(); // Switch to alert and accept it
		driver.switchTo().frame("iframeName"); // Switch to an iframe with name 'iframeName'
		driver.quit();// Closes all windows and ends the session
		
	}

}

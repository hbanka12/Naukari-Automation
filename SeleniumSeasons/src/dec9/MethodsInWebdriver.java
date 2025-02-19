package dec9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodsInWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.youtube.com/");
		
				//driver.get("https://pmiv.service-now.com.mcas.ms/now/nav/ui/classic/params/target/task_list.do%3Fsysparm_userpref_module%3D1523b8d4c611227b00be8216ec331b9a%26sysparm_query%3Dactive%253Dtrue%255Eassigned_toDYNAMIC0f63961e5f510100a9ad2572f2b47745%255Estate%2521%253D6%255EEQ");
			
			
			
			
			
		
		//get method
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		//gettitle===Adactin.com - Hotel Reservation System
		System.out.println(driver.getTitle());
		///getCurrentUrl===https://adactinhotelapp.com/
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		//https://adactinhotelapp.com/ForgotPassword.php
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		
		System.out.println(driver.getWindowHandles());
		
		
		//driver.close();
		driver.quit();
		
		
			
	
	
	
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByIndex(5);
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByValue("search-alias=stripbooks");	
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}

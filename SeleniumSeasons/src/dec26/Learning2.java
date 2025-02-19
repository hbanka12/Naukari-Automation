package dec26;

import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Learning2 {
	    WebDriver driver;
	    JavascriptExecutor jse;

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://www.amazon.in/");
	        driver.manage().window().maximize();
	        jse = (JavascriptExecutor) driver;
	    }

	    @Test
	    public void AmazonTesting() throws InterruptedException {
	        // Perform sign-in
	        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
	        driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys("harikachikky9@gmail.com");
	        driver.findElement(By.xpath("//input[@type='submit']")).click();
	        
	        // Wait for password field to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
	        
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Banka@123");
	        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

	       
	        WebElement dropdown_element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	    	Select s1=new Select(dropdown_element );
	    	s1.selectByVisibleText("Watches");
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Fossil Fb-01 Analog Dial Women's Watch-CE1125");

	    	
	    	driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
	    	Thread.sleep(2000);
	    	
	        
	    }
	  
		@AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}



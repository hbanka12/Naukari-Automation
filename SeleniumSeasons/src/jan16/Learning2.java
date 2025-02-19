package jan16;


	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Learning2 {
	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Initialize EdgeDriver
	        driver = new ChromeDriver();
	        driver.get("https://www.amazon.in/");
	        driver.manage().window().maximize();
	    }

	    String watchname = "Fossil Fb-01 Analog Dial Women's Watch-CE1125";
	    String Watchele = "//img[@alt=\"Sponsored Ad - Fossil Fb-01 Analog Dial Women's Watch-CE1125\"]";

	    @Test
	    public void AmazonTesting() throws InterruptedException {
	        // Perform hover and click on sign-in
	        Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Hello, sign in']"))).perform();
	        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

	        // Log in
	        driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys("harikachikky9@gmail.com");
	        driver.findElement(By.xpath("//input[@type='submit']")).click();
	        Thread.sleep(2000); // Add WebDriverWait for better reliability
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Banka@123");
	        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

	        // Select "Watches" from dropdown and search
	        WebElement dropdown_element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	        Select s1 = new Select(dropdown_element);
	        s1.selectByVisibleText("Watches");
	        Thread.sleep(2000); // Replace with WebDriverWait if necessary
	        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(watchname);
	        driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
	        Thread.sleep(2000);

	        // Scroll to the desired watch
	        WebElement element = driver.findElement(By.xpath(Watchele));
	        JavascriptExecutor js = (JavascriptExecutor) driver; // Initialize js here
	        js.executeScript("arguments[0].scrollIntoView(true);", element);

	        // Highlight the element (optional)
	        js.executeScript("arguments[0].style.color='3px solid red'", element);
	        Thread.sleep(3000);

	        // Click the element
	        element.click();
	        Thread.sleep(5000);

	        // Switch to the new tab
	        String originalWindow = driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(originalWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }

	        // Wait for the new tab to load completely (optional)
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
	                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
	        );

	        // Perform actions in the new tab (if needed)
	        System.out.println("Switched to new tab successfully.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


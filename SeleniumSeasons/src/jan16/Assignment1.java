package jan16;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 {
	WebDriver driver;
	@BeforeMethod 
	public void setUp() {
		driver=new ChromeDriver();
		
		driver.get("https://selenium-prd.firebaseapp.com/tabview.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
	}
	@Test
    public void dragAndDrop() throws InterruptedException {
        // Wait for the button to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement interactionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown']/button[contains(text(),'Intractions')]")));
        
        // Ensure the element is in the viewport
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", interactionsButton);
        
        // Perform the hover actions
        Actions action = new Actions(driver);
        action.moveToElement(interactionsButton)
              .moveToElement(driver.findElement(By.xpath("//a[text()='Double Click']"))).click()
              //.moveToElement(driver.findElement(By.xpath("//button[text()='Double Click']"))).doubleClick()
.perform();
        Thread.sleep(5000);
        
       
        for (int i = 0; i < 5; i++) {
        	
           	action.moveToElement(driver.findElement(By.xpath("//button[text()='Double Click']"))).doubleClick()
               .perform();
           	String scriptContent = driver.findElement(By.xpath("//script[contains(text(),'count++')]")).getText();

            // Step 2: Trigger the script using JavaScriptExecutor

            js.executeScript(scriptContent); // Executes the extracted JavaScript

            // Step 3: Wait for any necessary element to load after executing the script (if needed)
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Selenium")));

            // Step 4: Count elements matching the XPath
            List<WebElement> elements = driver.findElements(By.xpath("//p[@id='Selenium']"));
            int count = elements.size();
            

            System.out.println("Number of elements with id 'Selenium': " + count);
               Thread.sleep(1000);  // Optional: Adding a delay between double clicks for clarity
           }
        
        // Wait for a few seconds to observe the result
       Thread.sleep(5000);
       }	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

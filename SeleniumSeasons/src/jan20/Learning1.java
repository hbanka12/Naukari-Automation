package jan20;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Learning1 {
	
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test
    public void AmazonTesting() throws InterruptedException {
        // Perform sign-in operations
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys("harikachikky9@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        // Wait for the password field to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Banka@123");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        
        // Wait for the next page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='searchDropdownBox']")));
        
        // Select category from dropdown (e.g., Watches)
        WebElement dropdown_element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropdown_element.sendKeys("Watches");
        
        // Search for the Fossil watch
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Fossil Women Stainless Steel Stella Sport Analog Brown Dial Watch-Es5109");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
        
        // Wait for the results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Fossil Women Stainless Steel Stella Sport')]")));
        
        // Scroll to the desired product and highlight it
        scrollToElementAndHighlight(By.xpath("//img[@alt='Sponsored Ad - Fossil Women Stainless Steel Stella Sport Analog Brown Dial Watch-Es5109, Band Color-Rose Gold']"));
        
        // Click on the product after highlighting
        driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Fossil Women Stainless Steel Stella Sport Analog Brown Dial Watch-Es5109, Band Color-Rose Gold']")).click();

        // Wait for the product page to load (adjust as needed)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
    }

    // Method to scroll to a specific element and highlight it
    public void scrollToElementAndHighlight(By by) {
        WebElement element = driver.findElement(by);
        
        // Scroll to the element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Wait until the element is visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Highlight the element by changing its background color
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow';", element);

        // Optional: Wait for a while to see the highlight effect
        try {
            Thread.sleep(1000);  // Sleep for 1 second to view the highlight
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Reset the background color after highlighting
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '';", element);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}

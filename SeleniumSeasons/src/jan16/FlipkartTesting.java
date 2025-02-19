package jan16;



import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartTesting {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void flipkartTesting1() throws InterruptedException {
        // Initialize WebDriverWait with Duration for timeout (in seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close the login popup (if it appears)
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='✕']")));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Login popup not found or already closed.");
        }

        // Search for the product
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("samsung galaxy f05 twilight blue 64 gb");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Wait for the product image to be clickable
        WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//img[@alt='SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)']")));
        productImage.click();

        // Switch to the product window
        switchToWindow("SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)  (4 GB RAM)");
        
        JavascriptExecutor  jse= (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500);");
Thread.sleep(3000);
        // Wait for and click "Add to Cart"
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Add to cart']")));
        addToCartButton.click();
        //Thread.sleep(3000);
        // Wait for and click "Place Order"
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Place Order']")));
        placeOrderButton.click();
        
        driver.findElement(By.xpath("//input[@class='r4vIwl Jr-g+f']")).sendKeys("harikachikky9@gmail.com");
        Thread.sleep(6000);
        
       // driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
       
    
    
    
    
    }

    private void switchToWindow(String windowTitle) {
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String windowId : allWindowIds) {
            driver.switchTo().window(windowId);
            if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
                break;
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

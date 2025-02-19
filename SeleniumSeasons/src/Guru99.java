

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Set;

public class Guru99 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
    }
    
  

    @Test
    public void mainMethod() throws InterruptedException {
        // Switching to the iframe
        driver.switchTo().frame("a077aa5e");
       
        
        // Clicking on the image
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
       
        // Wait for the new window to open and switch to it
        switchToWindow("Selenium Live Project for Practice");
        
        WebElement element = driver.findElement(By.xpath("//p[text()='Top Tutorials']/ancestor::div[@class='wp-block-kadence-column inner-column-1 kadence-column_d1271a-a3']/descendant::span[@class='kt-blocks-info-box-title'][2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        
        
        //WebElement element= driver.findElement(By.xpath("//p[text()='Top Tutorials']/ancestor::div[@class='wp-block-kadence-column inner-column-1 kadence-column_d1271a-a3']/descendant::span[@class='kt-blocks-info-box-title'][1]"));
        //JavascriptExecutor js = (JavascriptExecutor) driver; // Initialize js here
        //js.executeScript("arguments[0].scrollIntoView(true);", element);
       // element.click();
        Thread.sleep(5000);
    }

    // Helper method to switch to a new window by title
    private void switchToWindow(String windowTitle) {
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String windowId : allWindowIds) {
            driver.switchTo().window(windowId);

            // Wait for the page title to match
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

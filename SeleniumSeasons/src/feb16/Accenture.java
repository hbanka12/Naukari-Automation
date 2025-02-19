package feb16;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Accenture {

    WebDriver driver;

    @BeforeSuite
    public void Login() {
        driver = new ChromeDriver();
        driver.get("https://www.accenture.com/us-en/careers/saved-jobs");
        driver.manage().window().maximize();
    }

    @Test
    public void Main() {
        String mainWindow = driver.getWindowHandle();

        // Wait for the "Access Application" button to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accessApplicationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Access Application']")));
        accessApplicationBtn.click();

        // Wait for the new window to open
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowId : allWindows) {
            if (!windowId.equals(mainWindow)) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        // Switch to the iframe inside the new window
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("LoginApp")));
        
        // Wait for the element to be clickable and click it
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Data Privacy Policy 0090']//ancestor::li[contains(., 'For Accenture employees and contractors:')])[1]")));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        // Switch back to the main window
        driver.switchTo().window(mainWindow);
    }

    @AfterSuite
    public void Teardown() {
        driver.quit();
    }
}

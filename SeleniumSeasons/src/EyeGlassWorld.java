import java.time.Duration;
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

public class EyeGlassWorld {

    WebDriver driver;
    String Watchele = "//label[text()='MM / DD / YYYY']";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.eyeglassworld.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void EyeGlassWorld1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='inputStoreValue']")).sendKeys("Mayo FL 32066");

        // Click the "Find a Store" button
        driver.findElement(By.xpath("//button[text()='Find a Store']")).click();

        try {
            // Wait for the "Find a Store" button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Find a Store']")));
            enableButton.click();
            System.out.println("The 'Find a Store' button was clickable and has been clicked.");
        } catch (Exception e) {
            System.out.println("The 'Find a Store' button is not clickable or an error occurred.");
        }

        // Click the "Orange Park" link
        driver.findElement(By.xpath("//a[text()='Orange Park']")).click();

        // Wait for and click the "Schedule Exam" link
        WebElement SE = driver.findElement(By.xpath("//a[text()='Schedule Exam']"));
        SE.click();

        // Answer 'Yes' to having had an exam
        driver.findElement(By.id("hadExamYes")).click();

        // Select "Exam Type"
        driver.findElement(By.id("examTypeFrames")).click();

        // Select 'No' for eye exam check
        driver.findElement(By.id("examCheckNo")).click();

        // Wait for the date input field to be interactable and enabled
        WebDriverWait waitForDateInput = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Check if the date input field is visible and interactable
        WebElement dateInputField = waitForDateInput.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='examDate']")));
        
        // Ensure the field is enabled (not read-only or disabled)
        if (dateInputField.isEnabled()) {
            // Scroll to the input field (in case it's out of view)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", dateInputField);

            // Optional: Highlight the element (for debugging purposes)
            js.executeScript("arguments[0].style.border='3px solid red'", dateInputField);

            // Clear any pre-filled value and send keys (enter date as "03/13/2000")
            dateInputField.clear(); // Clear any existing value
            dateInputField.sendKeys("03132000");

            // Optional sleep to observe changes
            Thread.sleep(5000);
        } else {
            System.out.println("The date input field is not enabled.");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

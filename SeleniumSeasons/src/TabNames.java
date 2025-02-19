

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import java.util.List;

	public class TabNames {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.icicilombard.com");

	        // Find all tabs by their tag name (assuming they are anchor links)
	        List<WebElement> tabs = driver.findElements(By.tagName("a"));

	        // Print out the names of all tabs (or link text)
	        for (WebElement tab : tabs) {
	            System.out.println(tab.getText());
	        }

	        driver.quit();
	    }
	}



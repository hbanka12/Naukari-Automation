package jan16;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URL;

public class Naukari  {

    public static void main(String[] args) {
        // Set ChromeDriver path
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Step 1: Open Google.com
            driver.get("https://www.google.com");

            // Step 2: Navigate to Naukri.com
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Naukri.com");
            searchBox.submit();

           

            // Step 5: Validate the registration process
            // Assuming we are validating by opening the registration page and submitting a dummy form.
            WebElement registerLink = driver.findElement(By.linkText("Register"));
            registerLink.click();
            Thread.sleep(2000); // Wait for the page to load
            
            // Assuming registration form has fields with IDs 'name', 'email', 'password'
            WebElement nameField = driver.findElement(By.id("name"));
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));
            
            nameField.sendKeys("Test User");
            emailField.sendKeys("testuser@example.com");
            passwordField.sendKeys("password123");

            // Submit the form (assuming the form has a button with the id 'submit')
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            Thread.sleep(2000); // Wait for submission response

            System.out.println("Registration process validated.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Method to check broken links
    private static void checkBrokenLinks(String urlString) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Broken link: " + urlString + " (Response Code: " + responseCode + ")");
            } else {
                System.out.println("Working link: " + urlString);
            }
        } catch (Exception e) {
            System.out.println("Error with URL: " + urlString);
        }
    }
}





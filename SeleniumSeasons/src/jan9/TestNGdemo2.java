package jan9;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestNGdemo2 {
	@Test(priority=20)
	 public void loginTest() {
		 System.out.println("Browser started");
		 System.out.println("App Launched");
		 System.out.println("Login Succesfull");
		 Assert.assertTrue(false);
		 System.out.println("Browser ended");
		 
		 
	 }
	 @Test(priority=-10)
	 public void registrationTest() {
		 System.out.println("Browser started");
		 System.out.println("App Launched");
		 System.out.println("Registartion Succesfull");
		 System.out.println("Browser ended");
		 
		 
	 }
	 @Test(priority=30)
	 public void forgotPasswordTest() {
		 System.out.println("Browser started");
		 System.out.println("App Launched");
		 System.out.println("forgotpassword clicked");
		 System.out.println("password changed");
		 System.out.println("Browser ended");
		 
		 
	 }
	 
	 @Test(priority=40,dependsOnMethods="loginTest")
	 public void changePasswordTest() {
		 System.out.println("Browser started");
		 System.out.println("App Launched");
		 System.out.println("Changepassword clicked");
		 System.out.println("password changed");
		 System.out.println("Browser ended");
		 
		 
	 }
}

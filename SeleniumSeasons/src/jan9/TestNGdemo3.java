package jan9;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGdemo3 {
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Browser started");
		 System.out.println("App Launched");
	}
	@Test(priority=20)
	 public void loginTest() {
		 
		 System.out.println("Login Succesfull");
		 //Assert.assertTrue(false);
		 
		 
		 
	 }
	 @Test(priority=-10)
	 public void registrationTest() {
		
		 System.out.println("Registartion Succesfull");

		 
		 
	 }
	 @Test(priority=30)
	 public void forgotPasswordTest() {
		
		 System.out.println("forgotpassword clicked");
		 System.out.println("password changed");
	
		 
		 
	 }
	 
	 @Test(priority=40,dependsOnMethods="loginTest")
	 public void changePasswordTest() {
		;
		 System.out.println("Changepassword clicked");
		 System.out.println("password changed");
	
		 
		 
	 }
	 
	 @AfterMethod
	 public void end()
	 {
		 System.out.println("Browser ended");
	 }
}

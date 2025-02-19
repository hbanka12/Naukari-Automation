package jan9;

import org.testng.annotations.Test;

public class TestNGdemo1 {
 @Test(priority=2)
 public void LoginTest() {
	 System.out.println("Browser started");
	 System.out.println("App Launched");
	 System.out.println("Login Succesfull");
	 System.out.println("Browser ended");
	 
	 
 }
 @Test(priority=1)
 public void RegistrationTest() {
	 System.out.println("Browser started");
	 System.out.println("App Launched");
	 System.out.println("Registartion Succesfull");
	 System.out.println("Browser ended");
	 
	 
 }
 @Test(priority=3)
 public void ForgotPasswordTest() {
	 System.out.println("Browser started");
	 System.out.println("App Launched");
	 System.out.println("forgotpassword clicked");
	 System.out.println("password changed");
	 System.out.println("Browser ended");
	 
	 
 }
}

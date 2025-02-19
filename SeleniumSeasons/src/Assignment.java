import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input=new Scanner(System.in);
		System.out.println("enter browser name:");
		
		String s1=input.next();
		switch(s1) {
		case "Edge":
			new EdgeDriver();
			break;
		case "Chrome":
			new ChromeDriver();
			break;
		case "Firefox":
			new FirefoxDriver();
			break;
			default:
				System.out.println("No browser Found");
				
		}
		

	}

	

	

}

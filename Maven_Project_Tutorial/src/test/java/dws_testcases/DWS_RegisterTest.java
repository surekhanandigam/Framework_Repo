package dws_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dws_Pages.DWS_HomePage;
import dws_Pages.DWS_RegisterPage;

public class DWS_RegisterTest {
  
	@Test
	public void TC2()
	{
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://demowebshop.tricentis.com/");
    	DWS_HomePage homepage=new DWS_HomePage(driver);
    	homepage.clickregisterLink();
    	
    	DWS_RegisterPage register=new DWS_RegisterPage(driver);
    	register.femaleGender();
    	register.firstName("surekha");
    	register.lastName("nandigam");
    	register.emaill("kikky@gmail.com");
    	register.password("12345");
    	register.confirmPassword("12345");
    	register.registerButton();
    	driver.close();
    	
	}
}

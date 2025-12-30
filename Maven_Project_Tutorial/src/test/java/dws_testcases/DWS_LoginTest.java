package dws_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dws_Pages.DWS_HomePage;
import dws_Pages.DWS_LoginPage;

public class DWS_LoginTest {
   
	@Test
	public void TC3()
	{
		WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://demowebshop.tricentis.com/");
    	DWS_HomePage homepage=new DWS_HomePage(driver);
    	homepage.clickloginLink();
    	
    	DWS_LoginPage login=new DWS_LoginPage(driver);
    	login.enterEmail("surekha@gmail.com");
    	login.password("123456");
    	login.loginButton();
    	driver.close();
	}
}

package dws_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dws_Pages.DWS_HomePage;

public class DWS_SearchTest {
	@Test
    public void TC1()
    {
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://demowebshop.tricentis.com/");
    	
    //	Create an object of HomePage and call the methods
    	DWS_HomePage homepage=new DWS_HomePage(driver);
    	homepage.enterSearchText("mobiles");
    	homepage.clicksearchButton();
    	
    	driver.close();
    }
}

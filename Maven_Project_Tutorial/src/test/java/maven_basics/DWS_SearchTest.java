package maven_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWS_SearchTest {
      @Test
      public void searchTest()
      {
    	  WebDriver driver=new ChromeDriver();
    	  driver.manage().window().maximize();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  driver.get("https://demowebshop.tricentis.com/");
    	  driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
    	  driver.findElement(By.xpath("//input[@type='submit']")).click();
    	  driver.close();
    	  
      }
}

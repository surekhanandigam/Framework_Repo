package practice.testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
   
	@Test
	public void amazonTest() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//Create an Object to EventFiring WebDriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//Use getscreenshotas method to get the file type of screenshot
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
	
		//store screen on local driver
		FileUtils.copyFile(srcFile,new File("./screenshot/test.png"));
	}
}

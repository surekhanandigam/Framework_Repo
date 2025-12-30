package asserts;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void validationForHomeTest() {
		System.out.println("====Test Starts====");
		String expectedResult = "Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String actualResult = driver.findElement(By.className("hdrLink")).getText();
		Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
	}

	@Test
	public void validationForLogoTest() {
		System.out.println("====Test Starts====");
	//	String expectedResult = "Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		Boolean display=driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(display);
		driver.quit();
	}

}

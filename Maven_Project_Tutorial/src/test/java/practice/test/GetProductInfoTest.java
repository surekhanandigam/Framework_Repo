package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest {

	@Test
	public void getProductInfoTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		//driver.findElement(By.id("nav-search-submit-button")).click();
		//capture product info
		String options=driver.findElement(By.xpath("//ancestor::div[contains(@class,'a')]//descendant::span[text()='Apple iPhone 15 Pro, 256GB, Blue Titanium - Unlocked (Renewed)']//following::span[@class='a-truncate-cut']"))
		.getText();
		System.out.println(options);
	}
}

package tables_brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenAndUnBrokenLinks {
  
//	@Test
//	public void tc() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.flipkart.com/");
//
//		List<WebElement> links = driver.findElements(By.xpath("//a"));
//        int count=0;
//		for (int i = 0; i <= links.size() - 1; i++) {
//			String linkstext = links.get(i).getText();
//			System.out.println(linkstext);
//			count++;
//		}
//		System.out.println("Count of the links :"+count);
//	}
//	
	@Test
	public void tc2() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.wikipedia.org/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (int i = 0; i <= links.size() - 1; i++) {
			String linkstext = links.get(i).getAttribute("href");
			if(linkstext==null || linkstext.isEmpty())
			{
				System.out.println("We cant check");
				continue;
			}
		URL url=new URL(linkstext);
		HttpURLConnection c=(HttpURLConnection)url.openConnection();
		c.connect();
		if(c.getResponseCode()>=400)
		{
			System.out.println(linkstext+" -------------- "+c.getResponseCode()+c+" it is a broken link "+c);
		}
		else
		{
			System.out.println(linkstext+" ----------------- "+c.getResponseCode()+c+" it is a unbroken link "+c);
		}
		}
	
	}
	
}

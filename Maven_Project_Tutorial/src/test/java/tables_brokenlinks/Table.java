package tables_brokenlinks;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {
	
	/*@Test
	public void table()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> wb=driver.findElements(By.xpath("//ancestor::table//descendant::tr"));
		for(WebElement w:wb)
		{
			String rows=w.getText();
			System.out.println(rows);
    		
		}*/
	
	   /*@Test
	   public void table()
	   {
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			List<WebElement> wb = driver.findElements(By.xpath("//ancestor::table//descendant::tr"));
			for (int i=0;i<=wb.size()-1;i++) {
				String rows = wb.get(i).getText();
		    	System.out.println(rows);
			}*/

	@Test
	public void tc3() {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");

	    List<WebElement> wb = driver.findElements(By.xpath("//table//tr"));

	    Iterator<WebElement> iterator = wb.iterator();

	    while (iterator.hasNext()) {
	        WebElement row = iterator.next();
	        System.out.println(row.getText());
	    }

	    driver.quit();
	}

	 
}

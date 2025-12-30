package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactTest {
  @Test
  public void testcase() throws Exception{
		FileInputStream fis = new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\commondata.properties");
	    Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		Random r=new Random();
		int random=r.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("contact");
		Row row=sh.getRow(1);
	    String lastname=row.getCell(2).toString()+random;

	    wb.close();
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
 
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		//verify Header phone expected result
		String HeaderInfo=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(HeaderInfo.equals(lastname))
		{
			System.out.println(lastname +" is created===PASS");
		}
		else
		{
			System.out.println(lastname+" is not created===FAIL");
		}
		driver.quit();
	
  }
}

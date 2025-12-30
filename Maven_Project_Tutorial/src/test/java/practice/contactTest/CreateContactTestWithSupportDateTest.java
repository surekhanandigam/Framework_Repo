package practice.contactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactTestWithSupportDateTest {
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
		Row row=sh.getRow(4);
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
		
		Date date = new Date();
	    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	    String startDate=sim.format(date);
	   
	    Calendar cal=sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,30);
	    String endDate=sim.format(cal.getTime());
	
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
	    driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
	    driver.findElement(By.name("support_end_date")).clear();
	    driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	    
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		//verify start date expected result
		String sd=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(sd.equals(startDate))
		{
			System.out.println(startDate +" is verified===PASS");
		}
		else
		{
			System.out.println(startDate+" is not verified===FAIL");
		}
		
		//verify the end date expected result
		String ed=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(ed.equals(endDate))
		{
			System.out.println(endDate +" is verified===PASS");
		}
		else
		{
			System.out.println(endDate+" is not verified===FAIL");
		}
		
		driver.quit();
	
  }
}

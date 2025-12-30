package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {
	//Integration Testing
	 @Test
	 public void testcase() throws Exception { 
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
			Sheet sh=wb.getSheet("org");
			Row row=sh.getRow(7);
		    String orgname=row.getCell(2).toString()+random;
		    String contactLastname=row.getCell(3).getStringCellValue();
		    String shippingadd=row.getCell(5).toString();
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
	 
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

			driver.findElement(By.name("accountname")).sendKeys(orgname);
		    driver.findElement(By.name("ship_street")).sendKeys(shippingadd);
			driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
			
			//verify Header msge expected result
			String HeaderInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(HeaderInfo.contains(orgname))
			{
				System.out.println(orgname +" is created===PASS");
			}
			else
			{
				System.out.println(orgname+" is not created===FAIL");
			}
			
		     //navigate to contact module
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

			driver.findElement(By.name("lastname")).sendKeys(contactLastname);
			driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();
			
			//switch to child window
			Set<String>set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			while(it.hasNext())
			{
				String window=it.next();
				driver.switchTo().window(window);
				String actualUrl=driver.getCurrentUrl();
				if(actualUrl.contains("module=Accounts")) {
					break;
				}
			}
			driver.findElement(By.id("search_txt")).sendKeys(orgname);
			driver.findElement(By.name("search")).click();
			//driver.findElement(By.id("1")).click();
	    	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			
			//switch to parent window
			Set<String>set1=driver.getWindowHandles();
			Iterator<String> it1=set1.iterator();
			while(it1.hasNext())
			{
				String window=it1.next();
				driver.switchTo().window(window);
				String actualUrl=driver.getCurrentUrl();
				if(actualUrl.contains("Contacts&action")) {
					break;
				}
			}
			
			driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();		
			
			//Verify Header orgname info  expected result
			String actorgInfo=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actorgInfo);
			if(actorgInfo.trim().equals(orgname))
			{
				System.out.println(orgname +" is Verified===PASS");
			}
			else
			{
				System.out.println(orgname+" is not Verified===FAIL");
			}	
			driver.quit();
		 }
}

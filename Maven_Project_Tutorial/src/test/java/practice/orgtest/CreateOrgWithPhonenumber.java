package practice.orgtest;

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

public class CreateOrgWithPhonenumber {
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
		    String phnnum=row.getCell(4).getStringCellValue();
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
			driver.findElement(By.id("phone")).sendKeys(phnnum);
			driver.findElement(By.name("ship_street")).sendKeys(shippingadd);
			driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
			
			//verify the phone number
			String actphnnum=driver.findElement(By.id("dtlview_Phone")).getText();
			if(actphnnum.equals(phnnum))
			{
				System.out.println(phnnum + " information is verified===PASS");
			}
			else
			{
				System.out.println(phnnum + " information is not verified===FAIL");
			}
			driver.quit();
	 }
}

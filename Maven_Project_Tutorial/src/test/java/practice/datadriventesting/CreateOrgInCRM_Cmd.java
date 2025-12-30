package practice.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
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

public class CreateOrgInCRM_Cmd {
   @Test
   public void createOrgtest() throws Throwable
   {
	     String url=System.getProperty("url");
   	     String browser=System.getProperty("browser");
   	     String un=System.getProperty("username");
   	     String pswd=System.getProperty("password");
	   	 Random random=new Random();
	     int randomInt=random.nextInt(1000);
	
		FileInputStream fis1=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis1);
		Sheet sheet=workbook.getSheet("org");
		Row row=sheet.getRow(1);
		String orgname=row.getCell(2).toString()+randomInt;
		String shippingadd=row.getCell(5).toString();
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
			driver =new ChromeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
	    //navigate to the organization module
		driver.findElement(By.linkText("Organizations")).click();
		//click on "create organization " button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//enter all details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.name("ship_street")).sendKeys(shippingadd);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		driver.quit();
		
   }
}

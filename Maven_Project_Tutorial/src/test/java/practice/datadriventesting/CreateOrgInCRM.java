package practice.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgInCRM {
	 public static void main(String[] args) throws Exception {
	        //read common data from properties file	   
 		    FileInputStream fis = new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\commondata.properties");
			Properties p=new Properties();
			p.load(fis); 
			String Browser=p.getProperty("browser");
		    String Url=p.getProperty("url");
		    String Un=p.getProperty("username");
			String Pswd=p.getProperty("password");
		     
			 Random random=new Random();
		     int randomInt=random.nextInt(1000);
		
			FileInputStream fis1=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
			Workbook workbook=WorkbookFactory.create(fis1);
			Sheet sheet=workbook.getSheet("org");
			Row row=sheet.getRow(1);
			String orgname=row.getCell(2).toString()+randomInt;
			String shippingadd=row.getCell(5).toString();
			WebDriver driver=null;
			if(Browser.equals("chrome"))
			{
				driver=new ChromeDriver(); 
			}
			else if(Browser.equals("edge"))
			{
				driver=new EdgeDriver(); 
			}
			else if(Browser.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else
			{
				driver =new ChromeDriver(); 
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Un);
			driver.findElement(By.name("user_password")).sendKeys(Pswd);
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

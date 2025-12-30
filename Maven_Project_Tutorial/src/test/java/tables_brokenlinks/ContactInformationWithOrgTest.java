package tables_brokenlinks;

import java.io.FileInputStream;
import java.time.Duration;
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

public class ContactInformationWithOrgTest {
   
	@Test
	public void testcase() throws Throwable
	{
	   FileInputStream fis=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\commondata.properties");
	   Properties p=new Properties();
	   p.load(fis);
	   String browser=p.getProperty("browser");
	   String url=p.getProperty("url");
	   String username=p.getProperty("username");
	   String password=p.getProperty("password");
	   
	   Random ran=new Random();
	   int random=ran.nextInt(5000);
	   
	   FileInputStream fis1=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
	   Workbook wb=WorkbookFactory.create(fis1);
	   Sheet sh=wb.getSheet("org");
	   Row r=sh.getRow(7);
	   String orgname=r.getCell(2).toString()+random;
	   String contactLastname=r.getCell(3).getStringCellValue();
	   String shippingadd=r.getCell(5).toString();
	   
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
	    driver.manage().window().maximize();
	    
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.name("ship_street")).sendKeys(shippingadd);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
         Thread.sleep(1000);
	     //navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	     
		driver.findElement(By.name("lastname")).sendKeys(contactLastname);
		 Thread.sleep(1000);
		String pw=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();
		Set<String> cw=driver.getWindowHandles();
		for(String window:cw)
		{
			if(!pw.equals(window))
			{
				driver.switchTo().window(window);
				driver.findElement(By.id("search_txt")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.id("1")).click();
			}
		}
		
		driver.switchTo().window(pw);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();	
	//	String actorgInfo=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		String actorgInfo = driver
		        .findElement(By.id("mouseArea_Organization Name"))
		        .getText()
		        .trim();
	    if(actorgInfo.equals(orgname))
	    {
	    	System.out.println(orgname+" is verified====PASS");
	    }
	    else
	    {
	    	System.out.println(orgname+" is not verified====FAIL");
	    }
	    	
	    driver.quit();
	    
	}
}

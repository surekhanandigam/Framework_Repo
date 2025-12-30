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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrgWithIndustry {
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
			Row row=sh.getRow(4);
		    String orgname=row.getCell(2).toString()+random;
		    String industry=row.getCell(4).toString();
		    String type=row.getCell(5).toString();
		    String shippingadd=row.getCell(6).toString();
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

			//Industry
			WebElement ind=driver.findElement(By.name("industry"));
			Select sort=new Select(ind);
			sort.selectByVisibleText(industry);
			
			//Type
			WebElement type1=driver.findElement(By.name("accounttype"));
			Select sort1=new Select(type1);
			sort1.selectByVisibleText(type);
			driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
			
			//Verify the drop down industry and type info
			String actInd=driver.findElement(By.id("dtlview_Industry")).getText();
			if(actInd.equals(industry))
			{
				System.out.println(industry + "information is verified===PASS");
			}
			else
			{
				System.out.println(industry + "information is not verified===FAIL");
			}
			
			String actType=driver.findElement(By.id("dtlview_Type")).getText();
			if(actType.equals(type1))
			{
				System.out.println(type + " information is verified===PASS");
			}
			else
			{
				System.out.println(type + " information is not verified====FAIL");
			}
			
            driver.quit();
	 }
}

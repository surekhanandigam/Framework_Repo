package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgInCRM_json {
	public static void main(String[] args) throws Exception {
	  JSONParser parser = new JSONParser();
	  Object obj = parser.parse(new FileReader("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\appCommonData.json"));    
	  JSONObject map=(JSONObject)obj;
        
		String Browser=(String)map.get("browser");
	    String Url=(String)map.get("url");
	    String Un=map.get("username").toString();
		String Pswd=map.get("password").toString();
	     
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

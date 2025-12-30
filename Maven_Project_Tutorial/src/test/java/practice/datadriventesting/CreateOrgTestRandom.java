package practice.datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//for same scenario i write the script on apachepoi_maven_project under test demo folder.
public class CreateOrgTestRandom {
    public static void main(String[] args) throws Exception {
	   
    FileInputStream fis = new FileInputStream("C:\\Users\\91765\\Desktop\\commondata.properties");
	Properties p=new Properties();
	p.load(fis); 
	String Browser=p.getProperty("browser");
    String Url=p.getProperty("url");
    String Un=p.getProperty("username");
	String Pswd=p.getProperty("password");
	
	Scanner sc=new Scanner(System.in);
	System.out.println("BROWSER");
	String BROWSER=sc.next();
	//Run time Polymorphisim
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver(); 
	}
	else if(BROWSER.equals("edge"))
	{
		driver=new EdgeDriver(); 
	}
	else if(BROWSER.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		driver =new ChromeDriver(); 
	}
//	WebDriver driver=new ChromeDriver();
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Un);
	driver.findElement(By.name("user_password")).sendKeys(Pswd);
	driver.findElement(By.id("submitButton")).click();

    }
}

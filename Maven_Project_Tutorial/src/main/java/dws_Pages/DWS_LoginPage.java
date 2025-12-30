package dws_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_LoginPage {

	//constructor
	public  DWS_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pswd;
	
    @FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement login;

	public void enterEmail(String emailval)
	{
		email.sendKeys(emailval);
	}
	public void password(String pswdval)
	{
		pswd.sendKeys(pswdval);
	}
	public void loginButton()
	{
		login.click();
	}
	
	
	
}

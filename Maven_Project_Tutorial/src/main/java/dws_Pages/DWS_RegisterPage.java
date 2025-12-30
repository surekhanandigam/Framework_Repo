package dws_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_RegisterPage {
 
	//constructor
	public DWS_RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="gender-female")
	WebElement femalebutton;
	
	@FindBy(id="FirstName")
	WebElement firstname;
	
	@FindBy(name="LastName")
	WebElement lastname;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pswd;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpswd;
	
	@FindBy(id="register-button")
	WebElement regbtn;
	
	public void femaleGender()
	{
		femalebutton.click();
	}	
	public void firstName(String firstnameval)
	{
		firstname.sendKeys(firstnameval);
	}
	public void lastName(String lastnameval)
	{
		lastname.sendKeys(lastnameval);
	}
	public void emaill(String emailval)
	{
		email.sendKeys(emailval);
	}
	public void password(String passval)
	{
		pswd.sendKeys(passval);
	}
	public void confirmPassword(String cfrmpswdval)
	{
		confirmpswd.sendKeys(cfrmpswdval);
	}
	public void registerButton()
	{
		regbtn.click();
	}
}

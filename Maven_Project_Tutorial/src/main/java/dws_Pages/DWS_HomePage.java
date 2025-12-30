package dws_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_HomePage {
 
	//constructor
	public  DWS_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//WebElements
	@FindBy(id="small-searchterms")
	WebElement searchtxt;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement searchbutton;
	
	//Register WebElement
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	//Login Link WebElement
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	//Actions or methods of webElements
	public void enterSearchText(String value)
	{
		searchtxt.sendKeys("mobiles");
	}
	public void clicksearchButton()
	{
		searchbutton.click();
	}
	public void clickregisterLink()
	{
		registerLink.click();
	}
	public void clickloginLink()
	{
		loginLink.click();
	}
	
}

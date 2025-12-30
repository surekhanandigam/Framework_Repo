package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest extends  BaseClass{
	
	@Test(groups="SmokeTesting")
	public void createContact()
	{
		System.out.println("execute CreateContact");
	
		String url=System.getProperty("url");
		String browser=System.getProperty("browser");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test
	public void createContactWithDate()
	{
		System.out.println("execute CreateContactWithDate");
	}
	
	@Test(groups="RegressionTesting")
	public void deleteContactWithDate()
	{
		System.out.println("execute deleteContactWithDate");
	}
	
	@Test
	public void modifyContactWithDate()
	{
		System.out.println("execute modifyContactWithDate");
	}

}

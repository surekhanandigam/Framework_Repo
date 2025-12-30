package com.crm.comcast.orgTest;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateOrgTest extends BaseClass{
		
	@Test
	public void createOrgTest()
	{
		String url=System.getProperty("url");
		String browser=System.getProperty("browser");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println("execute CreateOrgTest and Verify");
	}
	
	@Test
	public void createOrgWithIndustry()
	{
		System.out.println("execute createOrgWithIndustry and Verify");
	}
}

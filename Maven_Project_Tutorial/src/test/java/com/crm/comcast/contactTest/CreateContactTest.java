package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest extends  BaseClass{
	
	@Test
	public void createContact()
	{
		System.out.println("execute CreateContact");
	}
	
	@Test
	public void createContactWithDate()
	{
		System.out.println("execute CreateContactWithDate");
	}
	
	@Test
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

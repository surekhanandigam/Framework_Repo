package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createContactTest()
	{
		System.out.println("execute create contact test");
	}
	
	@Test(dependsOnMethods="createContactTest")
	public void modifyContactTest()
	{
		System.out.println("execute create contact test--insert into db");
		System.out.println("execute modify contact test");
	}
	
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest()
	{
		System.out.println("execute create contact test--insert into db");
		System.out.println("execute delete contact test");
	 }
}
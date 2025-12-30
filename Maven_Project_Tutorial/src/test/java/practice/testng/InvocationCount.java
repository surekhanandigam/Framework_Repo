package practice.testng;

import org.testng.annotations.Test;

public class InvocationCount {


	@Test(invocationCount = 10)
	public void createOrderTest()
	{
		System.out.println("Execute create Order====123");
	}
	
	@Test(enabled=false)
	public void billingAnOrderTest()
	{
		System.out.println("Execute billingAnOrder====123");
	}
}

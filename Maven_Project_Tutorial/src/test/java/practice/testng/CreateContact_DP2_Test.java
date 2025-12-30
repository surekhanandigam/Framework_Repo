package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP2_Test {
 
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName,long phnnum)
	{
		System.out.println("firstname: "+firstName+" lastname: "+lastName+" phonenumber: "+phnnum);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj =new Object[3][3];
		obj[0][0]="surekha";
    	obj[0][1]="n";
    	obj[0][2]=9999999999l;
    			
    	obj[1][0]="sam";
    	obj[1][1]="chay";
    	obj[1][2]=9876543210l;
    	
    	obj[2][0]="jhon";
    	obj[2][1]="smith";
        obj[2][2]=9988776655l;
        
    	return obj;
		
	}
}

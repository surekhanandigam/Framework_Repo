package practice.sqlbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {

	@Test
	public void studentcheckTest() throws SQLException{
		
		String expectedStudentName="kikky";
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/m16_advance_java","root","root");
		System.out.println("Done");
	
		Statement statement=connection.createStatement();
		
	    ResultSet resultset=statement.executeQuery("select * from student_details");
	    while(resultset.next())
	    {
		  String studentname =resultset.getString(2);
		  if(expectedStudentName.equals(studentname))
		  {
			flag=true;
		    System.out.println(expectedStudentName + " is available");
		  }
	    }
	    if(flag==false)
	    {
	    	System.out.println(expectedStudentName + " is not available");
	    	Assert.fail();
	    } 
		   connection.close();
	}
}

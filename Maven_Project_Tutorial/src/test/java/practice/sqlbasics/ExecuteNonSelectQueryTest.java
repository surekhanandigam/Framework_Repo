package practice.sqlbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {
	 public static void main(String[] args) throws Throwable {
		   
			//step 1:load/register the database driver
			   Driver driverRef=new Driver();
			   DriverManager.registerDriver(driverRef);
			//step 2:connect to database.
			   Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/m16_advance_java","root","root");
			   System.out.println("Done");
			//step 3:create a sql statement
			   Statement statement=connection.createStatement();
			//step 4: execute select query & get result
			   int result=statement.executeUpdate(" insert into student_details values(4,'Sam','sam@gmail.com',9800000001,'EEE','B-Tech',60);");
			   System.out.println(result);
			//step 5:close the connection
			   connection.close();
		 }
}

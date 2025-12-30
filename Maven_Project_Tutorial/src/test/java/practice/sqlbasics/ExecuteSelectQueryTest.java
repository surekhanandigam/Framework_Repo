package practice.sqlbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {
	 public static void main(String[] args) throws Throwable {
		Connection connection=null;
		 try {
			//step 1:load/register the database driver
			   Driver driverRef=new Driver();
			   DriverManager.registerDriver(driverRef);
			//step 2:connect to database.
			   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/m16_advance_java","root","root");
			   System.out.println("Done");
			//step 3:create a sql statement
			   Statement statement=connection.createStatement();
			//step 4: execute select query & get result
			   ResultSet resultset=statement.executeQuery("select * from student_details");
			   while(resultset.next())
			   {
				   System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+
			   resultset.getString(5)+"\t"+resultset.getString(6)+"\t"+resultset.getString(7));
			   }
		 }
		 catch(Exception e)
		 {
			 System.out.println("handle exception");
		 }
		 finally {
		 //step 5:close the connection
			   connection.close();
			   System.out.println("---------close the connection----------");
		 }
		 }
}

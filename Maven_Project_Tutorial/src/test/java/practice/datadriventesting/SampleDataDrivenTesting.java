package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {
 
	public static void main(String[] args) throws IOException {
		//step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("‪C:\\Users\\91765\\Desktop\\commondata.properties");
		
		//step 2:using properties class load all the keywords
		Properties p=new Properties();
		p.load(fis); //void
		//step 3:get the values based on key
		System.out.println(p.getProperty("browser"));
		p.getProperty("url");
	}
}

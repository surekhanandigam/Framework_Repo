package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {
    @Test
    public void runtimeParameterTest()
    {
    	String url=System.getProperty("url");
    	String browser=System.getProperty("browser");
    	String un=System.getProperty("username");
    	String pswd=System.getProperty("password");
    	System.out.println("Env Data===>URL ===>"+url);
    	System.out.println("Browser Data===> ===>"+browser);
    	System.out.println("Username Data===> ===>"+un);
    	System.out.println("Password Data===> ===>"+pswd);
    }
}

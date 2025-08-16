package Practice.Goal;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTc extends BaseTest{
	
	
	SoftAssert a=new SoftAssert();
	
	@Test
	public void Logining() throws IOException, InterruptedException
	{
		launchurl("url2");//launch loginapp
		Loginpage lp=new Loginpage(driver);
		String textt=lp.login();
		a.assertEquals(textt, "Hi, sita!");
		a.assertAll(); 
		
	}
	/*
	@Test
	public void errormess() throws InterruptedException
	{
		String errortext=lp.geterror();
		a.assertEquals(errortext, "Your password is invalid!");
		a.assertAll(); 
	}
 //With SoftAssert, the test does not stop when an assertion fails — it records all assertion results and reports them together at the end when you call assertAll().
	*/
}

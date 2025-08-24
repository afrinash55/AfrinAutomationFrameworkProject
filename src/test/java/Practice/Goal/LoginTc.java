package Practice.Goal;

import java.io.IOException;

import org.testng.Assert;
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
		a.assertEquals(textt, "Hi, cita!");
		a.assertAll(); 
	}
	
	@Test(retryAnalyzer = Practice.Goal.RetryTest.class)
	public void testThatMayFail() {
	    Assert.fail("Failing on purpose to test retry");
	}

	//invocation count means how many times it should run
	@Test
	public void errormess() throws InterruptedException, IOException
	{
		launchurl("url2");
		Loginpage lp=new Loginpage(driver);
		String errortext=lp.geterror();
		a.assertEquals(errortext, "Your password is invalid!");
		a.assertAll(); 
	}
 //With SoftAssert, the test does not stop when an assertion fails — it records all assertion results and reports them together at the end when you call assertAll().

}

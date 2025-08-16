package Practice.Goal;

import java.io.IOException;

import org.testng.annotations.Test;

public class RegistrationTc extends BaseTest{
	
//	SoftAssert a=new SoftAssert();
	
	@Test
	public void Registration() throws IOException, InterruptedException
	
	{
		launchurl("url1");//Step1: Open URL
		Registrationpage rp=new Registrationpage(driver);
		rp.register();
		/*String successtextt=rp.register();
		a.assertEquals(successtextt, "Successfully registered, you can log in now.");
		a.assertAll();*/
		
	}
	
}

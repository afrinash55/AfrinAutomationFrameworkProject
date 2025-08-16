package Practice.Goal;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationpage extends Utilities{
	
	private static final Logger logger = LogManager.getLogger(Utilities.class);
	public WebDriver driver;
	
	//WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	public Registrationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	@FindBy(id = "username")
	public WebElement user;
	
	@FindBy(id = "password")
	public WebElement pass;
	
	@FindBy(id = "confirmPassword")
	public WebElement confirmPass;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement register;
	
//@FindBy (xpath= "//*[contains(text(),'Successfully registered')]")
//	public WebElement message;
	
	
	
	public void register() throws InterruptedException, IOException
	{
		logger.info("registration page");
		   scroll(driver);
		 Thread.sleep(2000);
		  String usernamme= fetchproperty("username");
		  String passworrd= fetchproperty("password");
		  String confirmmpassword= fetchproperty("confirmpassword");  
          user.sendKeys(usernamme);
          logger.info("username entered is" +usernamme);
          pass.sendKeys(passworrd);
          logger.info("password entrered is" +passworrd);
          confirmPass.sendKeys(confirmmpassword);  
          logger.debug("confirmasswwrd has been entered" +confirmmpassword);
          register.click();
          logger.info("registr clicked");
      //  String successtext= message.getText();
        //  System.out.println(driver.getTitle());
      /*    if(successtext=="Successfully registered, you can log in now.")
          {
        	  logger.info("registration done");
          }
          else
          {
        	  logger.error("Registration failure");
          }*/
        //  return successtext;
}
}
	
	
	
	
	
	

package Practice.Goal;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Utilities{
	
	private static final Logger logger = LogManager.getLogger(Utilities.class);

	public WebDriver driver;
	
	//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	

	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@type='submit']")
	public WebElement login;

	@FindBy(id = "username")
	public WebElement user;
	
	@FindBy(id = "password")
	public WebElement pass;
	
	//@FindBy(css="div[id='flash-message']")
//	WebElement error;
	
	
	public String login() throws InterruptedException, IOException
	{
		scroll(driver);
		 Thread.sleep(2000);
		String usernamme= fetchproperty("username");
		  String passworrd= fetchproperty("password");
		user.sendKeys(usernamme);
        pass.sendKeys(passworrd);
        logger.debug("password has been given" +passworrd);
        Thread.sleep(1000);
        login.click();
        logger.info("login successful");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
		String text=driver.findElement(By.xpath("//h3[@id=\"username\"]")).getText();
		return text;
	}
	
	
	/*public String geterror() throws InterruptedException
	{
		scroll(driver);
		user.sendKeys("Sita");
        pass.sendKeys(".,l");
        login.click();
        //w.until(ExpectedConditions.visibilityOf(error));
     //  WebElement errortext = w.until(ExpectedConditions.visibilityOf(error));
        Thread.sleep(1000);
        String texterror=error.getText();
		return texterror;
	}*/
	
}

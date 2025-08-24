package Practice.Goal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utilities {
	
	private static final Logger logger = LogManager.getLogger(Utilities.class);

	/*logger.info("Navigating to booking page");
	logger.debug("Selected travel date: " + selectedDate);
	logger.warn("Train list is empty");
	logger.error("Failed to select train", e);  // with exception*/
	public WebDriver driver;
	
	public void scroll(WebDriver driver)
	{
		this.driver=driver;
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}

    // Take screenshot method (Reusable for all tests)
	public static String screenshot(WebDriver driver,String testname) throws IOException
	{
		
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotpath=System.getProperty("user.dir")+"/screenshots/"+testname+"_"+timestamp+".png";
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotpath)); 
		
		return screenshotpath;
	}
	
	/*SimpleDateFormat("yyyyMMdd_HHmmss") → Formats the current date & time into a string like 20250817_145601.

	.format(new Date()) → Gets the current system date/time and applies that format.
C:\MyProject\screenshots\LoginTest_20250817_145601.png

	Why? → If two screenshots had the same name, they’d overwrite each other. Timestamp ensures unique file names.*/

	
	public static String fetchproperty(String key) throws IOException
	{
		Properties p=new Properties();//using this class so that we can access the data resent in data proerties file
				FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practice\\Goal\\data.properties");//this class creates an object which has caopacity to read any file and it exects a path
		//C:\Users\s\eclipse-workspace\Goal\src\main\java\Practice\Goal\data.properties
				p.load(fp);
				String value=p.getProperty(key);
				return value;
				
				
	}
}

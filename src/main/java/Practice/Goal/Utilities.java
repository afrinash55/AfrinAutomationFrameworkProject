package Practice.Goal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

	
	public WebDriver driver;
	
	public void scroll(WebDriver driver)
	{
		this.driver=driver;
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	public void screenshot(WebDriver driver) throws IOException
	{
		this.driver=driver;
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("c:\\users\\s\\afr1.png"));  
	}
	
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

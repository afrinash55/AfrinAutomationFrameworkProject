package Practice.Goal;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	
	public WebDriver driver;
	
	//1.initilaise driver
	//launch app
	//quick driver
	
	public WebDriver intialisedriver()
	{
		WebDriverManager.chromedriver().setup();
		// Setup ChromeDriver automatically

		driver= new ChromeDriver();// Create WebDriver instance
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public void launchurl(String url) throws IOException, InterruptedException
	{
		driver=intialisedriver();
		String url3=Utilities.fetchproperty(url);
	//	String url3=Utilities.fetchproperty("url1");
		Thread.sleep(1000);
		driver.get(url3);
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void quit()
	{
		driver.close();
	}
	
	

}

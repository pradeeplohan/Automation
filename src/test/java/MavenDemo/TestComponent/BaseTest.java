package MavenDemo.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import MavenDemo.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	  protected WebDriver driver;
	  public LandingPage lpage;
	  
	//In java properties class which reads property file

	public WebDriver inilizeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream inStrm = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//java//MavenDemo//resources//GlobalData.properties");
		prop.load(inStrm);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
		    driver = new ChromeDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		} 
		
		else if (browserName.equalsIgnoreCase("safari"))
		{
			//WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		
	    }

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	
	
	@BeforeTest
	public LandingPage launchApplication() throws IOException
	{
		driver = inilizeDriver();
		lpage = new LandingPage(driver);
		lpage.gotoWeb();
		return lpage;
	}
	
	@AfterTest
	public void closeTab() {
		driver.close();
	}
}

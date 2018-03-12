package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.MyWebDriverFunctions;

public class Configs2 extends MyWebDriverFunctions {
	public static Logger APPLICATION_LOG= Logger.getLogger("dest1");

	protected static String baseURL="http://mock.agiletrailblazers.com/contact.html" ;


	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String browserName){
		if (browserName.equalsIgnoreCase("ch")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();// the driver has already been initiated as public WebDriver in MyWebDriverFunctions
			APPLICATION_LOG.debug("Chrome is selected");
		}
		else if (browserName.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();// the driver has already been initiated as public WebDriver in MyWebDriverFunctions
			APPLICATION_LOG.debug("Firefox is selected");
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
		implictWait(30);


	}

	@AfterMethod()
	public void closeConnection(){
		driver.close();
		driver.quit();
	}
}

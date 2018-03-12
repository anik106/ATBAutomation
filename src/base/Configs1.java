package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import utils.MyWebDriverFunctions;

public class Configs1 extends MyWebDriverFunctions {
	public static Logger APPLICATION_LOG= Logger.getLogger("dest1");

	protected static String baseURL="http://mock.agiletrailblazers.com/contact.html" ;



	@BeforeMethod
	public void setUp(){

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();// the driver has already been initiated as public WebDriver in MyWebDriverFunctions
		APPLICATION_LOG.debug("Testing on Chrome");
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		//driver = new FirefoxDriver();// the driver has already been initiated as public WebDriver in MyWebDriverFunctions
		//APPLICATION_LOG.debug("Testing on Firefox ");


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


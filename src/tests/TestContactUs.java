package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.SkipException;
import org.testng.annotations.Test;

//import base.Configs1;
import base.Configs2;
import locators.LoactorsContactUs;
import values.ValuesContactUs;


public class TestContactUs extends Configs2 {
	
	LoactorsContactUs CL= new LoactorsContactUs();
	ValuesContactUs CV= new ValuesContactUs();
	
	@Test(priority=0)
	public void contactUsPositiveTest() throws InterruptedException{
		
		APPLICATION_LOG.debug("ContactUs  Positive Test started");
		
		driver.get(baseURL);
		
		//typing Name
				typeByXpath(CL.nameLoc, CV.nameVal) ;
		
		//typing email
				typeByXpath(CL.emailLoc, CV.emailVal) ;
				
		//typing phone number
				typeByXpath(CL.phoneLoc, CV.phoneVal) ;	
		
		//typing office number
				typeByXpath(CL.officeLoc, CV.officeVal) ;
		
		//selecting subject
				selectDropDownOptionByValueByXpath(CL.subjectLoc, CV.subjectVal );
				
		//typing message
				typeByXpath(CL.messageLoc, CV.messageVal) ;
				
		//clicking submit button
				
				clickByXpath(CL.submitLoc);
				
		
		//verifying  Sccess message
			String actualSuccessMsg= driver.findElement(By.xpath(CL.successMessageLoc)).getText();
			String expectedSuccesMsg= CV.expectedSucessMsgVal;
				Assert.assertEquals( actualSuccessMsg, expectedSuccesMsg );
		
		APPLICATION_LOG.debug("ContactUs  Positive Test Ended");	
	}		
		
	@Test(priority=1)
		public void contactUsNegitiveTest() throws InterruptedException{
			
			APPLICATION_LOG.debug("ContactUs Negitive Test started");
			
			driver.get(baseURL);
			
					
			//clicking submit button without entering value to required fields
					
					clickByXpath(CL.submitLoc);
					
			
			//verifying  Validation error message
				String actualErrorMsg= driver.findElement(By.xpath(CL.errorMessageLoc)).getText();
				String expectedErrorMsg= CV.expectedErrorMsgVal;
					Assert.assertEquals( actualErrorMsg, expectedErrorMsg );
			
			APPLICATION_LOG.debug("ContactUs Negitive Test Ended");

	}	
}

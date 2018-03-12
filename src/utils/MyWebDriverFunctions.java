package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyWebDriverFunctions {

	public WebDriver driver;
	public static Logger APPLICATION_LOG= Logger.getLogger("dest1");

	
	//=======================TypeWebEditBox=======================================================================
	public void typeByXpath(String locator, String value){
		try{
			driver.findElement(By.xpath(locator)).sendKeys(value);
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;}
	}
	//============================================================================================

	//=======================ClearWebEditBox=======================================================================
		public void clearByXpath(String locator){
			try{
				driver.findElement(By.xpath(locator)).clear();;
			}catch(Exception e)
			{
				APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
				APPLICATION_LOG.debug(e );
				return;}
		}
		//============================================================================================
	//=======================Click=======================================================================
	public void clickByXpath(String locator){

		try{
			driver.findElement(By.xpath(locator)).click();
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;}
	}
	//============================================================================================

	//=======================DoubleClick=======================================================================
		public void doubleClickByXpath(String locator){

			try{
				WebElement e=driver.findElement(By.xpath(locator));
				Actions a= new Actions(driver);
				a.doubleClick(e).build().perform();
				
			}catch(Exception e)
			{
				APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
				APPLICATION_LOG.debug(e );
				return;}
		}
		//============================================================================================

	//============================RadioButton==============================================================

	//---radio Buttons count by xpath
	public void radioButtonCountByXpath(){
		try{
			List<WebElement> radioButton= driver.findElements(By.xpath("//input[@type='radio']"));
			int totalradioButtons= radioButton.size();
			System.out.println("Total Number o Radio Buttons is: "+ totalradioButtons);
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;}

	}
	//---radio Buttons select by index
	public void radioButtonSelectByXpath(int index){
		try{
			List<WebElement> radioButton= driver.findElements(By.xpath("//input[@type='radio']"));
			radioButton.get(index).click();
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;}
	}
	//============================================================================================


	//==========================CheckBox=================================================================
	//---CheckBoxCountByXpath
	public void checkBoxCountByXpath(){
		try{
			List<WebElement> checkBox= driver.findElements(By.xpath("//input[@type='checkbox']"));
			int totalcheckBoxes= checkBox.size();
			System.out.println("Total Number o Radio Buttons is: "+totalcheckBoxes);
		}
		catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not found loactors" );
			APPLICATION_LOG.debug(e );
			return;}
	}

	//---checkBoxCheckByIndex
	public void checkBoxCheckByindex(int index){
		try{
			List<WebElement> checkBox= driver.findElements(By.xpath("//input[@type='checkbox']"));
			checkBox.get(index).click();
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;}

	}
	

	
	//============================================================================================



	//========================================dropdown====================================================================
	//----select dropDown option thru value by xpath
	public void selectDropDownOptionByValueByXpath(String locator, String value ){
		try{
			WebElement dropDown= driver.findElement(By.xpath(locator));
			Select option= new Select(dropDown);
			option.selectByValue(value );	//select by value
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}
	}

	//----select dropDown option thru its visible text by xpath
	public void selectDropDownOptionByVisiblTxtByXpath(String locator, String VisibleTxt){
		try{
			WebElement dropDown= driver.findElement(By.xpath(locator));
			Select option= new Select(dropDown);
			option.selectByVisibleText(VisibleTxt);	//select by VisibleTxt
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}
	}
	//----select dropDown option thru its visible text by xpath
	public void selectDropDownOptionByIndexByXpath(String locator, int index){
		try{
			WebElement dropDown= driver.findElement(By.xpath(locator));
			Select option= new Select(dropDown);
			option.selectByIndex(index); //select by index
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;

		}

	}
	//============================================================================================

	//============================dragNdrop==============================================================


	//----//Drag Element And Drop on x-coordinate horizontally
	public void slideIconHorizontallyByXpath(String iconLocator,int xOffset){

		try{
			WebElement iCon = driver.findElement(By.xpath(iconLocator));
			Actions act = new Actions (driver);
			act.dragAndDropBy(iCon, xOffset, 0).build().perform(); 
			// act.dragAndDropBy(source, xOffset, yOffset) --horizontal
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}

	}
	//----Drag Element And Drop on y-coordinate vertically
	public void slideIconVerticallyByXpath(String iconLocator,int yOffset){

		try{
			WebElement iCon = driver.findElement(By.xpath(iconLocator));
			Actions act = new Actions (driver);
			act.dragAndDropBy(iCon, 0, yOffset).build().perform();
			// act.dragAndDropBy(source, xOffset, yOffset) --vertical
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}

	}

	//Drag One Element And Drop Into Another Element
	public void DragOneElementAndDropIntoAnotherElement(String element1Locator,String element2Locator){

		try{
			WebElement element1= driver.findElement(By.xpath(element1Locator));//draggableItem
			WebElement element2= driver.findElement(By.xpath(element2Locator));//droppableItem
			Actions act= new Actions(driver);
			act.dragAndDrop(element1, element2).build().perform();
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}

	}
	//---Mouse hoverover from one element (parent)to another element(child/ destination)which is enabled from parent element
	public void mouseHoveroverfromoneElementoAnotherByXpathNClick(String element1Locator,String element2Locator){

		try{

			WebElement element1 = driver.findElement(By.xpath(element1Locator));
			WebElement element2=driver.findElement(By.xpath(element2Locator));
			Actions act = new Actions (driver);
			act.moveToElement(element1).build().perform();
			element2.click();
		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but Could not Locate Xpath" );
			APPLICATION_LOG.debug(e );
			return;
		}

	}

	//============================================================================================
	//================================iFramew===================================================================================
	//switch to a iFrame
	public void switchToFrame(int farmeIndexNumber){

		try{

			driver.switchTo().frame(farmeIndexNumber);;

		}catch(Exception e)
		{
			APPLICATION_LOG.debug("Test Started but loactor couldnot be found" );
			APPLICATION_LOG.debug(e );
			return;
		}
	}

	//-----Printing Total Number is iFrame in the Webpage
	public void totaliFramesinPage(){

		try{
			System.out.println ("Total Number is iFrame in the Webpage is :"+ driver.findElements(By.tagName("iframe")).size());
		}catch(Exception e)
		{
			APPLICATION_LOG.debug(e );
			return;
		}
	}

	// ----- windows

	//--------alert
	public void closeAlert(){
		Alert al = driver.switchTo().alert();
		//System.out.println(al.getText());
		// al.accept();//OK
		al.dismiss();
	}



	//=======================Wait==================
	//--Globalwait/ wait for all web elements in webpage to be loaded
	public void implictWait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	//---Wait until an specific web element to be loaded in the webpage
	public void explicitWait(int time,String locators){
		WebDriverWait wait = new WebDriverWait (driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators)));
	}
	//======================xx==========================

}

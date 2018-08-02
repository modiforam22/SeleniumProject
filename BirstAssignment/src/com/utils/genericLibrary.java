package com.utils;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class genericLibrary extends resources {
	
	/**
	 * method to open browser
	 */
	public static void openbrowser()
	{
		System.out.println("openbrowser is called");
		String browser=Repository.getProperty("browser");
		String url=Repository.getProperty("url");
		try{
		if (browser.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(url);
		}
	    if(browser.equalsIgnoreCase("IE"))
	    {
	    	//code to open IE browser
	    	
	    }if(browser.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//resources//driver_chrome//chromedriver.exe");
	    	driver=new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    driver.get(url);
	    	
	    }
		}catch(Exception e)
		{
			System.out.println("Exception  while opening browser");
		}
	    	
	}
	/**
	 * Verify Title
	 * 
	 */
	
	public static void VerifyTitle(String expectedtitle) {
		System.out.println("VerifyTitle is called");
		try {
			String title=driver.getTitle();
			if(title.equalsIgnoreCase(expectedtitle))
			{
				System.out.println("Title is match  "+title);
			}
			else
			{
				System.out.println("Title is not matched Title is "+title);
			}
				
			
		}catch (Throwable t) {
			System.out.println("Failed -Exception in VerifyTitle ");
		}
		
	}
	
	/**
	 * Verify Element is displayed
	 */
	public static String VerifyElement(String webElement) {
		System.out.println("VerifyElement is called");
		try {
			
			if(getWebElement(webElement).isDisplayed())
			{
				System.out.println("webElement is displayed"+webElement);
				return "pass";
			}
			else
			{
				System.out.println("webElement is not displayed"+webElement);
				return"Fail";
			}
				
			
		}catch (Throwable t) {
			System.out.println("Failed -Exception in VerifyTitle ");
			return "Fail";
		}
		
	}
	/**
	 * s\method to select by visible text
	 */
	
	public static void selectbytext(String webElement,String value)
	{
		System.out.println("selectbytext is called");
		try {
			
			Select select=new Select(getWebElement(webElement));
			select.selectByVisibleText(value);
			
		}catch (Throwable t) {
			System.out.println( "Failed - Element not found "+webElement);
		}
		
	}
	
	/**
	 * click on link based on text
	 */
    
	public static void ClickonLinkText(String text ) {
		System.out.println("ClickonLinkText is called");
		try {
			List <WebElement> linkelements=driver.findElements(By.tagName("a"));
			  			 		  
			  Iterator<WebElement> iter= linkelements.iterator();
			  String label;
			  
			  while(iter.hasNext())
			  {
				  WebElement link=iter.next();
				  
				  label=link.getText();
				  
				 				  
				  if(label.equalsIgnoreCase(text))
				  {
					  link.click();
					  System.out.println("Link is clicked");
					  break;
				  }
				  
				  
			  }
			  
			
		}catch (Throwable t) {
			System.out.println( "Link with text not present "+text);
		}
		
	}
	
	/**
	 * Verify Birst logo
	 */
	
	public static void VerifyLogo( ) {
		System.out.println("VerifyLogo is called");
		try {

				WebElement logo= driver.findElement(By.xpath("//img[@alt='Birst - An Infor Company'][@class='desktop-logo']"));
				if(logo.isEnabled())
				{
					System.out.println("Logo is displayed");
				}
				else
				{
					System.out.println("Logo is not displayed");
				}
		}catch (Throwable t) {
			System.out.println( "Failed - logo not found ");
		}
		//System.out.println( "Pass");
	}
	
	
	/**
	 * method to inputtext
	 * @param webElement
	 * @param testdata
	 */
	public static void InputText(String webElement,String testdata ) {
		System.out.println("InputText is called");
		try {
			getWebElement(webElement).sendKeys(testdata);
		}catch (Throwable t) {
			System.out.println( "Failed - Element not found "+webElement);
		}
		//System.out.println( "Pass");
	}
	
    /**
     * method to click on lInk
     * @param webElement
     */
	public static void ClickOnLink(String webElement) {
		System.out.println("ClickOnLink is called");
		try {
			getWebElement(webElement).click();
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println( "Failed - Element not found "+webElement);
		}
		System.out.println( "Pass");
	}
	/**
	 * method to get locator
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public static WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	/**
	 * method to get locator
	 * @param locator
	 * @return
	 * @throws Exception
	 */
		public static WebElement getWebElement(String locator) throws Exception{
		System.out.println("locator data:-"+locator+"is---"+Repository.getProperty(locator));
		return getLocator(Repository.getProperty(locator));
	}
	
	
	

	
	
}

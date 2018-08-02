package com.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;





import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utils.genericLibrary;
import com.utils.resources;

public class Test1 extends resources {
	
	
	
  @Test(description= "Select webinar From Birst.com",priority=1)
  public void TestApplication() throws Exception {
	  
	  try {
			Initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  //open google.com
	  genericLibrary.openbrowser();
	  
	  genericLibrary.VerifyTitle("Google");
	  
	  
	  genericLibrary.InputText("google.Searchbox", "birst.com");
	  genericLibrary.getWebElement("google.Searchbox").sendKeys(Keys.TAB);
	  
	  genericLibrary.ClickOnLink("google.Searchbutton");
	  Thread.sleep(3000);
	  
	  genericLibrary.ClickonLinkText("Birst: Business Intelligence & Analytics, BI Software");
	  Thread.sleep(3000);
	  genericLibrary.VerifyLogo();
	  
	  //Open Resources
	  
	  genericLibrary.ClickonLinkText("Resources");
	  
	  Thread.sleep(3000);
	  
	  genericLibrary.selectbytext("birst.FilterByType","Webinar");
	  
	 genericLibrary.selectbytext("birst.FilterByRole","BI/IT");
	 
	 Thread.sleep(3000);
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 
	 //Open Webinar
	 
	 genericLibrary.ClickonLinkText("Introducing Birst 5X: Featuring Elekta Healthcare Analytics");
	 
	 genericLibrary.VerifyTitle("Introducing Birst 5X: Featuring Elekta Healthcare Analytics");
	 
	 driver.quit();
	 
	 ///-------------------//--------------------------//
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  
	  
	 // genericLibrary.ClickOnLink("google.link");
	  Thread.sleep(3000);
	  
//	  String stat= genericLibrary.VerifyElement("birst.logo");
//	  if (stat.equalsIgnoreCase("Pass"))
//	  {
//		  System.out.println("Logo is displayed");
//	  }
//	  else
//	  {
//		  System.out.println("Logo is not displayed");
//	  }
//	  
//	  genericLibrary.ClickOnLink("birst.Resources");
//	  
//	  Thread.sleep(3000);
//	  	
//	  genericLibrary.selectbytext("birst.FilterByType","Webinar");
//	  
//	  genericLibrary.selectbytext("birst.FilterByRole","BI/IT");
//	  
//	  genericLibrary.ClickOnLink("birst.webinar");
	  
	  
	  
	  
//	  List <WebElement> linkelements=driver.findElements(By.tagName("a"));
//	  
//	  System.out.println(linkelements.size());
//	  
//	  Iterator<WebElement> iter= linkelements.iterator();
//	  String label;
//	  
//	  while(iter.hasNext())
//	  {
//		  WebElement link=iter.next();
//		  
//		  label=link.getText();
//		  
//		  System.out.println(label);
//		  
//		  if(label.equalsIgnoreCase("Birst: Business Intelligence & Analytics, BI Software"))
//		  {
//			  link.click();
//			  break;
//		  }
//		  
//		  
//	  }
//	  
//	  driver.findElement(By.xpath("//a[text()='Birst: Business Intelligence & Analytics, BI Software']")).click();
//	  Thread.sleep(3000);
//	  
//	  
//	  driver.findElement(By.xpath("//*[@id='menu-item-233']/a[text()='Resources']")).click();
//	  
//	  
//	  genericLibrary.selectbytext("birst.FilterByType","Webinar");
//	  
//	  genericLibrary.selectbytext("birst.FilterByRole","BI/IT");
//	  
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//a[text()='Introducing Birst 5X: Featuring Elekta Healthcare Analytics']")).click();

//	  
//	  
//	  
//	  
	  
	  
	  
	  
  }
}

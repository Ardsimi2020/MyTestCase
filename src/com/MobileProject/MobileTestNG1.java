package com.MobileProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MobileTestNG1 {
	
	String url = "http://live.demoguru99.com";
	WebDriver driver;
	String pathdriver = "C:\\MyChromedriver\\chromedriver.exe";
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",pathdriver);
	  driver = new ChromeDriver();
  }
  
  @Test
  public void MobileTestNG() throws Exception {
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
	  
	//Add to compare 2 mobile Sony Xperia & Iphone
	   
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  String Mobile1 = driver.findElement(By.xpath("//*[@id=\"compare-items\"]/li/p/a")).getText();
	  System.out.println("My mobile 1 is" + " " + Mobile1);
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  String Mobile2 = driver.findElement(By.xpath("//*[@id=\"compare-items\"]/li[2]/p/a")).getText();
	  System.out.println(Mobile2);
	 
	  // Click on COMPARE
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button/span/span")).click();
	  
	  Thread.sleep(2000);
	  
	  //Switch to new window
	  for (String handle: driver.getWindowHandles()) {
		  
		  driver.switchTo().window(handle);

	  }
	  
	  //Verify the pop-up window and check that the products are reflected in it Heading "COMPARE PRODUCTS" with selected products in it.
	  String ActualHeading = "COMPARE PRODUCTS";
	  String ExpectedHeading = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[1]/h1")).getText();
	  System.out.println(ExpectedHeading);
	  
	  String Mobile3 = driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2/a")).getText();
	  String Mobile4 = driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")).getText();
	  System.out.println(Mobile3);
	  System.out.println(Mobile4);
	  
	  //This is to check the heading message"COMPARE PRODUCTS"
	  Assert.assertEquals(ActualHeading, ExpectedHeading);
	  
	  //This is to compare Sony Xperia and Iphone
	  Assert.assertEquals(Mobile1, Mobile4);
	  
	//This is to check IPHONE and Sony Xperia
	  Assert.assertEquals(Mobile2, Mobile3);
	  
	  
	  //Close the Pop up Windows
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/button/span/span")).click();
	  

  }

  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  
	  driver.quit();
  }

}

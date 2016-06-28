package automationFramework;

import org.testng.Assert;



import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.*;


 
public class safari {
 
	//Declare our variables
	WebDriver driver = new SafariDriver();
	
	
	@Test (priority = 1)
    public void verifyHomepage() {
    	
		driver.get("https://www.thetrainline.com");
    	//Create a new homepage object ,passing in our driver
    	
	}
	
	@Test (priority = 2)
	 public void addDestination() {
		Homepage homepage = new Homepage(driver);
    	
    	//Interact with from and to field
    	homepage.from.sendKeys("London Bridge", Keys.TAB);
    	homepage.to.sendKeys("Brighton", Keys.TAB);
    	
	}
        
     @Test (priority = 3)
   	 public void tomorrow() {
   		Homepage homepage = new Homepage(driver);	
    	//set tomorrow
    	if (homepage.calendar.isDisplayed()){
    		homepage.setOutDate(1);
    	}
    	
    	else if(homepage.tomorrow.isDisplayed()){
    		homepage.tomorrow.click();}
    	
    	else {
    		homepage.outDate.click();
    		homepage.setOutDate(1);
    	
    	}
     }
    
     @Test (priority = 4)
	 public void nextDay() {
		Homepage homepage = new Homepage(driver);
    	//add return and Next day
    	if (!homepage.oneWay.isDisplayed()){
    		homepage.addReturn.click();
    		{homepage.returnDate.click();
    		homepage.setReturnDate(1);}
    	}
    	else if (homepage.nextDay.isDisplayed()){
    		homepage.nextDay.click();}
    	
    		else {homepage.returnDate.click();
    		homepage.setReturnDate(1);
    	}
     }
     
     @Test (priority = 5)
	 public void oneWay() {
		Homepage homepage = new Homepage(driver);
    	
    	if (homepage.oneWay.isSelected()){
    	 homepage.oneWay.click();}
     }
     
     @Test (priority = 6)
	 public void submit() {
		Homepage homepage = new Homepage(driver);
		
		//click submit
    	homepage.submit.click();
     }
     
   
     
     @Test (priority = 7)
	 public void timetable() {
		Homepage homepage = new Homepage(driver);
		
		  Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		  
		  try {
			  wait.until(ExpectedConditions.visibilityOf(homepage.timetable));
		  
		 	  } catch(Exception e) {
		     
		
    	//Check timetable page
    	if (!homepage.timetable.isDisplayed()){
        	Assert.fail("Not on the prices page");
    	}
		 	  }
     }
		  @AfterTest
		    public void terminateBrowser(){
		    	
		    	driver.quit();}
		    
     }
    	
   
    
	

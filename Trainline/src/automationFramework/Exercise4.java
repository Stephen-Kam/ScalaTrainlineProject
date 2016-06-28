package automationFramework;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

 
public class Exercise4 {
 
    public static void main(String[] args) throws Exception {
    	//Declare our variables
    	WebDriver driver;
    	driver = new FirefoxDriver ();
    	driver.get("https://www.thetrainline.com");
    	
    	//Create a new homepage object ,passing in our driver
    	Homepage homepage;
    	homepage = new Homepage(driver);
    	
    	//Interact with from and to field
    	homepage.from.sendKeys("London Bridge");
    	homepage.to.sendKeys("Brighton");
    	
    	
    	
    	//set tomorrow
    	if (homepage.tomorrow.isDisplayed()){
    		homepage.tomorrow.click();}
    	
    	else {
    		homepage.outDate.click();
    		homepage.setOutDate(1);
    	
    	}
    	
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
    	
    	
    	if (homepage.oneWay.isSelected()){
    	 homepage.oneWay.click();}
    	
    	homepage.submit.click();
    		
    	//Check timetable page
    	if (homepage.timetable.isDisplayed()){
        	Assert.fail("Not on the prices page");
    	}
    		
    		}
    		
    		
    	
    	
    	
    	
 }
    
    


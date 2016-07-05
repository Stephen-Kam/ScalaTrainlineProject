package automationFramework;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

 
public class Exercise6 {
 
	//Declare our variables
	private WebDriver driver;
	
	@Parameters
	({"browser"})
	
	@BeforeTest
	public void openBrowser(String browser) {
		try { 
			if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
          } 
          else if (browser.equalsIgnoreCase("Safari")) {
              driver = new SafariDriver();
       }
          else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/Users/umargurung/Desktop/chromedriver");
                driver = new ChromeDriver();
          
          }
          
  
   } catch (WebDriverException e) {
          System.out.println(e.getMessage());
   }
  
}

	
	
	@Test (priority = 1)
    public void verifyHomepage() {
    	
		driver.get("https://www.thetrainline.com");
    	//Create a new homepage object ,passing in our driver
    	
	}
	
	@Test (priority = 2)
	 public void addDestination() {
		Homepage homepage = new Homepage(driver);
    	
    	//Interact with from and to field
    	homepage.from.sendKeys("London Bridge");
    	homepage.to.sendKeys("Brighton");
    	
    	
	}
        
     @Test (priority = 3)
   	 public void tomorrow() {
   		Homepage homepage = new Homepage(driver);	
    	//set tomorrow
    	if (homepage.tomorrow.isDisplayed()){
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
    	//Check timetable page
    	if (!homepage.timetable.isDisplayed()){
        	Assert.fail("Not on the prices page");
    	}
     }
    	
    @AfterTest
    public void terminateBrowser(){
    	
    	driver.quit();}
    }
	

    	
    		

    	
    	
    	
    	
 
    
    



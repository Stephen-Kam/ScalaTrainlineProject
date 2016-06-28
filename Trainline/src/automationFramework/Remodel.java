package automationFramework;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.*;


 
public class Remodel {
 
	int i = 1;
	int j = i + 1;

	private WebDriver driver;
	@Parameters({ "browser" })
    
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
    public void verifyHomeRemodel() {
    	
		driver.get("https://www.thetrainline.com");
    	//Create a new homeRemodel object ,passing in our driver
    	
	}
	
	@Test (priority = 2)
	 public void addDestination() {
		HomeRemodel homeRemodel = new HomeRemodel(driver);
    	
    	//Interact with from and to field
    	homeRemodel.from.sendKeys("London Bridge", Keys.TAB);
    	homeRemodel.to.sendKeys("Brighton", Keys.TAB);
    	
	}
        
     @Test (priority = 3)
   	 public void tomorrow() {
   		HomeRemodel homeRemodel = new HomeRemodel(driver);	
    	//set tomorrow
    	if (homeRemodel.calendar.isDisplayed()){
    		homeRemodel.setOutDate(i);
    	}
    	
    	else if(homeRemodel.tomorrow.isDisplayed()){
     		homeRemodel.tomorrow.click();}
     	
    	else {
    		homeRemodel.outDate.click();
    		homeRemodel.setOutDate(i);
    	
    	}
     }
    
     @Test (priority = 4)
	 public void nextDay() {
		HomeRemodel homeRemodel = new HomeRemodel(driver);
    	//add return and Next day
    	if (!homeRemodel.oneWay.isDisplayed()){
    		homeRemodel.addReturn.click();
    		{homeRemodel.returnDate.click();
    		homeRemodel.setReturnDate(j);}
    	}
    	else if (homeRemodel.nextDay.isDisplayed()){
    		homeRemodel.nextDay.click();}
    	
    	
    		else {homeRemodel.returnDate.click();
    		homeRemodel.setReturnDate(j);
    	}
     }
     
     @Test (priority = 5)
	 public void oneWay() {
		HomeRemodel homeRemodel = new HomeRemodel(driver);
    	
    	if (homeRemodel.oneWay.isSelected()){
    	 homeRemodel.oneWay.click();}
     }
     
     @Test (priority = 6)
	 public void submit() {
		HomeRemodel homeRemodel = new HomeRemodel(driver);
		
		//click submit
    	homeRemodel.submit.click();
     }
     
   
     
     @Test (priority = 7)
	 public void timetable() {
		HomeRemodel homeRemodel = new HomeRemodel(driver);
		
		  Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		  
		  try {
			  wait.until(ExpectedConditions.visibilityOf(homeRemodel.timetable));
		  
		 	  } catch(Exception e) {
		     
		
    	//Check timetable page
    	if (!homeRemodel.timetable.isDisplayed()){
        	Assert.fail("Not on the prices page");
    	}
		 	  }
     }
		  @AfterTest
		    public void terminateBrowser(){
		    	driver.close();
		    	driver.quit();}
		    
     }
    	
   
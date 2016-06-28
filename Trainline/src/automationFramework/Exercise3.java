package automationFramework;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
 
public class Exercise3 {
 
    public static void main(String[] args) throws Exception {
        // declaration and instantiation of objects/variables
    	WebDriver driver;
        
        //page variables
        WebElement from;
        WebElement to;
        WebElement find;
        WebElement today;
        
        
        //open the Website
        driver = new FirefoxDriver();
        driver.get("https://www.thetrainline.com");
        
        //check the page title
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Page title contains 'Trainline'", pageTitle.contains("Trainline"));
        
       
        
        //set the to and from values
        from = driver.findElement(By.xpath(".//*[@id='originStation']"));
        from.sendKeys("Brighton");
        to = driver.findElement(By.xpath(".//*[@id='destinationStation']"));
        to.sendKeys("London Bridge");
        
        //set tomorrow
        if (driver.findElement(By.xpath(".//*[@id='extendedSearchForm']/div[2]/div[1]/div/div[1]/button[2]")).isDisplayed()) 
        {
        	driver.findElement(By.xpath(".//*[@id='extendedSearchForm']/div[2]/div[1]/div/div[1]/button[2]")).click();
        
         }
        
        else {
        	driver.findElement(By.xpath(".//*[@id='outDate']")).click();
        		
        	today = driver.findElement(By.className("ui-datepicker-days-cell-over ui-datepicker-current-day ui-datepicker-today"));
        	System.out.println(today);
        	
        	
        	
        
        
        
        // set next day
        if (driver.findElement(By.xpath(".//*[@id='extendedSearchForm']/div[2]/div[2]/div/div[1]/button[2]")).isDisplayed())
        {
        	driver.findElement(By.xpath(".//*[@id='extendedSearchForm']/div[2]/div[2]/div/div[1]/button[2]")).click();
        }
        
        else {
        	driver.findElement(By.xpath(".//*[@id='returnDate']")).click();

        }
        
        
        // uncheck Oneway
        if (driver.findElement(By.xpath(".//*[@id='isOneWay']")).isSelected())
        {
        	driver.findElement(By.xpath(".//*[@id='isOneWay']")).click();
        }
        
        //now search
        find = driver.findElement(By.xpath(".//*[@id='submitButton']"));
        find.click();
        
        
        	
        if (driver.findElements(By.xpath(".//*[@id='timetable']")).size() == 0) {
        	Assert.fail("Not on the prices page");
        }
        
       
    }


		
    }}
 

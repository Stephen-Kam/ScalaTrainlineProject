package automationFramework;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
 
public class Exercise2 {
 
    public static void main(String[] args) throws Exception {
        // declaration and instantiation of objects/variables
    	WebDriver driver;
        
        //page variables
        WebElement from;
        WebElement to;
        WebElement find;
        
        
        //open the Website
        driver = new FirefoxDriver();
        driver.get("https://www.thetrainline.com");
        
        //check the pagetitle
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Page title contains 'Trainline'", pageTitle.contains("Trainline"));
        
       
        
        //set the to and from values
        from = driver.findElement(By.xpath(".//*[@id='originStation']"));
        from.sendKeys("Brighton");
        to = driver.findElement(By.xpath(".//*[@id='destinationStation']"));
        to.sendKeys("London Bridge");
        //now search
        find = driver.findElement(By.xpath(".//*[@id='submitButton']"));
        find.click();
        
        	
        if (driver.findElements(By.xpath(".//*[@id='timetable']")).size() == 0) {
        	Assert.fail("Not on the prices page");
        }
        
       
    }
 
}
package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.junit.Assert;
 
public class Testclass {
 
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
        
        String eTitle = driver.getTitle();
        
        
       
        if (eTitle.contains("Trainline")){
        //set the to and from values
        from = driver.findElement(By.xpath(".//*[@id='originStation']"));
        from.sendKeys("Brighton");
        to = driver.findElement(By.xpath(".//*[@id='destinationStation']"));
        to.sendKeys("London");
        
        //now search
        find = driver.findElement(By.xpath(".//*[@id='submitButton']"));
        find.click();
        } else {
        	System.out.println("Test Failed");
        }
       
    }
 
}
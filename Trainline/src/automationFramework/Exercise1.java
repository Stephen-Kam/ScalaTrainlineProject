package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
 
public class Exercise1 {
 
    public static void main(String[] args) throws Exception {
        // declaration and instantiation of objects/variables
    	 WebDriver driver;

         //page variables
         WebElement from;
         WebElement to;
         WebElement find;

         //open the website
         driver = new FirefoxDriver();
         driver.get("http://sports.williamhill.com/bet/en-gb");

         //set the to and from values
         from = driver.findElement(By.xpath(".//*[@id='tmp_username_div']/input"));
         from.sendKeys("Brighton");
         to = driver.findElement(By.xpath(".//*[@id='tmp_password']"));
         to.sendKeys("London");

         //now search
         find = driver.findElement(By.xpath(".//*[@id='signInBtn']"));
         find.click();
       
    }
 
}


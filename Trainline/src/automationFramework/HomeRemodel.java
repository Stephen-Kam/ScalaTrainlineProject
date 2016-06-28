package automationFramework;
 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.*;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
 
public class HomeRemodel {
               
                WebDriver driver;
               
                // Find all of the elements and assign them names
               
                @FindBy (xpath="//*[@id='originStation']")
                WebElement from;
               
                @FindBy (xpath="//*[@id='destinationStation']")
                WebElement to;
               
                
                //Tomorrow
                @FindBy (xpath=".//*[@id='extendedSearchForm']/div[2]/div[1]/div/div[1]/button[2]")
                WebElement tomorrow;
                @FindBy (xpath="//*[@id='outDate']")
                WebElement outDate;
                @FindBy (xpath=".//*[@id='ui-datepicker-div']")
                WebElement calendar;
                
                //add return
                @FindBy (xpath="//*[@id='add-return']")
                WebElement addReturn;
                
                //NextDay
                @FindBy (xpath=".//*[@id='extendedSearchForm']/div[2]/div[2]/div/div[1]/button[2]")
                WebElement nextDay;
                @FindBy (xpath="//*[@id='returnDate']")
                WebElement returnDate;
                
                //uncheck Oneway
                @FindBy (xpath=".//*[@id='isOneWay']")
                WebElement oneWay;
                
                //Search
                @FindBy (xpath="//*[@id='submitButton']")
                WebElement submit;
                
                //Check timetable
                @FindBy (xpath="//*[@id='timetable']/div[2]")
                WebElement timetable;
               
                //Calendar
                @FindBy (xpath=".//*[@id='ui-datepicker-div']/*") 
                List<WebElement> calendars;
                
                //Calendar next
                @FindBy (xpath=".//*[@id='ui-datepicker-div']/div[2]/div/a/span")
                WebElement nextMonth;
                
                //Chosen out date
                @FindBy (className="ui-datepicker-days-cell-over")
                WebElement chosenDate;
                
               
                
                
                public HomeRemodel(WebDriver driver){
                               
                                this.driver = driver;
                                System.out.println("Homepage object has been created");
                               
                                // When the object is created, all of the variables will be set up
                               
                                PageFactory.initElements(driver, this);
                }
               
                // Exercise 5
                public void setOutDate(Integer DaysInFuture) {
                	Boolean datefound = false;
                	SimpleDateFormat sdf;
                	
                	//Set the out date
                	Calendar calendar = Calendar.getInstance();
                	calendar.setTime(new Date());
                	calendar.add(Calendar.DATE, DaysInFuture);
                	//setup the text to find in calendar
                	sdf = new SimpleDateFormat("MMMM yyyy");
                	String headerToFind = sdf.format(calendar.getTime());
                	sdf = new SimpleDateFormat("d");
                	String dayToFind = sdf.format(calendar.getTime());
                	
                	
                	while(datefound == false){
                		//get a list of all the datepicker boxes and iterate them
                		for (WebElement cal : calendars) {
                			if (cal.getText().contains(headerToFind)){
                			cal.findElement(By.linkText(dayToFind)).click();
                			datefound = true;
                			break;
                		}
                		
                	}
                	//If we didn't find the date we can click next and look back around again?
                		if (datefound == false){
                			nextMonth.isDisplayed();
                			nextMonth.click();
                		}
                	}
                
                      if (datefound == false){
                    	  throw new IllegalStateException("Date[" + calendar.toString() + "] could not be selected");
                      }
                      }
                             
                                
                public void setReturnDate(Integer DaysInFuture) {
                	Boolean datefound = false;
                	SimpleDateFormat sdf;
                	
                	//Set the return date
                	Calendar calendar = Calendar.getInstance();
                	calendar.setTime(new Date());
                	calendar.add(Calendar.DATE, DaysInFuture);
                	//setup the text to find in calendar
                	sdf = new SimpleDateFormat("MMMM yyyy");
                	String headerToFind = sdf.format(calendar.getTime());
                	sdf = new SimpleDateFormat("d");
                	String dayToFind = sdf.format(calendar.getTime());
                	
                	
                	while(datefound == false){
                		//get a list of all the datepicker boxes and iterate them
                		for (WebElement cal : calendars) {
                			if (cal.getText().contains(headerToFind)){
                			cal.findElement(By.linkText(dayToFind)).click();
                			datefound = true;
                			break;
                		}
                		
                	}
                	//If we didn't find the date we can click next and look back around again?
                		if (datefound == false){
                			nextMonth.isDisplayed();
                			nextMonth.click();
                		}
                	}
                
                      if (datefound == false){
                    	  throw new IllegalStateException("Date[" + calendar.toString() + "] could not be selected");
                      }
                      }
}      	
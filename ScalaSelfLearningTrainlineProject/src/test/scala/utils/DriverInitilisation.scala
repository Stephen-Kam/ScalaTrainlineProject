package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object SingletonDriver {

  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stephen.Kam\\Desktop\\drivers\\chromedriver.exe")
  val driver: WebDriver = new ChromeDriver()
}

trait DriverInitialisation {

  implicit lazy val driver = SingletonDriver.driver

}

package utils

import org.scalatest.selenium.WebBrowser
import org.scalatest._

trait BaseFeatureSpec
  extends FeatureSpec
    with GivenWhenThen
    with DriverInitialisation
    with Matchers
    with WebBrowser
    with BeforeAndAfterEach {

  override def beforeEach() = {
    delete all cookies
    driver.manage().window().maximize()
  }
}

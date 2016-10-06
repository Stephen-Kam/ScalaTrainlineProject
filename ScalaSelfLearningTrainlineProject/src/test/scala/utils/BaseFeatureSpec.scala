package utils

import org.scalatest.selenium.WebBrowser
import org.scalatest._

trait BaseFeatureSpec
  extends FeatureSpec
    with GivenWhenThen
    with DriverInitialisation
    with Matchers
    with WebBrowser
    with BeforeAndAfterEach
    with BeforeAndAfterAll {

  override def beforeEach() = {
    driver.manage.deleteAllCookies()
    driver.manage().window().maximize()
  }

  override def afterAll() = {

  }
}

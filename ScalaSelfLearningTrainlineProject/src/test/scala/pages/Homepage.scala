package pages

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import utils.BaseFeatureSpec

import scala.util.Random

object Homepage extends BaseFeatureSpec {

  var randomNumberOfAdults = ""

  var dateToCheck: String = "7th Oct"

  def tomorrowXpath() = find(xpath(".//*[contains(text(),'Tomorrow')]"))

  def nextDayXpath() = find(xpath(".//*[contains(text(),'Next day')]"))

  def adultsAndRailcardXpath() = find(xpath(".//*[@class='btn btn-default btn-open']"))

  def adultsAndRailcardCloseXpath() = find(xpath(".//*[@class='btn btn-block btn-primary btn-done']"))

  def navigateToWebPage() = {
    go to "https://www.thetrainline.com"
  }

  def checkOneWayCheckbox() = {
    if (checkbox("isOneWay").isSelected) checkbox("isOneWay").select()
  }

  def clickTomorrowAndNextDay() = {
    tomorrowXpath().get.underlying.click()
    nextDayXpath().get.underlying.click()
  }

  def enterInStations() = {
    searchField("originStation").value = "London"
    searchField("destinationStation").value = "Brighton"
  }

  def selectNumberOfAdultsAndClose() = {
    click on adultsAndRailcardXpath().get
    randomNumberOfAdults = Random.nextInt(10).toString
    singleSel("adults").value = randomNumberOfAdults
    click on adultsAndRailcardCloseXpath().get
  }

  def selectDate(daysInFuture: Long) {
        click on "outDate"
        var datefound: Boolean = false
        val futureDate: LocalDate = LocalDate.now().plusDays(daysInFuture)
        println(futureDate)
        val headerToFind: String = futureDate.format(DateTimeFormatter.ofPattern("MMMM yyyy"))
        val dayToFind: String = futureDate.format(DateTimeFormatter.ofPattern("d"))
        dateToCheck = getDateprefix(dayToFind)
        val isPresent = find(xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a/span"))
        while (!datefound) {
          if (find(xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div")).get.underlying.getText contains headerToFind) {
            click on linkText(dayToFind.toString)
            datefound = true
          }
          if (!datefound) {
            if (isPresent.isDefined) find(xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a/span")).get.underlying.click()
            else throw new IllegalStateException("Date [" + futureDate.toString + "] could not be selected")
          }
    }
  }

  def getDateprefix(day: String): String = day match {
    case "1" | "21" | "31" => day + "st"
    case "2"| "22" => day + "nd"
    case "3" => day + "rd"
    case _ => day + "th"
  }
}



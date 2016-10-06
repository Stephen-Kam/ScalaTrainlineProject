package pages

import utils.BaseFeatureSpec

object Homepage extends BaseFeatureSpec {

  def outDateXpath() = find(xpath(".//*[@class='matrix-date']"))

  def tomorrowXpath() = find(xpath(".//*[contains(text(),'Tomorrow')]"))

  def nextDayXpath() = find(xpath(".//*[contains(text(),'Next day')]"))

  def navigateToWebPage() = {
    go to "https://www.thetrainline.com"
  }

  def assertPageTitleIsCorrect() = {
    pageTitle should include regex "Trainline"
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

  def assertTimetableOutdateIsCorrect() = {
    outDateXpath().get.text should include regex "7th Oct"
  }
}



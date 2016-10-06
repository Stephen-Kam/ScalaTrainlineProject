package pages

import utils.BaseFeatureSpec

object TimetablePage extends BaseFeatureSpec {

  def outDateXpath() = find(xpath(".//*[@class='matrix-date']"))

  def timetableSubheaderXpath() = find(xpath(".//*[@class='matrix-subheader']"))

  def assertTimetableOutdateIsCorrect() = {
    outDateXpath().get.text should include regex Homepage.dateToCheck
  }

  def assertPageTitleIsCorrect() = {
    pageTitle should include regex "Trainline"
  }

  def assertCorrectNumberOfAdults() = {
    timetableSubheaderXpath().get.text should include regex Homepage.randomNumberOfAdults + " adult"
  }
}

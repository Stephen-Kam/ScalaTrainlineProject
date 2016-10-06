package trainline

import pages.{Homepage, TimetablePage}
import utils.BaseFeatureSpec

class TrainlineMain extends BaseFeatureSpec {

  feature("To test the trainline website") {
    scenario("Exercise One") {
      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      When("I enter in the two stations and click submit")
      searchField("originStation").value = "London"
      searchField("destinationStation").value = "Brighton"

      And("I click submit")
      click on "submitButton"
    }

    scenario("Exercise Two") {
      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      Then("The page title will be correct")
      pageTitle should include regex "Trainline"

      When("I enter in the two stations and click submit")
      searchField("originStation").value = "London"
      searchField("destinationStation").value = "Brighton"

      And("I click submit")
      click on "submitButton"

      Then("The timetable will be visible")
      find(xpath(".//*[@id='timetable']/div[2]")) shouldBe defined
    }

    scenario("Exercise Three") {
      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      Then("The page title will be correct the oneway option unchecked")
      pageTitle should include regex "Trainline"
      if (checkbox("isOneWay").isSelected) checkbox("isOneWay").select()

      When("I enter in the two stations")
      searchField("originStation").value = "London"
      searchField("destinationStation").value = "Brighton"

      And("I click the tomorrow and next day buttons")
      find(xpath(".//*[contains(text(),'Tomorrow')]")).get.underlying.click()
      find(xpath(".//*[contains(text(),'Next day')]")).get.underlying.click()

      When("I click submit")
      click on "submitButton"

      Then("The correct outDate will be visible")
      find(xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.text should include regex "7th Oct"
    }

    scenario("Exercise Four") {
      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      Then("The page title will be correct the oneway option unchecked")
      pageTitle should include regex "Trainline"
      if (checkbox("isOneWay").isSelected) checkbox("isOneWay").select()

      When("I enter in the two stations")
      searchField("originStation").value = "London"
      searchField("destinationStation").value = "Brighton"

      And("I click the tomorrow and next day buttons")
      Homepage.tomorrowXpath().get.underlying.click()
      Homepage.nextDayXpath().get.underlying.click()

      When("I click submit")
      click on "submitButton"

      Then("The correct outDate will be visible")
      TimetablePage.outDateXpath().get.text should include regex "7th Oct"
    }

    scenario("Exercise Five") {
      Given("I am on a the trainline website")
      Homepage.navigateToWebPage()

      Then("The page title will be correct the oneway option unchecked")
      TimetablePage.assertPageTitleIsCorrect()
      Homepage.checkOneWayCheckbox()

      When("I enter in the two stations")
      Homepage.enterInStations()

      And("I click the tomorrow and next day buttons")
      Homepage.clickTomorrowAndNextDay()

      When("I click submit")
      click on "submitButton"

      Then("The correct outDate will be visible")
      TimetablePage.assertTimetableOutdateIsCorrect()
    }

    scenario("Exercise Six") {
      Given("I am on a the trainline website")
      Homepage.navigateToWebPage()

      Then("The page title will be correct the oneway option unchecked")
      TimetablePage.assertPageTitleIsCorrect()
      Homepage.checkOneWayCheckbox()

      When("I enter in the two stations and click the tomorrow and next day buttons")
      Homepage.enterInStations()
      Homepage.clickTomorrowAndNextDay()

      And("select a number of adults for the journey")
      Homepage.selectNumberOfAdultsAndClose()

      When("I click submit")
      click on "submitButton"

      Then("The correct number of adults will be visible")
      TimetablePage.assertCorrectNumberOfAdults()
    }

    scenario("Exercise Seven") {
      Given("I am on a the trainline website")
      Homepage.navigateToWebPage()

      Then("The page title will be correct the oneway option unchecked")
      TimetablePage.assertPageTitleIsCorrect()
      Homepage.checkOneWayCheckbox()

      When("I enter in the two stations and I select an outdate in the future")
      Homepage.enterInStations()
      Homepage.selectDate(60)

      And("I click submit")
      click on "submitButton"

      Then("The correct outdate will be displayed")
      TimetablePage.assertTimetableOutdateIsCorrect()
    }
  }
}

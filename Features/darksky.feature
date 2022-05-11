Feature:  darksky whether page testing(darksky.net - whether forecasting website https://darksky.net/forecast/28.627,77.2154/us12/en )

#1
  @CurrentTemp
  Scenario: Verify Current Temperature should be equal to Temperature from Daily Timeline
    Given I am on Darksky Home Page
    Then I verify current temp is equal to Temperature from Daily Timeline

#2
  @TimeList
  Scenario: Verify timeline is displayed incorrect format
    Given I am on Darksky Home Page
    Then I verify timeline is displayed with two hours incremented


#3
  @todaysTemp
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    Then I verify today's lowest and highest temp is displayed correctly

#4:
  @login
  Scenario: Verify invalid error message on Login Page
    Given I am on the darksky Login page
    When I click on Login button
    Then I verify I am on the Login page itself by asserting Login page title
Feature: Application Login

  @LoginTest
  Scenario: Home Page default login
#    Given user is on landing page
    When user login into application with username "onecx" and password "onecx"
    Then user clicks on login button

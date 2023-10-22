Feature: Login feature
  # TC-SD-001
  Scenario: user input valid username and valid password
    Given user on login page
    When User input valid username
    And User input valid password
    And User click button login
    Then user redirect to inventory

  # TC-SD-002
  Scenario: login with locked account
    Given user on login page
    When User input locked username
    And User input locked password
    And User click button login
    Then show error account locked
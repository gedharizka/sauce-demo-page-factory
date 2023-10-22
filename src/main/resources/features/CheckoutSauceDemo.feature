Feature: Checkout feature
  # TC-SD-001
  Scenario: User full fill form your information
    Given user on page check out step one
    When user input valid firstname
    And user input valid lastname
    And user input valid postal code
    And user click continue
    And user redirect to checkout step two
    And user click finish
    Then checkout complete

  # TC-SD-002
  Scenario: user not input lastname
    Given user on page check out step one
    When user input valid firstname
    And user input valid postal code
    And user click continue
    Then show error lastname required


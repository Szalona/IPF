Feature: First

  Scenario: Check if it possible to take more money than user have
    Given login to platform as account with 200 pln
    When user wants to take 500 pln
    Then check the error message
    And check how much money we took
    And check how much money left on account
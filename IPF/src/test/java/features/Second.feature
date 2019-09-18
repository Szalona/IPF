Feature: Second
  Scenario Outline:
    Given login to platform as account with 200 pln
    When user wants to take "<amount>" pln
    Then check if the value is correct
    And check if the value on account is correct

    Examples:
    |amount|
    |0     |
    |50    |
    |100   |
    |150   |
    |200   |
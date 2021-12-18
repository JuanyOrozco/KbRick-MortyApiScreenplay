Feature: Juana as a Rick & Morty Fan
  Want to get the character list available in the api https://rickandmortyapi.com/
  To compare the results with her searching

  @Smoke @Regression
  Scenario: Wants to get all characters
    Given Juana is a fan of Rick & Morty
    When she requests to get all the characters
    Then she should see that the response is successful

  @Smoke @Regression
  Scenario: Wants to get the total of characters
    Given Juana is a fan of Rick & Morty
    When she requests to get all the characters
    Then she should see that the number of characters is 826

  @Smoke @Regression
  Scenario: Wants to see the content type header
    Given Juana is a fan of Rick & Morty
    When she requests to get all the characters
    Then she should see that the content type header is a Json format

  @Smoke @Regression
  Scenario Outline: Wants to get a specific character name
    Given Juana is a fan of Rick & Morty
    When she requests to get the character named "<name>""<lastName>"
    Then she should see the full name of the character requested

    Examples:
      |name   |lastName |
      | Rick  |Sanchez  |
      | Beth  |Smith    |
      | Morty |Smith    |

  @Regression
  Scenario Outline: Wants to get a specific character location
    Given Juana is a fan of Rick & Morty
    When she requests to get the character named "<name>""<lastName>"
    Then she should see the location of the character requested is "<location>"

    Examples:
      |name   |lastName |location                     |
      | Rick  |Sanchez  |Citadel of Ricks             |
      | Beth  |Smith    |Earth (Replacement Dimension)|
      | Morty |Smith    |Citadel of Ricks             |
Feature: Search for Swagger UI
  As a user
  I want to be able to search for Swagger UI

  Scenario: Search for Swagger UI
    Given I am on the homepage
    When I search for "Swagger UI"
    Then I should see results for "Swagger UI"

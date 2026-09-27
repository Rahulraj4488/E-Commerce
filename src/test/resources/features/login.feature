Feature: Login functionality

  Scenario: Successful login

    Given I am on the login page

    When I enter valid username and password

    And I click the login button

    Then I should see the home page

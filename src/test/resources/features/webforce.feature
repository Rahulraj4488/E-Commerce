Feature: Selenium Web Form

  Scenario: Submit the web form successfully

    Given I open the Selenium web form

    When I enter "Rahul" in the text box

    And I click the Submit button

    Then I should see the message "Received!"
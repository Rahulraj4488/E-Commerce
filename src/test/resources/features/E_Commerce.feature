Feature: E-Commerce Order

  @e2e
  Scenario: Customer places an order successfully

    Given I create a test customer using API
    And I have a valid product available
    When I login to the application using the test customer
    And I add the product to the cart
    And I complete the checkout
    Then the order should be created successfully
    And I verify the order using API
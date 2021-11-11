Feature: Amazon Test Case

  Scenario: Validate if total price and quantity has been correctly changed
    Given I perform a search for "hats for men"
    And I add the first hat appearing to Cart twice
    When I open the cart
    Then total price and quantity should be correct
    But if I reduce the quantity to 1 item in the Cart
    Then total price and quantity should be changed

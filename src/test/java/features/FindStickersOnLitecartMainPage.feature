Feature: Testing the stickers on Litecard main page

  Scenario: Find the images with stickers
    When I open Litecart main page
    Then I make sure that at least one duck image with any sticker should be present
    And I make sure that more than one duck image has a sale sticker

  Scenario: Check that sale price is presented for sale sticker
    When I open Litecart main page
    Then I make sure that sale price is shown for image with sale sticker

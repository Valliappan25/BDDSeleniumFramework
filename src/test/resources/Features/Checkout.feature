Feature: Search and Place order for Products.
@PlaceOrder
Scenario Outline: Search Experience for Products in both product and offer page

Given user is on Greenkart Landing page
When user search with Shortname "<Name>" and extract actual name of product
And Added "3" item of selected product to cart
Then user proceed to checkout and validate "<Name>" in checkout page
And user havs ability to enter promo code and place the order

Examples: 
|Name|
|Pota|
|Tom |
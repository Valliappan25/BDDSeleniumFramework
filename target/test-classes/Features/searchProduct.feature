Feature: Search and Place order for Products.

@SearchProduct
Scenario Outline: Search Experience for Products in both product and offer page

Given user is on Greenkart Landing page
When user search with Shortname "<Name>" and extract actual name of product
Then user search for "<Name>" Shortname in offer page.
And Validate the product name in offer page with landing page

Examples: 
|Name|
|Tom |
|Beet|

@tag
Feature: Purchase the order from Ecommerce website
  Purchase the items ffrom the selected items list.

  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
    
  Background:
  Given I land on Ecommerce page

  @Regression
  Scenario Outline: Positive test for submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name  						| password 				 | productName |
      | spatel@gmail.com | Keshav&jivan13    | ZARA COAT 3, IPHONE 13 PRO |

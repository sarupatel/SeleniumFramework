
@tag
Feature: Error Validations
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Incorrect login validation
    Given I land on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." is displayed

    Examples: 
      | name  					 | password | 
      | spatel@gmail.com | Keshav   | 
      

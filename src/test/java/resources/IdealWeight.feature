#Author: ainhoasb@uma.es
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculating a person's ideal weight.
    As a HealthCalc user I want to calculate my ideal weight So that achieving a healthy weight
  @tag1
  Scenario Outline: The parameters for calculating the ideal weight are valid.
    Given A HealthCalc user
    When The user enters valid values for ideal weight, height <height> and gender <gender>
    Then The system returns the value <value>

    Examples: 
      | height | gender | value |
      | 170    | "m"    | 65.0  |
      | 190    | "m"    | 80.0  |
      | 160    | "w"    | 56.0  |
      | 175    | "w"    | 65.0  |

    
  @tag2
  Scenario Outline: The parameters for calculating ideal weight are incorrect.
    Given A HealthCalc user
    When The user enters incorrect values for ideal weight, height <height> and gender <gender>
    Then The system raises an exception
   
   	Examples: 
      | height | gender |
      | 80     | "m"    |
      | 300    | "w"    |
      | 160    | "v"    |
      | 175    | "f"    |
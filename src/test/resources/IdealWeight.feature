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
    Given Valid parameters for height and gender
    When The user enters their <height> and <gender>
    Then The system returns the <value> of the ideal weight

    Examples: 
      | height | gender | value |
      | 170    | "m"    | 65    |
      | 190    | "m"    | 80    |
      | 160    | "w"    | 56    |
      | 175    | "w"    | 65    |

    
  @tag2
  Scenario Outline: The parameters for calculating ideal weight are incorrect.
    Given Incorrect parameters for height and gender
    When The user enters their <height> and <gender>
    Then The system returns an error message with the incorrect height or gender
   
   	Examples: 
      | height | gender |
      | 80     | "m"    |
      | 300    | "w"    |
      | 160    | "v"    |
      | 175    | "f"    |
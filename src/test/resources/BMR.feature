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
Feature: Calculating a person's basal metabolic rate.
    As a HealthCalc user I want to calculate my basal metabolic rate So that planning my diet with the right amount of calories
  @tag1
  Scenario Outline: The parameters for calculating the basal metabolic rate are valid.
    Given Valid parameters for height, gender, weight and age
    When The user enters their <height>, <gender>, <weight> and <age>
    Then The system returns the value for the basal metabolic rate

    Examples: 
      | height | gender | weight | age | value  |
      | 170    | "m"    | 80     | 30  | 1717.5 |
      | 190    | "m"    | 90     | 50  | 1842.5 |
      | 160    | "w"    | 55     | 25  | 1264   |
      | 170    | "w"    | 70     | 40  | 1401.5 |

    
  @tag2
  Scenario Outline: The parameters for calculating the basal metabolic rate are incorrect.
    Given Incorrect parameters for height, gender, weight and age
    When The user enters their <height>, <gender>, <weight> and <age>
    Then The system returns an error message with the parameters that are incorrect.
   
   	Examples: 
      | height | gender | weight | age |
      | 300    | "m"    | 80     | 30  |
      | 190    | "f"    | 90     | 50  |
      | 160    | "w"    | -10    | 25  |
      | 170    | "w"    | 70     | 200 |
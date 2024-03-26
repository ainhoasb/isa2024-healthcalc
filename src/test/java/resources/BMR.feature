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
    Given A HealthCalc user
    When The user enters valid values for weight <weight>, height <height>, gender <gender> and age <age>
    Then The system returns the value <value>

    Examples: 
      | weight | height | gender | age | value  |
      | 80.0   | 170    | "m"    | 30  | 1717.5 |
      | 90.0   | 190    | "m"    | 50  | 1842.5 |
      | 55.0   | 160    | "w"    | 25  | 1264.0 |
      | 70.0   | 170    | "w"    | 40  | 1401.5 |

    
  @tag2
  Scenario Outline: The parameters for calculating the basal metabolic rate are incorrect.
    Given A HealthCalc user
    When The user enters incorrect values for weight <weight>, height <height>, gender <gender> and age <age>
    Then The system raises an exception
   
   	Examples: 
      | height | gender | weight | age |
      | 300    | "m"    | 80     | 30  |
      | 190    | "f"    | 90     | 50  |
      | 160    | "w"    | -10    | 25  |
      | 170    | "w"    | 70     | 200 |
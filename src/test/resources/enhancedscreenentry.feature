#Author: your.email@your.domain.com
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
Feature: Administrative edits on enhanced search

  @tagUpdateEnhancedSearh
  Scenario: As an Administrator user, the search screen should have different fields enabled/disabled

    Given I am an Administor in the Search Sysem
    When I am on the Search page
    Then I should see Effective Date editable
    And Last Updated uneditable

   @tagUpdateEnhancedSubmit 
  Scenario: After an Admin changes the Search policy, a confirmation box is presented

    Given I am an Administor in the Search Sysem
    When I am on the Search page
    And I submit
    Then I should see a confirmation box


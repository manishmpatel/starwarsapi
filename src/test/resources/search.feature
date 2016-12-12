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
Feature: Search for Star Wars Characters
  Searching the Star Wars People database with with full or incomplete names
  should result in returing one or more characters that match.

  @tagSearchForLuke
  Scenario: Search for Luke

    Given I navigate to the Search page
    When I type 'Luke' and submit
    Then the rusults should come back with all of Luke Skywalker infomation

#Author: Reggy Williams
@RegressionTest
Feature: Web Objects Under Test
  I want to able to interact with all the elements on the sample application

	Background: The application under test
		Given I am on the application under test
		
  Scenario: Interaction with the TextInput textfield
    When I type in the TextInput textfield
    Then I can retrieve the contents typed into the TextInput textfield

	Scenario: Interaction with the Password textfield
    When I type in the Password textfield
    Then I can retrieve the contents typed into the Password textfield
    
  Scenario: Interaction with the TextArea section
    When I type in the TextArea section
    Then I can retrieve the contents typed into the TextArea section
    
  Scenario: Interaction with the DisabledInput textfield
    When I view the DisabledInput textfield
    Then The DisabledInput textfield is disabled
    And I cannot retrieve the contents of the textfield
    
  Scenario: Interaction with the ReadOnly textfield
    When I view the ReadOnly textfield
    Then The ReadOnly textfield is disabled
    And I can retrieve the contents of the textfield
    
  Scenario: Interaction with the Dropdown list
  	When I select an item from the dropdown list
  	Then The item is displayed as selected
  
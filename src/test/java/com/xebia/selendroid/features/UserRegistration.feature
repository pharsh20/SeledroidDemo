Feature: New user registration

  Scenario Outline: Valid user registration
    Given Application is open
    And I navigate to new user registration screen
    When I enter all valid data "<firstname>","<password>","<email>","<name>"
    And accept terms and register
    Then User should be register

    Examples: 
      | firstName | password | email        | name  |
      | Test      | First    | 123@test.com | Harsh |

	Scenario: Verify Home Page
		Given Application is open
		When I click display text
		Then I see text
		And I click display toast
		Then I see toast
		And I click display pop up
		Then I see and dsimiss pop up
		 
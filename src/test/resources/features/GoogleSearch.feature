Feature: Searching in Google
	
	Scenario: Search by typing
			Given I navigated to google.com
			When I type something in the search box
			And I click on the search button
			Then I can see the results of my search
			And I want to see the number of search results
			
	@smoke
	Scenario: Search by voice
			Given I navigated to google.com
			When I say what I want to search for
			Then I can see the results of my search
			And I want to see the number of search results
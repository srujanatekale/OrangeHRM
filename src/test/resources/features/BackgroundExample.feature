@background
Feature: Background keyword example
	
	Background:
		Given Precondition1
		And Precondition2
	
	Scenario: Example1
		When Test Step1
		And Test Step2
		Then Validation Step1
		And Validation Step2
		
	Scenario: Example2
		When Test Step3
		And Test Step4
		Then Validation Step3
		And Validation Step4
		
	
#-----Order of Execution -----
# Hooks  --> @Before
# Background Steps
# Scenario: Example1
# Hooks --> @After
# ----------------------------
# Hooks  --> @Before
# Background Steps
# Scenario: Example2
# Hooks --> @After

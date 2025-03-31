package com.neotech.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutlineSteps {
	@When("I Login with {string} and {string}")
	public void i_login_with_and(String username, String password) {
		System.out.println("Login with " + username + " and " + password);
	}

	@When("Click on the Login button")
	public void click_on_the_login_button() {
		System.out.println("Clicking the login button...");
	}

	@Then("Validate that {string} is displayed")
	public void validate_that_is_displayed(String username) {
		System.out.println("Validate that the " + username + " is displayed");
	}

	@Then("Print Bye {string} on screen")
	public void print_bye_on_screen(String fullName) {
		System.out.println("Bye " + fullName);
	}
}

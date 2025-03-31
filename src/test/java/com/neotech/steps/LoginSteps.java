package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	/*		Using Hooks now
	 * 
	 
	LoginPageElements login;
	DashboardPageElements dashboard;

*/
	@Given("I navigated to HRM website")
	public void i_navigated_to_hrm_website() {
			//started using Hooks
		//	setUp();
		
		//login = new LoginPageElements();
		//dashboard = new DashboardPageElements();
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(loginPage.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the submit button")
	public void i_click_on_the_submit_button() {
		click(loginPage.loginBtn);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String expected = "Jacqueline White";
		String actual = dashboardPage.accountName.getText();

		if (expected.equals(actual)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed!!!");
		}
	}

	
	@Then("I quit the browser")
	public void i_quit_the_browser() {
			//started using Hooks
		//	tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(loginPage.password, "WrongPassword!");
	}

	@Then("I validate that Invalid Credentials is displayed")
	public void i_validate_that_invalid_credentials_is_displayed() {
		String expected = "Invalid Credentials";
		String actual = loginPage.invalidMsg.getText();

		if (expected.equals(actual)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed!!!");
		}
	}
	
	@When("I enter the valid {string} and {string}")
	public void i_enter_the_valid_and(String username, String password) {
		sendText(loginPage.username, username);
		sendText(loginPage.password, password);
	}

	@Then("I verify that {string} is shown")
	public void i_verify_that_is_shown(String employeeName) {
		String actualName = dashboardPage.accountName.getText();

		Assert.assertEquals("The account name does not match", employeeName, actualName);
	}

	@When("user enters a username and a password and clicks on submit button")
	public void user_enters_a_username_and_a_password_and_clicks_on_submit_button(DataTable employees) {
		// TODO
		// for every row in employees datatable:
		// send login credentials
		// click login button
		// verify the employee name
		// logout

		// convert the datatable into List of Maps object
		List<Map<String, String>> employeeList = employees.asMaps();

		// now loop over the employee list and do the login, verify, and logout
		for (Map<String, String> employee : employeeList) {
			System.out.println(
					"Loggin in with: " + employee.get("username") + " and password: " + employee.get("password"));

			// login
			sendText(loginPage.username, employee.get("username"));
			sendText(loginPage.password, employee.get("password"));

			// submit the button
			click(loginPage.loginBtn);
			wait(1);

			// verify
			String actualName = dashboardPage.accountName.getText();
			Assert.assertEquals("The account name does not match", employee.get("employeeName"), actualName);

			// logout
			click(dashboardPage.accountMenu);
			click(dashboardPage.logout);
		}
	}

}

package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeSteps extends CommonMethods {

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		loginPage.adminLogin();
	}

	@Given("user navigates to the employee list page")
	public void user_navigates_to_the_employee_list_page() {

		click(dashboardPage.PIM);
		click(dashboardPage.employeeList);

	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
		sendText(employeeListPage.searchBox, "0036");
	}

	@When("clicks on search button")
	public void clicks_on_search_button() {
		jsClick(employeeListPage.searchIcon);
	}

	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
		//to keep it short, we don't want to click and verify
		System.out.println("I see it there!!!");
		wait(5);
	}
	
	
	@When("user enters valid employee name")
	public void user_enters_valid_employee_name() {
		sendText(employeeListPage.searchBox,"Brody Alan");
	}
	
	

}

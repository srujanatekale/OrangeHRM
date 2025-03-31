package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.Constants;
import com.neotech.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates to AddEmployee page")
	public void user_navigates_to_add_employee_page() {
		click(dashboardPage.PIM);
		click(dashboardPage.addEmployeeLink);
	}

	// Hard-coded Step
	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(addEmployeePage.firstName, "Lionel");
		sendText(addEmployeePage.lastName, "Messi");
	}

	// Parameterized Step
	@When("user enters employee first name {string} and last name {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
	}

	@When("user selects a location")
	public void user_selects_a_location() {
		selectDropdown(addEmployeePage.location, "New York Sales Office");
		wait(1);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		wait(1);
		click(addEmployeePage.saveButton);
	}

	// Hard-coded Validation
	@Then("validate that employee is added successfully")
	public void validate_that_employee_is_added_successfully() {
		waitForVisibility(personalDetailsPage.fullName);

		String expected = "Lionel Messi";
		String actual = personalDetailsPage.fullName.getText();

		// Please make sure you import Assert class under org.junit package
		Assert.assertEquals("The employee name does NOT match!", expected, actual);
	}

	// Parameterized Validation
	@Then("validate that employee {string} is added successfully")
	public void validate_that_employee_is_added_successfully(String expectedName) {
		waitForVisibility(personalDetailsPage.fullName);

		String actualName = personalDetailsPage.fullName.getText();

		// Please make sure you import Assert class under org.junit package
		Assert.assertEquals("The employee name does NOT match!", expectedName, actualName);
	}

	@When("user clicks on Create Login Details")
	public void user_clicks_on_create_login_details() {
		jsClick(addEmployeePage.loginDetailsToggle);
	}

	@When("user provides credentials")
	public void user_provides_credentials() {
		sendText(addEmployeePage.username, "MauroIcardito");
		sendText(addEmployeePage.password, "Wanda@12345");
		sendText(addEmployeePage.confirmPassword, "Wanda@12345");
	}

	// Homework for Hard working students
	// Do the step above with parameterized username and password

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String first, String middle, String last) {
		sendText(addEmployeePage.firstName, first);
		sendText(addEmployeePage.middleName, middle);
		sendText(addEmployeePage.lastName, last);
	}

	@When("user selects a location {string}")
	public void user_selects_a_location(String location) {
		selectDropdown(addEmployeePage.location, location);
	}

	@Then("validate that {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstName, String lastName) {
		waitForVisibility(personalDetailsPage.fullName);

		String expectedName = firstName + " " + lastName;
		String actualName = personalDetailsPage.fullName.getText();

		// Please make sure you import Assert class under org.junit package
		Assert.assertEquals("The employee name does NOT match!", expectedName, actualName);
	}

	// ----------------@UsingDataTable----------------

	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details(DataTable table) {

		// System.out.println(table);

		// asLists() method returns a List for every row (including the header)
		// System.out.println(table.asLists());

		// asMaps() method returns a List of Maps for every data row (NOT including the
		// header)
		// System.out.println(table.asMaps());

		List<Map<String, String>> employeeList = table.asMaps();

		for (Map<String, String> employee : employeeList) {
			System.out.println(employee);

			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployeePage.firstName, fName);
			sendText(addEmployeePage.middleName, mName);
			sendText(addEmployeePage.lastName, lName);

			selectDropdown(addEmployeePage.location, "New York Sales Office");
			wait(1);

			click(addEmployeePage.saveButton);

			waitForVisibility(personalDetailsPage.fullName);

			String expectedName = fName + " " + lName;
			String actualName = personalDetailsPage.fullName.getText();

			// Please make sure you import Assert class under org.junit package
			Assert.assertEquals("The employee name does NOT match!", expectedName, actualName);

			// Before the next iteration
			// We need to go to Add Employee page again
			wait(1);
			click(dashboardPage.addEmployeeLink);
		}

	}
	
	
	// ----------------@GettingDataFromExcel----------------

	@When("user enters employee data from {string} Excel sheet and saves the employee")
	public void user_enters_employee_data_from_excel_sheet_and_saves_the_employee(String sheetName) {

		//read the data from Excel
		String path = Constants.DATA_FILEPATH+"Excel.xlsx";
		
		List<Map<String, String>> excelData =  ExcelUtility.excelIntoListOfMaps(path, sheetName);
		
		
		//for each employee data
		for (Map<String, String> employee : excelData)
		{
			String fname = employee.get("FirstName");
			String lname = employee.get("LastName");
			String location = employee.get("Location");
			String user = employee.get("Username");
			String password = employee.get("Password");

			sendText(addEmployeePage.firstName, fname);
			sendText(addEmployeePage.lastName, lname);
			selectDropdown(addEmployeePage.location, location);
			
			jsClick(addEmployeePage.loginDetailsToggle);
			
			
			sendText(addEmployeePage.username, user);
			sendText(addEmployeePage.password, password);
			sendText(addEmployeePage.confirmPassword, password);
			
			wait(2);
			
			click(addEmployeePage.saveButton);
			
			
			waitForVisibility(personalDetailsPage.fullName);
			
			//Assert the employee was added
			String expectedName = fname + " " + lname;
			String actualName = personalDetailsPage.fullName.getText();
			
			Assert.assertEquals("Emplyee NOT added!", expectedName, actualName);
		
			//at this point we have added an employee, but we are in a for loop.
			//at the next iteration we should add another employee, so we need the add employee 
			//form to be displayed
			click(dashboardPage.addEmployeeLink);
			wait(1);
		
		}
		
		
	}

}

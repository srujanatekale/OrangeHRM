package com.neotech.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {

	@When("I login to the HRM website")
	public void i_login_to_the_hrm_website() {
		System.out.println("I login here...");
	}

	@When("I want to add Employees")
	public void i_want_to_add_employees(DataTable employees) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		// List of maps
//		Map<String, String> map1 = new HashMap<>();
//		map1.put("FirstName", "Paul");
//		map1.put("MiddleName", "M");
//		map1.put("LastName", "Desany");
//
//		Map<String, String> map2 = new HashMap<>();
//		map2.put("FirstName", "Umut");
//		map2.put("MiddleName", "");
//		map2.put("LastName", "Degismen");
//
//		List<Map<String, String>> list = new ArrayList<>();
//		list.add(map1);
//		list.add(map2);

		List<Map<String, String>> employeesList = employees.asMaps();
		for (Map<String, String> employee : employeesList) {
			System.out.println(employee);
			System.out.println("First name: " + employee.get("FirstName"));
			System.out.println("Middle name: " + employee.get("MiddleName"));
			System.out.println("Last name: " + employee.get("LastName"));
		}
	}

	@Then("I validate employee is added")
	public void i_validate_employee_is_added() {
		System.out.println("Validate the employee is added");
	}
}

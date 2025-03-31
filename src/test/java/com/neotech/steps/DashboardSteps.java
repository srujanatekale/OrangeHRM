package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {

	@Then("I want to validate the items on the menu")
	public void i_want_to_validate_the_items_on_the_menu(DataTable dataTable) {
		List<String> expectedList = dataTable.asList();
		List<String> actualList = new ArrayList<>();

		// click on the More menu item to collapse it
		click(dashboardPage.moreMenuItem);
		wait(3);

		for (WebElement el : dashboardPage.menuList) {
			actualList.add(el.getText());
		}

		System.out.println("expected list: " + expectedList);
		System.out.println("actual list: " + actualList);

		// verify that actual and expected are equal
		Assert.assertEquals(expectedList, actualList);
	}
}

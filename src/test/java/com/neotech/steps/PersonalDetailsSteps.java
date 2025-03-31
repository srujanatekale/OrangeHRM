package com.neotech.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class PersonalDetailsSteps extends CommonMethods{

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String drivingLicense, String expirationDate, 
			String smoker, String gender, String nationality) {

		//lets make sure we wait for the elements to show up
		waitForVisibility(personalDetailsPage.firstName);
		
		//send driving license number
		sendText(personalDetailsPage.drivingLicense, drivingLicense);
		
		//click on the smoker box if the employee is a smoker
		if (smoker.equals("Yes"))
		{
			click(personalDetailsPage.smokerBox);
		}
		
		
		//select gender 
		
		//1st way: select dropdown
//		selectDropdown(personalDetailsPage.genderDD, gender);
		
		//2nd way: click and select: 
//		click(personalDetailsPage.genderInput);
//		click(driver.findElement(By.xpath("//span[text()='"+gender+"']")));
		
		
		//3rd way: 
		click(personalDetailsPage.genderInput);
		List<WebElement> genderOptions = personalDetailsPage.genderOptions;
		clickOnElement(genderOptions, gender);
		
		//click on nationality
		click(personalDetailsPage.nationInput);
		clickOnElement(personalDetailsPage.nationOptions, nationality);
		
		
		
		//set the expiration date -- the format does not match 
	//	sendText(personalDetailsPage.licExpYearInput, expirationDate);
		
		//wait(5);
		
		
		//our incoming format: 2023-05-10
		//I want year, month, day separate
		String[] dateParts =	expirationDate.split("-");
		//dateParts = ["2023", "05", "10"]
		
		click(personalDetailsPage.licExpInput);
		
		//click on the year
		click(personalDetailsPage.licExpYearInput);
		clickOnElement(personalDetailsPage.licExpYearOptions, dateParts[0]);
		
		//click on the month
		click(personalDetailsPage.licExpMonthInput);
		int month = Integer.parseInt(dateParts[1]); //from 05 as a String ---> int 5
		click(personalDetailsPage.licExpMonthOptions.get(month-1));
		
		
		//select the day
		int day = Integer.parseInt(dateParts[2]);
		selectCalendarDate(personalDetailsPage.licExpDays, day + "");
		
		
		wait(5);
		
		
		
		
		
		
		
	}
	

	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {
	
		jsClick(personalDetailsPage.detailsSaveBtn);
		
	}

}

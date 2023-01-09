package StepDefinitions;



import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstandFinal;
import pages.HolidaysListPage;
import pages.HomePage;
import utility.ExcelDataProvider;
//import utility.ReportSpark;

public class HolidayList extends FirstandFinal {
	
	HomePage HP= new HomePage(FirstandFinal.driver);
	HolidaysListPage HL= new HolidaysListPage(FirstandFinal.driver);
	ExcelDataProvider EDP=new ExcelDataProvider();
	
	@Given("User is on the EY LMS Page")
	public void user_is_on_the_ey_lms_page() {
		String methodName="user_is_on_the_ey_lms_page";
		
		HP.setUp();
		if (HP.launchBrowser()) {
			HP.sparkReportPass(methodName);
		}else {
			HP.sparkReportFailure(methodName);
		}
		
			
	}
	
	@When("User Navigates to the Holiday List Page")
	public void user_navigates_to_the_holiday_list_page() {
	 
		String methodName="user_navigates_to_the_holiday_list_page";
		
		try {
	    if (HP.clickButton("HolidaysList")) {
	    	HL.titleValidation();
		    HP.sparkReportPass(methodName);
	    }else {
	    	HP.sparkReportFailure(methodName);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Validate the public holiday count is  equal to or greater than “{int}”")
	public void validate_the_public_holiday_count_is_equal_to_or_greater_than(int int1)  {
		String methodName="validate_the_public_holiday_count_is_equal_to_or_greater_than";
		try {
		HL.holidayvalues(int1);
		HP.sparkReportPass(methodName);
		}catch (Exception e) {
			 HP.sparkReportFailure(methodName);
		}
	}
	

	@Then("User is able to split the holiday details as per Holiday Type and print it as a report")
	public void user_is_able_to_split_the_holiday_details_as_per_holiday_type_and_print_it_as_a_report() {
		String methodName="user_is_able_to_split_the_holiday_details_as_per_holiday_type_and_print_it_as_a_report";
		try {
			HL.printPublicHolidayList();
			HL.printOptionalHolidayList();
		 	HP.sparkReportPass(methodName);
		 	HP.helper();
		}catch (Exception e) {
			 HP.sparkReportFailure(methodName);
		}
	}
	
	@Then("Validation message is printed")
	public void validation_message_is_printed() {
		String methodName="validation_message_is_printed";
		try {
			System.out.println("End Of LMS Capstone Project");
	   		HP.sparkReportPass(methodName);
		}catch (Exception e) {
			HP.sparkReportFailure(methodName);
	}
	}

}


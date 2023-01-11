package StepDefinitions;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstandFinal;
import pages.HolidaysListPage;
import pages.HomePage;
import utility.ExcelDataProvider;



public class HolidayList extends FirstandFinal {
	
	HomePage HP= new HomePage(FirstandFinal.driver);
	HolidaysListPage HL= new HolidaysListPage(FirstandFinal.driver);
	ExcelDataProvider EDP=new ExcelDataProvider();
	
	@Test(priority=1)
	@Given("User is on the EY LMS Page")
	public void user_is_on_the_ey_lms_page() {
		String methodName="user_is_on_the_ey_lms_page";
		try {
		HP.setUp();
		if (HP.launchBrowser()) {
			HP.sparkReportPass(methodName);
		}else {
			HP.sparkReportFailure(methodName);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	@Test(priority=2)
	@When("User Navigates to the Holiday List Page")
	public void user_navigates_to_the_holiday_list_page() {
	 
		String methodName="user_navigates_to_the_holiday_list_page";
		try {
			HP.clickButton("HolidaysList");
		
	    if (HL.titleValidation()) {
	    	HP.reportInfo(methodName);
		    
	    }else {
	    	HP.sparkReportFailure(methodName);
		}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	@Test(priority=3)
	@Parameters("9")
	@Then("Validate the public holiday count is  equal to or greater than “{int}”")
	public void validate_the_public_holiday_count_is_equal_to_or_greater_than(int int1)  {
		
		String methodName="validate_the_public_holiday_count_is_equal_to_or_greater_than";
		
		try {
			if (HL.validateNoOfHolidays(int1)) {
				System.out.println(int1);
				HP.sparkReportPass(methodName);
				messageCounter(int1);
			
			}else {
				
				HP.sparkReportFailure(methodName);
				
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	@Test(priority=4)
	@Then("User is able to split the holiday details as per Holiday Type and print it as a report")
	public void user_is_able_to_split_the_holiday_details_as_per_holiday_type_and_print_it_as_a_report() {
		String methodName="user_is_able_to_split_the_holiday_details_as_per_holiday_type_and_print_it_as_a_report";
		try {
			HL.printPublicHolidayList();
			HL.printOptionalHolidayList();
		 	HP.reportInfo(methodName);
		 	HL.publicholiday();
		 	HL.optionalholiday();
		 	//HP.helper(data, methodName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}


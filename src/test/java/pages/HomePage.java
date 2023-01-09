package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OverrideFunctions.WebElementActions;
import utility.ExcelDataProvider;

public class HomePage extends FirstandFinal{
	
	ExcelDataProvider EDP=new ExcelDataProvider();
	WebElementActions elements=new WebElementActions(driver);
	public HomePage(WebDriver driver) {
		FirstandFinal.driver=driver;
		
	}
	

	
	  By HolidayImage=(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[1]/a/img")); 
	  By ChartImage=(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/a/img"));
	  By SnapShotImage=(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[3]/a/img"));
	  By gTEimage=(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[4]")); 
	  By ConflictImage=(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[5]/a/img"));
	  By HomeLink=(By.xpath("//*[@id=\"navbar-main\"]/ul/li[1]/a"));
	 
	
			//Method to send the button name and click 
			public boolean clickButton(String buttonToClick) throws InterruptedException {
				
				
				if (buttonToClick.equalsIgnoreCase("Home")) {
				elements.clickButton( HomeLink);
				}
				else if (buttonToClick.equalsIgnoreCase("HolidaysList")) {
					elements.clickButton( HolidayImage);
				}
				else if (buttonToClick.equalsIgnoreCase("Chart")) {
					elements.clickButton( ChartImage);
				}
				else if (buttonToClick.equalsIgnoreCase("Snapshot")) {
					elements.clickButton( SnapShotImage);
				}
				else if (buttonToClick.equalsIgnoreCase("gTE")) {
					elements.clickButton( gTEimage);
				}
				else if (buttonToClick.equalsIgnoreCase("Conflict")) {
					elements.clickButton( ConflictImage);
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return true;
			 }
			
			}
		



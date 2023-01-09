package pages;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import OverrideFunctions.WebElements;
import utility.ExcelDataProvider;

public class HomePage2 extends FirstandFinal{
	
	ExcelDataProvider EDP=new ExcelDataProvider();
	WebElements elements=new WebElements(driver);
	public HomePage2(WebDriver driver) {
		FirstandFinal.driver=driver;
		
	}
	
	Array arrlistElementName,arrlistElementValue;
	
	int rowcount=EDP.getRowCount("HomePage");
	//arrlistElementName=EDP.getRowCount
	for (int i=0;i<rowcount;i++) {
		arrlistElementName(i)=EDP.getStringData("HomePage", i, 0);
		arrlistElementValue(i)=EDP.getStringData("HomePage", i, 1);
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
				elements.clickButton(buttonToClick, HomeLink);
				}
				else if (buttonToClick.equalsIgnoreCase("HolidaysList")) {
					elements.clickButton(buttonToClick, HolidayImage);
					//System.out.println("xpath for holidayimage"+HolidayImage);
				}
				else if (buttonToClick.equalsIgnoreCase("Chart")) {
					elements.clickButton(buttonToClick, ChartImage);
				}
				else if (buttonToClick.equalsIgnoreCase("Snapshot")) {
					elements.clickButton(buttonToClick, SnapShotImage);
				}
				else if (buttonToClick.equalsIgnoreCase("gTE")) {
					elements.clickButton(buttonToClick, gTEimage);
				}
				else if (buttonToClick.equalsIgnoreCase("Conflict")) {
					elements.clickButton(buttonToClick, ConflictImage);
				}
				Thread.sleep(10000);
				return true;
			 }
			
			}
		



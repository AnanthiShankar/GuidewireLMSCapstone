package pages;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reusablefunctions.HolidayDetails;
import reusablefunctions.WebElementActions;

public class HolidaysListPage extends FirstandFinal
{
	WebElementActions elements=new WebElementActions(driver);
	int hSize=0;
	int pSize=0;
	private static int publicrowcount;
	private static int publicColcount;
	private static int optrowcount;
	private static int optColcount;
	public static int columnCount;
	public static int rowcount;
	
	
	static ArrayList<String> arrCellValues = new ArrayList<String>();
	
	
	HolidayDetails HD=new HolidayDetails(null, null, null, null, hSize);
	HolidayDetails PHD=new HolidayDetails(null, null, null, null, hSize);
	HolidayDetails OHD=new HolidayDetails(null, null, null, null, hSize);
	
	public HolidaysListPage(WebDriver driver) {
		FirstandFinal.driver=driver;
	}
	
	
	By Table=(By.xpath("//table[@class='table table-condensed table-hover']"));
	By Rowcount=(By.tagName("tr"));
	By Column=(By.tagName("td"));
	By pgtitle=By.xpath("//h4[contains(text(),'Office Holiday list')]");
	
	public boolean titleValidation() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));   
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Office Holiday list')]")));
		WebElement Actual=driver.findElement(pgtitle);
		
		 if (Actual.toString().contains("Office Holiday list")){
			 return true;
		}
		 else {
			   return false;
		  }
			 
	}
	public boolean validateNoOfHolidays(int size) throws InterruptedException {
		
		rowcount=elements.tablerowCount("HolidayList", Rowcount).size();
		
		for (int i=0;i<=rowcount-1;i++) {
			List<WebElement> cols=elements.tableValues("HolidayList", Rowcount).get(i).findElements(Column);
			columnCount=cols.size();
			for (int j=0;j<columnCount;j++) {
				String Cellvalue=cols.get(j).getText();
				arrCellValues.add(Cellvalue);
				}
			}
			for(int l=0;l<arrCellValues.size();l++) { 
				  if(arrCellValues.get(l).equalsIgnoreCase("Public Holiday"))
				  { 
					  pSize=pSize+1; 
					  
				  }
			}
			
			PHD.size=pSize;
		if (pSize>=size) {
			return true;
			}else {
			return false;
			}	
		}
		
	
			
	public void printPublicHolidayList()
	
	{
		Formatter fmt = new Formatter();  
		fmt.format("%-25s %-20s %-60s %-15s\n", "Holiday Date:", "Day", "Description","Holiday Type");  
		System.out.println("Public Holiday List:");
		System.out.println("<---------------------------------------------------------------------------------------------------------------------------");
		System.out.println(fmt);
		
		for(int k=0;k<arrCellValues.size();k=k+4)
		{
			
			HD.HolidayDate=arrCellValues.get(k);
			
			HD.Day=arrCellValues.get(k+1);
			
			HD.Description=arrCellValues.get(k+2);
			
			HD.Type=arrCellValues.get(k+3);
			
			try {
		         FileOutputStream fileOut =
		         new FileOutputStream("src/test/resources/TestData/Holiday.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(HD);
		         out.close();
		         fileOut.close();
		         
		      	} catch (IOException e)
				{
		         e.printStackTrace();
				}
		
			if ((HD.Type).equalsIgnoreCase("Public Holiday")){
			
		      try {
		         FileInputStream fileIn = new FileInputStream("src/test/resources/TestData/Holiday.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         PHD = (HolidayDetails) in.readObject();
		         in.close();
		         fileIn.close();
		      	} catch (IOException e)
		      	{
		         e.printStackTrace();
		        // return;
		      	} catch (ClassNotFoundException c) 
		      	{
		         System.out.println("Holiday class not found");
		         c.printStackTrace();
		        // return;
		      	}
		      System.out.println("<---------------------------------------------------------------------------------------------------------------------------");
		      System.out.format("%-25s %-20s %-60s %-15s\n", PHD.HolidayDate,PHD.Day,PHD.Description,PHD.Type);
		   
			}
		}
		  System.out.println();
	      System.out.println();
	      System.out.println();
	    
	}
		
	
	public void printOptionalHolidayList(){	
		
			Formatter fmt = new Formatter();  
			fmt.format("%-25s %-20s %-60s %-15s\n", "Holiday Date:", "Day", "Description","Holiday Type");  
			System.out.println("Optional Holiday List:");
			System.out.println("<---------------------------------------------------------------------------------------------------------------------------");
			System.out.println(fmt);
			for(int k=0;k<arrCellValues.size();k=k+4)
			{
				
				HD.HolidayDate=arrCellValues.get(k);
				
				HD.Day=arrCellValues.get(k+1);
				
				HD.Description=arrCellValues.get(k+2);
				
				HD.Type=arrCellValues.get(k+3);
				
				
				try {
			         FileOutputStream fileOut =
			         new FileOutputStream("src/test/resources/TestData/OptionalHoliday.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(HD);
			         out.close();
			         fileOut.close();
			        
			      	} catch (IOException e)
					{
			         e.printStackTrace();
					}
			
				if ((HD.Type).equalsIgnoreCase("Optional Holiday")){
				
			      try {
			         FileInputStream fileIn = new FileInputStream("src/test/resources/TestData/OptionalHoliday.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         OHD = (HolidayDetails) in.readObject();
			         in.close();
			         fileIn.close();
			      	} catch (IOException e)
			      	{
			         e.printStackTrace();
			         return;
			      	} catch (ClassNotFoundException c) 
			      	{
			         System.out.println("Holiday class not found");
			         c.printStackTrace();
			         return;
			      	}
			      
			    
			      System.out.println("<---------------------------------------------------------------------------------------------------------------------------");
			      System.out.format("%-25s %-20s %-60s %-15s\n", OHD.HolidayDate,OHD.Day,OHD.Description,OHD.Type);
			    		
				}
			}
	}
		
	public void publicholiday(){
		int l=0,m=0;
		int size=Collections.frequency(arrCellValues, "Public Holiday");
		String [][] publicHoliday=new String[size][4];
		String[] Array = arrCellValues.toArray(new String[size]);
		
		for(int k=0;k<arrCellValues.size();k=k+1)
		{
			if (Array[k].equalsIgnoreCase("Public Holiday")){
				publicHoliday[l][m]=Array[k-3];
				
				publicHoliday[l][m+1]=Array[k-2];
				
				publicHoliday[l][m+2]=Array[k-1];
				
				publicHoliday[l][m+3]=Array[k];
				
				l=l+1;
				
			}
		}
		helper(publicHoliday,"Public Holiday List");
		
	}
	
	public void optionalholiday(){
		int a=0,b=0;
		int size=Collections.frequency(arrCellValues, "Optional Holiday");
		String [][] optionalHoliday=new String[size][4];
		
		String[] Array = arrCellValues.toArray(new String[size]);
		for(int k=0;k<arrCellValues.size();k=k+1)
		{
			if (Array[k].equalsIgnoreCase("Optional Holiday")){
			optionalHoliday[a][b]=Array[k-3];
			
			optionalHoliday[a][b+1]=Array[k-2];
			
			optionalHoliday[a][b+2]=Array[k-1];
			
			optionalHoliday[a][b+3]=Array[k];
			a=a+1;
			
			}
		}
		helper(optionalHoliday,"Optional Holiday List");
		
		
	}
}	

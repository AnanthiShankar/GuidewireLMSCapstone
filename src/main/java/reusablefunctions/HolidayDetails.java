package reusablefunctions;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HolidayDetails implements Serializable {
	   public String HolidayDate;
	   public String Day;
	   public String Description;
	   public String Type;
	   public int size;
	   
	   public HolidayDetails(String HolidayDate, String Day, String Description,String Type,int size) {    
		   this.HolidayDate=HolidayDate;    
		   this.Day=Day;    
		   this.Description=Description;   
		   this.Type=Type;
		  
		  }   
		
}

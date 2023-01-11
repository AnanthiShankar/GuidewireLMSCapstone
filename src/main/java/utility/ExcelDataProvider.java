package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src=new File("src/test/resources/TestData/TestDataSheet.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			
			 wb=new XSSFWorkbook(fis);
			
		}catch(Exception e) {
			System.out.println("Unable to read the file"+e.getMessage());
		}
	}
	public String getStringData(String sheetName,int rowNo,int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
		
	}
	public String getStringData(int sheetindex,int rowNo,int colNo) {
		return wb.getSheetAt(sheetindex).getRow(rowNo).getCell(colNo).getStringCellValue();
		
	}
	public int getNumericData(String sheetName,int rowNo,int colNo) {
		return (int) wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
		
	}
	public int getNumericData(int sheetindex,int rowNo,int colNo) {
		return (int) wb.getSheetAt(sheetindex).getRow(rowNo).getCell(colNo).getNumericCellValue();
		
	}
	public int getRowCount(int sheetIndex) {
		int lastRow= wb.getSheetAt(sheetIndex).getLastRowNum();
		return lastRow;
		
	}
	public int getRowCount(String sheetName) {
		int lastRow= wb.getSheet(sheetName).getLastRowNum();
		return lastRow;
		
	}
	public int getRowNo(String sheetName,String userId) {
		int rowno=-1;
		String value="";
		for (int i=0;i<=getRowCount(sheetName);i++) {
			value=wb.getSheet(sheetName).getRow(i).getCell(0).getStringCellValue();
			if (value.equals(userId)){
				rowno= i;
				break;
			}
		}
		
		return rowno;
		
			
	}
	/*
	 * public Object[][] elementNameset(String sheetName,String colName){ int
	 * rowcount= wb.getSheet(sheetName).getLastRowNum();
	 * 
	 * for (int i=0;i<rowcount;i++) { for (int j=0;j<rowcount;j++) Object[i][j]
	 * arrayList=wb.getSheet(sheetName).getTables()(i).getCell(j).getStringCellValue
	 * (); } Object[][] arrayList= return elementNameset(); array[]
	 * 
	 * }
	 */
}

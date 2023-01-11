package overridefunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.FirstandFinal;

public class WebElementActions extends FirstandFinal {
	public WebElementActions(WebDriver driver) {
		FirstandFinal.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	//WebDriver driver;
	public String tableValues;
	
	public void selectListItem(String valueToselect,By location){
		
		driver.findElement(location).sendKeys(valueToselect);
		
		
	 }

	public void enterTextValue(String valueToEnter,By location) {
		
		driver.findElement(location).sendKeys(valueToEnter);
		
		
	 }
	public void clickButton(By location) {
		
		driver.findElement(location).click();		
		
	 }
public List<WebElement> tablerowCount(String tableName,By location) {
		
	List<WebElement> totalRowCount=driver.findElements(location);	
	
		return totalRowCount;
		
	 }
public List<WebElement> tablecolCount(String tableName,By location) {
	
	List<WebElement> cols = driver.findElements(location);
		return cols;
		
	 }

public List<WebElement> tableValues(String tableName,By location) {
	
	List<WebElement> allValues=driver.findElements(location);	
		return allValues;
		
	 }
}

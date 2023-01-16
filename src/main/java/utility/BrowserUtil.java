package utility;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxBinary;

public class BrowserUtil {
	//from selenium import webdriver
	//from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
	

	/*
	 * File pathToBinary = new
	 * File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); FirefoxBinary
	 * ffBinary = new FirefoxBinary(pathToBinary); FirefoxProfile firefoxProfile =
	 * new FirefoxProfile(); FirefoxDriver _driver = new
	 * FirefoxDriver(ffBinary,firefoxProfile);
	 */
	
	
		public static WebDriver initApplication(WebDriver driver,String browserName,String appUrl) throws InterruptedException {
			if (browserName.equalsIgnoreCase("Chrome")){
				
				System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
				driver=new ChromeDriver();
			}else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver","src/main/resources/drivers/msedgedriver.exe");
				driver=new EdgeDriver();
			}else if (browserName.equalsIgnoreCase("Firefox")){
				
						
				System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("This driver is not supported at this moment");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			driver.get(appUrl);
			return driver;
			
		}
		
		public static  void exitBrowser(WebDriver driver) {
			driver.quit();
			
		}
		
		
}

package utility;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxBinary;

public class BrowserUtil {
	
	
	
			
		public static void launchBrowser(WebDriver driver,String appUrl) {			
			//driver.get(appUrl);	
			System.out.println(appUrl);
			driver.get(appUrl);
		}
		
		public static  void exitBrowser(WebDriver driver) {
			driver.quit();
			
		}

		public static WebDriver driverManager(String browserName) {
			WebDriver driver = null;
			if (browserName.equalsIgnoreCase("Chrome")){
				
				System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				//WebDriver driver = new ChromeDriver();
				 options.addArguments("--headless");
				 driver = new ChromeDriver(options);
				
				
			}else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver","src/main/resources/drivers/msedgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				//WebDriver driver = new ChromeDriver();
				 options.addArguments("--headless");
				driver=new EdgeDriver(options);
			}else if (browserName.equalsIgnoreCase("Firefox")){				
						
				System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				//WebDriver driver = new ChromeDriver();
				 options.addArguments("--headless");
				driver=new FirefoxDriver(options);
			}
			else if (browserName.equalsIgnoreCase("IE")){				
			
			System.setProperty("webdriver.ie.driver","src/main/resources/drivers/iediagcmd.exe");
			driver=new InternetExplorerDriver();
			}
			else {
				System.out.println("This driver is not supported at this moment");
			}
						return driver;
		}
		
		
}

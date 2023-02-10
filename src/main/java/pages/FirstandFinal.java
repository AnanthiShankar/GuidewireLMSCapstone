package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import org.apache.logging.log4j.Logger;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class FirstandFinal {
	public static WebDriver driver;
	ConfigDataProvider CDP=new ConfigDataProvider();
	public static ExtentTest test;
	public static ExtentReports report;
	public ExtentReporter reporter;
	public ExtentHtmlReporter htmlreport;
	public  ExcelDataProvider EDP;
	public static Logger logs;
	public long threadid;
	public int counter;
	public String browserName;
	public FirstandFinal() {
		threadid=this.getThreadId();
		//return threadid;
	}
	public void setUp() throws InterruptedException {

			htmlreport=new ExtentHtmlReporter(new File("./Reports/PChtml"+getCurrentDateTime()+".html"));
			report=new ExtentReports();
			report.attachReporter(htmlreport);
			//browserName=xmlbrowser();
			if (browserName.isEmpty()) {
			driver=BrowserUtil.driverManager(CDP.getBrowser());
			}
			else {
				driver=BrowserUtil.driverManager(browserName);
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			driver.manage().window().maximize();
		}
		
	
	public void launchBrowsers() {
		try {			
			BrowserUtil.launchBrowser(driver, CDP.getUrl());
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	
	public void exitBrowser() {
		BrowserUtil.exitBrowser(driver);
		
	}
	public static String capturescreenshot(WebDriver driver) {
		
		String screenshotName = null;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		screenshotName="pic"+getCurrentDateTime()+".jpg";
		try {
			FileHandler.copy(src, new File("./Screenshots/"+screenshotName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return screenshotName;
	}
	public static String capturescreenshot() {
		
		String src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
		return src;
	}
	public static String getCurrentDateTime() {
		DateFormat dateFormat =new SimpleDateFormat("MM_DD_YYYY_HH_mm_ss");
		Date currentDate=new Date();
		return dateFormat.format(currentDate);
		
	}
	
	public void sparkReportPass(String methodName) {
		String base64code;		
		test=report.createTest(methodName);
		logs=LogManager.getLogger();
		base64code=capturescreenshot();
		capturescreenshot(driver);
		test.log(Status.INFO,"Action Performed"+methodName);
		test.log(Status.PASS, "The expected Action "+methodName+"is performed Successfully");
		test.addScreenCaptureFromBase64String(base64code,methodName);
		logs.info(methodName+"Logger event");
		
		report.flush();
		
	}
	public void reportInfo(String methodName) {
		
		test=report.createTest(methodName);
		test.generateLog(Status.INFO,"Action Performed"+methodName);
		test.log(Status.PASS, "The expected Action "+methodName+" is performed Successfully");
		report.flush();
		
	}
	
public void sparkReportFailure(String methodName) {
	String base64code;
	test=report.createTest(methodName);
	logs=LogManager.getLogger();
	capturescreenshot(driver);
	base64code=capturescreenshot();
	test.log(Status.FAIL, "The expected Action "+methodName+" is  not performed");
	test.addScreenCaptureFromBase64String(base64code,methodName);
	logs.error(methodName+"Logger event");
	report.flush();
	
}
	public void helper(String[][] data,String title) {	
		
		
		test=report.createTest(title);
		Markup m1 = MarkupHelper.createTable(data);
		test.pass(m1);
		report.flush();
			
	}
	 public void WebPageComparatorasPDF(String methodName) throws IOException {
	
		 Pdf pdf =((PrintsPage)driver).print(new PrintOptions());
		Files.write(Paths.get("./PdfFiles/Selenium_"+methodName+"_"+threadid+".pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));

	 }

public void messageCounter(int count) {
	ExcelDataProvider EDP=new ExcelDataProvider();
	int rcount=EDP.getRowCount("Home");
	
	String Message=null;
	for (int i=1;i<=rcount;i++) {
		
		if (EDP.getNumericData("Home", i, 0)==count) {
			Message= EDP.getStringData("Home", i, 2);
			
		}
	}
	
	test.log(Status.INFO, Message);
	report.flush();
	
	
}
public long getThreadId() {
	return Thread.currentThread().getId();
}

}

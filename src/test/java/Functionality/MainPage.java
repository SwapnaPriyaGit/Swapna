package Functionality;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ObjectRepository.Elements;
import ObjectRepository.contact;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class MainPage {
	public WebDriver driver;
	WebDriverWait wait;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void setUp1() throws IOException {
		htmlReporter= new ExtentHtmlReporter("extentreportT.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	
	}
	
	@AfterClass
	public void tearDown1() {
		extent.flush();
	}
		
		
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}

	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	//@Test
	public void mainPageTest() {
		/*
	 	//List <WebElement> list1= driver.findElements(By.xpath("//*[@class=\"header-services-menu header-full-width-menu nav-item menu-item--expanded dropdown\"]/ul/li/ul/li"));
		//System.out.println("No of infomrative links under Services : "+ list1.size());
		System.out.println("No of infomrative links under Services : "+ Elements.services.size());
		
		//List <WebElement> list2= driver.findElements(By.xpath("//*[@class=\"header-industries-menu header-full-width-menu nav-item menu-item--expanded dropdown\"]/ul/li"));
		//System.out.println("No of infomrative links under Industries : "+ list2.size());
		System.out.println("No of infomrative links under Industries : "+ Elements.industires.size());
		
		//List <WebElement> list3= driver.findElements(By.xpath("//*[@class=\"header-about-menu nav-item menu-item--expanded dropdown\"]/ul/li"));
		//System.out.println("No of infomrative links under About Us : "+ list3.size());
		System.out.println("No of infomrative links under About Us : "+ Elements.aboutUs.size());
		
		//List <WebElement> list4= driver.findElements(By.xpath("//*[@class=\"header-insights-menu nav-item menu-item--expanded dropdown\"]/ul/li"));
		//System.out.println("No of infomrative links under Trends and Insights : "+ list4.size());
		System.out.println("No of infomrative links under Trends and Insights : "+ Elements.trendsAndInsights.size());
		
		//List <WebElement> list5= driver.findElements(By.xpath("//*[@class=\"header-careers-menu nav-item menu-item--expanded dropdown\"]/ul/li"));
		//System.out.println("No of infomrative links under Careers : "+ list5.size());
		System.out.println("No of infomrative links under Careers : "+ Elements.careers.size());
		
		
		
		 * List<WebElement>
		 * menu=driver.findElements(By.xpath("//*[@id=\"block-mainnavigationbt\"]/li"));
		 * Iterator<WebElement> itr=menu.iterator(); while(itr.hasNext()) {
		 * System.out.println("Title : "+itr.next().getText()); }
		 */
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void ContactUs() throws InterruptedException, IOException, AWTException {
		
		test=extent.createTest("Contact Us Page Automation");
		
		InputStream input = new FileInputStream("src/test/resources/contactUs.properties");
		Properties contactDetails=new Properties();
		contactDetails.load(input);
		
		contact contactUs = PageFactory.initElements(driver, contact.class);
		driver.get(contactDetails.getProperty("applicationUrl"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	    contactUs.acceptCookies.click();
		contactUs.contactLink.click();
		contactUs.fullName.sendKeys(contactDetails.getProperty("fullName"));
		contactUs.businessEmailAddress.sendKeys(contactDetails.getProperty("EmailAddress"));
		contactUs.organization.sendKeys(contactDetails.getProperty("OrganizationName")); 
		contactUs.phone.sendKeys(contactDetails.getProperty("phone"));
		  
		Select Country=new Select(contactUs.countryList);
		Country.selectByVisibleText(contactDetails.getProperty("countryName"));
		TakesScreenshot ts1=(TakesScreenshot) driver;
		File Src1 = ts1.getScreenshotAs(OutputType.FILE);
		File dest1=new File("ContactUs_Screen1.png");
		FileHandler.copy(Src1, dest1);
		test.addScreenCaptureFromPath("ContactUs_Screen1.png");
		
		Select relationship=new Select(contactUs.relationship);
		relationship.selectByVisibleText(contactDetails.getProperty("relationship"));

		  
		contactUs.comments.sendKeys(contactDetails.getProperty("comments"));
		test.log(Status.INFO, "Provided all contact details");
				
		contactUs.fileUpload.click();
		Thread.sleep(2000);
		Robot robo = new Robot();
		StringSelection Str=new StringSelection("C:\\Users\\swapnapriya.kura\\OneDrive - HCL Technologies Ltd\\Documents\\SDET Software\\Test File Upload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Str, null);
				
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
	    robo.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);
	    contactUs.privacyPolicy.click();
	    test.log(Status.INFO, "Uploaded Contact document");
	    
	    Thread.sleep(5000);
	    
		TakesScreenshot ts2=(TakesScreenshot) driver;
		File Src2 = ts2.getScreenshotAs(OutputType.FILE);
		File dest2=new File("ContactUs_Screen2.png");
		FileHandler.copy(Src2, dest2);
		test.addScreenCaptureFromPath("ContactUs_Screen2.png");
		//Thread.sleep(5000);
	    
	    test.pass("Contact Us Page automation success");
	    		
	}
	
	@Test
	public void compareScreenshot() throws IOException, InterruptedException {
		
		InputStream input = new FileInputStream("src/test/resources/contactUs.properties");
		Properties contactDetails=new Properties();
		contactDetails.load(input);
		
		driver.manage().deleteAllCookies();
		driver.get(contactDetails.getProperty("applicationUrl"));
		driver.manage().window().maximize();
		
		TakesScreenshot ts3=(TakesScreenshot) driver;
		File Src3 = ts3.getScreenshotAs(OutputType.FILE);
		File dest3=new File("CompareScreen_Actual.png");
		FileHandler.copy(Src3, dest3);
		
		test=extent.createTest("Image Comparision for matching images");
		
		test.addScreenCaptureFromPath("CompareScreen_Actual.png");
		test.addScreenCaptureFromPath("CompareScreen_ExpMatch.png");
		
		BufferedImage ImageExp=ImageIO.read(new File("CompareScreen_ExpMatch.png"));
		BufferedImage ImageAct=ImageIO.read(new File("CompareScreen_Actual.png"));
		
		ImageDiffer imageCompare=new ImageDiffer(); 
		ImageDiff Bool=imageCompare.makeDiff(ImageExp, ImageAct);
		
		if(Bool.hasDiff()==true)
			{
			test.fail("Image not matching");
	    
			}
		else
		{
			test.pass("Images matching");
		}
		
		/*
		 * test=extent.createTest("Image Comparision for non matching images");
		 * 
		 * test.addScreenCaptureFromPath("CompareScreen_Actual.png");
		 * test.addScreenCaptureFromPath("CompareScreen_ExpNoMatch.png");
		 * 
		 * BufferedImage ImageExp1=ImageIO.read(new
		 * File("CompareScreen_ExpNoMatch.png")); BufferedImage
		 * ImageAct1=ImageIO.read(new File("CompareScreen_Actual.png"));
		 * 
		 * ImageDiffer imageCompare1=new ImageDiffer(); ImageDiff
		 * Bool1=imageCompare1.makeDiff(ImageExp1, ImageAct1);
		 * 
		 * if(Bool1.hasDiff()==true) { test.fail("Image not matching");
		 * 
		 * } else { test.pass("Images matching"); }
		 */
	}
}

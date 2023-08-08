package Functionality;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ObjectRepository.Elements;
import ObjectRepository.contact;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners (ListenerC.class)
public class MainPage {
	public WebDriver driver;
	WebDriverWait wait;
		
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
		contact contactUs = PageFactory.initElements(driver, contact.class);
		InputStream input = new FileInputStream("src/test/resources/contactUs.properties");
		Properties contactDetails=new Properties();
		contactDetails.load(input);
		
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
		
		Select relationship=new Select(contactUs.relationship);
		relationship.selectByVisibleText(contactDetails.getProperty("relationship"));
		  
		contactUs.comments.sendKeys(contactDetails.getProperty("comments"));
		
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
	    Thread.sleep(10000);
	    

		
	}
}

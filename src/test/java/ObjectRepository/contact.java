package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class contact {
	
	@FindBy(xpath="//*[@title=\"Contact Us\"]")
	public static WebElement contactLink;
	
	@FindBy(xpath="//*[@title=\"Investor Relations\"]")
	public static WebElement investorLink;
	
	@FindBy(xpath="//*[@id=\"block-secondarymenublock\"]/div/div/div/div[2]/ul/li[5]/a")
	public static WebElement whyHCLLink;
	
	@FindBy(id="onetrust-accept-btn-handler")
	public static WebElement acceptCookies;
		
	@FindBy(id="edit-full-name")
	public static WebElement fullName;
	
	@FindBy(id="edit-email-address")
	public static WebElement businessEmailAddress;
	
	@FindBy(id="edit-organization")
	public static WebElement organization;
	
	@FindBy(id="edit-phone")
	public static WebElement phone;
	
	@FindBy(id="edit-country")
	public static WebElement countryList;
	
	@FindBy(id="edit-message-comments")
	public static WebElement comments;
	
	@FindBy(id="edit-query-type")
	public static WebElement relationship;
	
	@FindBy(id="edit-upload-multifile--label")
	public static WebElement fileUpload;
	
	@FindBy(id="edit-privacy-policy")
	public static WebElement privacyPolicy;
	
}

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
	
	@FindBy(id="edit-actions-submit")
	public static WebElement submit;
	
	@FindBy(id="edit-full-name-error")
	public static WebElement fullNameError;
	
	@FindBy(id="edit-email-address-error")
	public static WebElement EmailError;
	
	@FindBy(id="edit-phone-error")
	public static WebElement phoneError;
	
	@FindBy(id="edit-country-error")
	public static WebElement countryError;
	
	@FindBy(id="edit-query-type-error")
	public static WebElement relationError;
	
	@FindBy(id="edit-message-comments-error")
	public static WebElement commentsError;
	
	@FindBy(id="privacy_policy-error")
	public static WebElement privacyError;
}

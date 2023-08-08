package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Elements {
	
	@FindBys(@FindBy(xpath="//*[@class=\"header-services-menu header-full-width-menu nav-item menu-item--expanded dropdown\"]/ul/li/ul/li"))
	public static List<WebElement> services;
	
	@FindBys(@FindBy(xpath="//*[@class=\\\"header-industries-menu header-full-width-menu nav-item menu-item--expanded dropdown\\\"]/ul/li"))
	public static List<WebElement> industires;
	
	@FindBys(@FindBy(xpath="//*[@class=\\\"header-about-menu nav-item menu-item--expanded dropdown\\\"]/ul/li"))
	public static List<WebElement> aboutUs;
	
	@FindBys(@FindBy(xpath="//*[@class=\\\"header-insights-menu nav-item menu-item--expanded dropdown\\\"]/ul/li"))
	public static List<WebElement> trendsAndInsights;
	
	@FindBys(@FindBy(xpath="//*[@class=\\\"header-careers-menu nav-item menu-item--expanded dropdown\\\"]/ul/li"))
	public static List<WebElement> careers;

}

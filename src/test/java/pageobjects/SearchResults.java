package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.Page;

public class SearchResults extends Page{
	
	WebDriver driver;
	
	public SearchResults(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText = "×")
	private WebElement popupXout;
	@FindBy(linkText = "Settings")
	private WebElement settingsLink;
	@FindBy(linkText = "Search help")
	private WebElement searchHelpLink;

	public void closePopup() {		
		click(popupXout);
	}

	public void clickSettingsLink() {
		clickWhenVisible(2, settingsLink);		
	}

	public void clickSearchHelpLink() {
		click(searchHelpLink);
		
	}

	
	

}

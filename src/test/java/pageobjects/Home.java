package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.Page;

public class Home extends Page{
	
	private WebDriver driver;
	
	@FindBy(id = "lst-ib")
	private WebElement searchInputBox;
	@FindBy(className = "lsb")
	private WebElement searchButton;
	
	public Home(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void search(String searchText) {
		clear(searchInputBox);	
		enterText(searchInputBox, searchText);
		click(searchButton);
	}
	
	

}

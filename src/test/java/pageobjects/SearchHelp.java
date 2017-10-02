package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.Page;

public class SearchHelp extends Page{
	
	private WebDriver driver;
	
	public SearchHelp(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//articles/nav[@class='sccordion']")
	private WebElement popularArticlesHelpTopic; 

}

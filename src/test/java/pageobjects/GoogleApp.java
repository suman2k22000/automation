package pageobjects;

import org.openqa.selenium.WebDriver;

public class GoogleApp {
	
	public Home home;
	public SearchResults searchResults;
	
	public GoogleApp (WebDriver driver) {
		home = new Home(driver);
		searchResults = new SearchResults(driver);
	}
	
	

}

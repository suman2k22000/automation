package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	private WebDriver driver;
	
	public Page(WebDriver driver){
		this.driver = driver;
	}
	
	
	protected WebElement setCustomTimeout(int timeOutInSeconds, ExpectedCondition<WebElement> condition) {
		return new WebDriverWait(driver, timeOutInSeconds).until(condition);
	}
	
	protected void clear(WebElement e) {
		e.clear();
	}
	
	protected void enterText(WebElement e, String text) {
		e.sendKeys(text);
	}
	
	protected void click(WebElement e){
		e.click();
	}
	
	protected void clickWhenVisible(int timeOutInSeconds, WebElement e) {
		setCustomTimeout(timeOutInSeconds, ExpectedConditions.visibilityOf(e)).click();
	}
	

}

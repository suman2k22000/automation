package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import support.TestSettings;

public class SearchHelpTopics4 extends TestSettings{
	
	
	
	@Test(groups = {"group2"})
	public void searchHelpTopics4(){
		
		goToGoogle();
		google.home.search("google");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		google.searchResults.closePopup();
		
		google.searchResults.clickSettingsLink();
		
		google.searchResults.clickSearchHelpLink();
		
		Assert.assertTrue(true);
	}

}

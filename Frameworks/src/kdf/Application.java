package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import utils.GenericMethods;

public class Application {																				
	
	@Test
	public void VerifyInValidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelJan18\\TestData.xlsx", "Sheet2");
		
		for(int i=1;i<data.length;i++) {
			switch(data[i][3]) {
			
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToAUT":
				Methods.navigateToApp(data[i][6]);
				break;
			case "enteruserID":
				Methods.entrUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.entrPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = Methods.getErrorMessage(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
			case "closeAUT":
				Methods.closeApp();
			}
		}
	}

}

package Bchat.TestScenarios;

import org.testng.annotations.Test;


import Utiles.BaseClass;
import POM.openingPage;

public class demo extends BaseClass{

	@Test
	public void openapplandingpage() {
	
		openingPage openingpage = new openingPage(driver);
		openingpage.clickCreateAccount();
	}
	
	
}

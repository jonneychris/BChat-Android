package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DisplayNamePage extends ActionsClass {

	AndroidDriver driver;
	public DisplayNamePage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="io.beldex.bchat:id/displayNameEditText")
	private WebElement txtboxDisplayName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement btnContinue;
	
	public void setDisplayName(String displayname) {
	    super.Send_keys(txtboxDisplayName, displayname);
		
	}

	
	public void clickContinue() {
		super.click(btnContinue);
	}
	
}

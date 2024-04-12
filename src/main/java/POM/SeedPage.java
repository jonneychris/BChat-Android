package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SeedPage extends ActionsClass {
	
	
	AndroidDriver driver;
	public SeedPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/recoveryPhrasePasteIcon")
	private WebElement btnCopy;
	

	@AndroidFindBy(id="io.beldex.bchat:id/clearButton")
	private WebElement btnClear;


	@AndroidFindBy(id="io.beldex.bchat:id/restoreButton")
	private WebElement btnNext;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mnemonicEditText")
	private WebElement btnSeedTextBox;

	

}

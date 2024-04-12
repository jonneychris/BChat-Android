package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatePasswordPage extends ActionsClass{

	AndroidDriver driver;
	public CreatePasswordPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/enterPinEditTxt")
	private WebElement txtBoxEnterPassword;
	
	@AndroidFindBy(id="io.beldex.bchat:id/reEnterPinEditTxt")
	private WebElement txtBoxReEnterPassword;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_0")
	private WebElement btn_0;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_1")
	private WebElement btn_1;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_2")
	private WebElement btn_2;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_3")
	private WebElement btn_3;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_4")
	private WebElement btn_4;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_5")
	private WebElement btn_5;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_6")
	private WebElement btn_6;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_7")
	private WebElement btn_7;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_8")
	private WebElement btn_8;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_9")
	private WebElement btn_9;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_delete")
	private WebElement btndelete;
	
	@AndroidFindBy(id="io.beldex.bchat:id/button_enter")
	private WebElement btnEnter;
	
	@AndroidFindBy(xpath="(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
	private WebElement btnShowPassword;

	@AndroidFindBy(xpath="(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
	private WebElement btnShowReEnteredPassword;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_enter")
	private WebElement btnTick;
	
	
	
	public void clickTick() {
		super.click(btnTick);
	}

	public void setPassword(int number) {
		 
		super.click(btn_0);
	}
	
}

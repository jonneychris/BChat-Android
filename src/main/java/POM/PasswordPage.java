package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PasswordPage extends ActionsClass {

	AndroidDriver driver;
	public PasswordPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="io.beldex.bchat:id/userPinEditTxt")
	private WebElement txtboxPassword;
	

	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_1")
	private WebElement btn1;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_2")
	private WebElement btn2;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_3")
	private WebElement btn3;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_4")
	private WebElement btn4;

	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_5")
	private WebElement btn5;

	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_6")
	private WebElement btn6;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_7")
	private WebElement btn7;

	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_9")
	private WebElement btn8;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_9")
	private WebElement btn9;

	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_0")
	private WebElement btn0;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_enter")
	private WebElement btnNext;
	
	@AndroidFindBy(id="io.beldex.bchat:id/buttonNew_delete")
	private WebElement btnCancel;
	
}

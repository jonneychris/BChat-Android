package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage extends ActionsClass{

	AndroidDriver driver;
	public RegisterPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement btnNext;

	//io.beldex.bchat:id/titleContentTextView
	
	@AndroidFindBy(id="io.beldex.bchat:id/titleContentTextView")
	private WebElement textWithDisplayName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/publicKeyTextView")
	private WebElement textBChatID;
		
	@AndroidFindBy(id="io.beldex.bchat:id/beldexAddressTextView")
	private WebElement textBeldexAddress;
	
	
	public void clickNext() {
		super.click(btnNext);
	}
	//Hey hi, welcome to BChat!
	public String getdisplayName() {
	String displayName =textWithDisplayName.getText().substring(4, 9);
	String name=displayName;
	return name;
	}
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	
	public String BChatID() {
	 String BChatId =textBChatID.getText();
	 return BChatId;
	}

	public String BeldexAddress() {
		 String BeldexAddress =textBeldexAddress.getText();
		 return BeldexAddress;
		}
	
	public void clickBChatId() {
		textBChatID.click();
	}
	
	public void clickBeldexAddress() {
		textBeldexAddress.click();
	}
	
	public boolean isBChatIdClickable() {
        return super.isClickable(textBChatID);
    }
	public boolean isBeldexAddressClickable() {
        return isClickable(textBeldexAddress);
    }
	
	public boolean isBChatIdLongClickable() {
        return super.isLongClickable(textBChatID);
    }
	public boolean isBeldexAddressLongClickable() {
        return isLongClickable(textBeldexAddress);
    }
	
}

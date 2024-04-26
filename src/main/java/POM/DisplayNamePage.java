package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.HasClipboard;
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
	public WebElement txtboxDisplayName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement btnContinue;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint='Enter a display name']")
	private WebElement elementPlacholder;
	
	
	
	public void setDisplayName(String displayname) {
		txtboxDisplayName.click();
		txtboxDisplayName.sendKeys(displayname);
	    //super.Send_keys(txtboxDisplayName, displayname);	
	}

	
	public void clickContinue() {
		super.click(btnContinue);
	}
	public void clickTextBox() {
		txtboxDisplayName.click();
	}
	
	public WebElement textboxWebElement() {
		WebElement element = txtboxDisplayName;
		return element;
	}
	
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	
	public void cleardisplayname() {
		txtboxDisplayName.clear();
	}
	
   public void pasteDisplayName(String DisplayName) {
	  // txtboxDisplayName.
	   Copy_And_Paste_Values(DisplayName, txtboxDisplayName);
	   
   }
   
   public  String gettextvalue() {
	   String Displayname=txtboxDisplayName.getText();
	   return Displayname;
   }
   
	public String NameTextBoxPlachoder() {
		
		String text = elementPlacholder.getText();
		return text;
	}
}

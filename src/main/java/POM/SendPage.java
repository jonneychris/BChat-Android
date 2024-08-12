package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SendPage extends ActionsClass {

	AndroidDriver driver;
	public SendPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Send']")
	private WebElement btnSend;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement btnScanner;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[1]")
	private WebElement btnAddrssBook;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement transactionpriorityDropdown;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement AmountTextBox;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement AddressTextBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='0.0000']")
	private WebElement Amountplaceholder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter Address']")
	private WebElement AddressPlaceholder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Send']")
	private WebElement pagetitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[8][@index='13']")
	private WebElement EstimatedFee;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Slow']")
	private WebElement optionSlow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Flash']")
	private WebElement optionFlash;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Create Transaction Error']")
	private WebElement transactionErrorPopup;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnOkInPopup;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.TextView[4]")
	private WebElement errorMsgInAmount;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.TextView[5]")
	private WebElement FiatCurrencyValue;
	
	@AndroidFindBy(className = "android.widget.ProgressBar")
	private WebElement transactionInitiatingPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Confirm Sending']")
	private WebElement confirmPopupTitle;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btncancelInConfirmPopup;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement btnokInConfirmPopup;
	
	
	
	public String pagetitle () {
		return pagetitle.getText();
	}
	
	public void click_send () {
		btnSend.click();
	}
	
	public void click_scanner () {
		btnScanner.click();
	}
	
	public void click_AddressBook () {
		btnAddrssBook.click();
	}
	public void click_dropDown () {
        transactionpriorityDropdown.click();
	}
	
	public void click_BackArrow () {
		btnBackArrow.click();
	}
	
	public String get_Amount_placeholder () {
		return Amountplaceholder.getText();
	}
	
	public  String get_Address_Placeholder () {
		return AddressPlaceholder.getText();
	}
	
	public void Enter_Values_In_Amount (String value) {
		AmountTextBox.sendKeys(value);
	}
	
	public void Enter_Values_In_Address (String value) {
		AddressTextBox.sendKeys(value);
	}
	
	public void Set_Slow_inPriority () {
		transactionpriorityDropdown.click();
		optionSlow.click();
	}
	
	public void Set_Flash_InPriority () {
		transactionpriorityDropdown.click();
		optionFlash.click();	
	}
	
	public String get_Estimated_Fee () {
		return EstimatedFee.getText();
	}

	public void click_Amount_textbox () {
		AmountTextBox.click();
	}
	
	public void click_Address_textbox () {
		AddressTextBox.click();
	}
	
	public String get_priority_value () {
		 return transactionpriorityDropdown.getText();
	}
	
	public WebElement get_Elements_in_amount_textbox () {
		activeElement();
		return AmountTextBox;
	}
	
	public WebElement get_Elements_in_address_textbox () {
		return AddressTextBox;
	}
	
	public String transactionError_popup_Title () {
		return transactionErrorPopup.getText();
	}
	
	public void click_ok () {
		btnOkInPopup.click();
	}
	
	public String get_Error_Msg_In_Amount () {
		return errorMsgInAmount.getText();
	}
	
	public String get_fiatCurrency_Value () {
		return FiatCurrencyValue.getText();
	}
	
	public void clear_TextBoxes () {
		AmountTextBox.clear();
		AddressTextBox.clear();
	}
	
	public void click_Cancel_In_confrimPopup () {
		btncancelInConfirmPopup.click();
	}
	
	public WebElement Element_Confirm_Popup () {
		return confirmPopupTitle;
	}
	
	public String get_Values_In_AmountField () {
		return AmountTextBox.getText();
	}
	
	public String get_Values_In_AddressField () {
		return AddressTextBox.getText();
	}
	
	public void paste_Value_In_Amount (String value) {
		Copy_And_Paste_Values(value, AmountTextBox);
	}
	
	public void paste_Value_In_Address (String value) {
		Copy_And_Paste_Values(value, AddressTextBox);
	}
}

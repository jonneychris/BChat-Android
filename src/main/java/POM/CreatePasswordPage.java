package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CreatePasswordPage extends ActionsClass{

	AndroidDriver driver;
	public CreatePasswordPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
		//Locator of keypad button 0
	@AndroidFindBy(xpath="//android.widget.TextView[@text='0']")
	private WebElement btn_Enter_0;
	
	//Locator of keypad button 1
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1']")
	private WebElement btn_Enter_1;
	
	//Locator of keypad button 2
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2']")
	private WebElement btn_Enter_2;
	
	//Locator of keypad button 3
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3']")
	private WebElement btn_Enter_3;
	
	//Locator of keypad button 4
	@AndroidFindBy(xpath="//android.widget.TextView[@text='4']")
	private WebElement btn_Enter_4;
	
	//Locator of keypad button 5
	@AndroidFindBy(xpath="//android.widget.TextView[@text='5']")
	private WebElement btn_Enter_5;
	
	//Locator of keypad button 6
	@AndroidFindBy(xpath="//android.widget.TextView[@text='6']")
	private WebElement btn_Enter_6;
	
	//Locator of keypad button 7
	@AndroidFindBy(xpath="//android.widget.TextView[@text='7']")
	private WebElement btn_Enter_7;
	
	//Locator of keypad button 8
	@AndroidFindBy(xpath="//android.widget.TextView[@text='8']")
	private WebElement btn_Enter_8;
	
	//Locator of keypad button 9
	@AndroidFindBy(xpath="//android.widget.TextView[@text='9']")
	private WebElement btn_Enter_9;
	
	//Locator of keypad button delete(x)
	@AndroidFindBy(xpath="//android.view.View[@content-desc='']")
	private WebElement btn_delete;
	
	//Locator of keypad button next
	@AndroidFindBy(className="android.widget.Button")
	private WebElement btnNext;
	
	@AndroidFindBy(className ="android.widget.Button")
	private WebElement btnOk;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Create Password']")
	private WebElement textPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter Old PIN']")
	private WebElement textEnterOldPin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter New PIN']")
	private WebElement textEnterNewPin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter your PIN']")
	private WebElement textEnterPin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Re-Enter your PIN']")
	private WebElement textReEnterPin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password changed successfully.']")
	private WebElement ContentPasswordChangedSuccessfully ;
	
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[@text='*']")
	private WebElement textvalueoffirstField;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.TextView[@text='*']")
	private WebElement textvalueofsecondField;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.TextView[@text='*']")
	private WebElement textvalueofthirdField;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.TextView[@text='*']")
	private WebElement textvalueoffourthField;
	
	public String textEnter() {
		String textEnter = textEnterPin.getText();
		return textEnter;
	}
	
	public String textReEnter() {
		String textReEnter = textReEnterPin.getText();
		return textReEnter;
	}
	
	public String textOldPin() {
		String textReEnter = textEnterOldPin.getText();
		return textReEnter;
	}
	
	public String textNewPin() {
		String textReEnter = textEnterNewPin.getText();
		return textReEnter;
	}
	
	public void clickOk() {
		btnOk.click();
	}
	
	public void clickNext() {
		btnNext.click();
	}
	
	public String pageTitle() {
		String PageTitle = getTextPageTitle().getText();
		return PageTitle;
	}

	public void click1() {
		btn_Enter_1.click();
	}

	public void click0() {
		btn_Enter_0.click();
	}
	
	public void clickdelete() {
		btn_delete.click();
	}
	
	/*
	 method to set invalid password
	 */
	public void setInValidPassword() {
		
		for(int i=0;i<4;i++) {
		btn_Enter_0.click();
		}
		btnNext.click();
		for(int i=0;i<4;i++) {
		 btn_Enter_1.click();
		}
		btnNext.click();
		
	}
	
	/*
	 method to set valid password
	 */
	public void setValidPassword() {
		
		for(int i=0;i<4;i++) {
		btn_Enter_1.click();
		}
		btnNext.click();
		for(int i=0;i<4;i++) {
		 btn_Enter_1.click();
		}
		btnNext.click();
		
	}

   public  String textErrorMsg() {
		String errorMessage=Toast();
		return errorMessage;
	}
   
   public void setPassword_In_Enter_Field_Only() {
		
		for(int i=0;i<4;i++) {
			btn_Enter_0.click();
		}		
		btnNext.click();
	}
   
	/*
	 method to set password with below boundary value			
	 */
   public void setPassword_with_below_boundary_value() {
			
			btn_Enter_0.click();
			btn_Enter_1.click();
			btn_Enter_2.click();			
			
			
		}
		
   /*
	 method to set password with above boundary value			
	 */
 public void setPassword_with_above_boundary_value() {
			
			btn_Enter_0.click();
			btn_Enter_1.click();
			btn_Enter_2.click();
			btn_Enter_3.click();
			btn_Enter_4.click();
			
			
		}
   
   public void setPassword_0() {
			
			
			for(int i=0;i<4;i++) {
			btn_Enter_0.click();
		}
			
		}
   public void setPassword_1() {
				
					for(int i=0;i<4;i++) {
					btn_Enter_1.click();
				}						
				}	
			
   
    public void cancel_Values() {
				for(int i=0;i<4;i++) {
					btn_delete.click();
				}
			}
 
    public void change_password_with_Valid_value () {
    	for(int i=0; i<4;i++) {
    		btn_Enter_1.click();
    	}
    	
    	btnNext.click();
    	Assert.assertEquals(textNewPin(), "Enter New PIN");
    	for(int i=0; i<4;i++) {
    		btn_Enter_0.click();
    	}
    	
    	btnNext.click();
    	Assert.assertEquals(textReEnter(), "Re-Enter your PIN");
    	for(int i=0; i<4;i++) {
    		btn_Enter_0.click();
    	}
    	btnNext.click();
    }

    
    public String text_PasswordSuccessful () {
		return ContentPasswordChangedSuccessfully.getText();
    	
    }
    
    public void Delete_And_Edit_pin_field () {
    	setPassword_0();				
		cancel_Values();				
		setPassword_1();
    }
   
    public List<String> text_Value_inPin_fields () {
		List<String> list = new ArrayList<String>();
				list.add(textvalueoffirstField.getText());
				list.add(textvalueofsecondField.getText());
				list.add(textvalueofthirdField.getText());
				list.add(textvalueoffourthField.getText());
				
				return list;
    	
    }

	public WebElement getTextPageTitle() {
		return textPageTitle;
	}

	public void setTextPageTitle(WebElement textPageTitle) {
		this.textPageTitle = textPageTitle;
	}
}

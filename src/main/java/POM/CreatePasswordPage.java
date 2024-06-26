package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
    
	
	public void clickNext() {
		btnNext.click();
	}
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}

	public void click1() {
		btn_Enter_1.click();
	}

	public void clickdelete() {
		btn_delete.click();
	}
	/*
	 method to set invalid password
	 */
//	public void setInValidPassword() {
//		txtBoxEnterPassword.click();
//		for(int i=0;i<4;i++) {
//		btn_Enter_0.click();
//		}
//		txtBoxReEnterPassword.click();
//		for(int i=0;i<4;i++) {
//		 btn_ReEnter_1.click();
//		}
//		btnTick.click();
//		
//	}
//	
//	
//	
//	public String checkEnterPaswordPlaceholder() {
//		 String enterPlaceholder =txtBoxEnterPassword.getAttribute("hint");
//		 
//		 return enterPlaceholder ;
//	}
//	
//	public String checkReEnterPaswordPlaceholder() {
//		
//		 String ReenterPlaceholder =txtBoxReEnterPassword.getAttribute("hint");
//		 return ReenterPlaceholder ;
//	}
//	
//	public void setPassword_In_Enter_Field_Only() {
//		txtBoxEnterPassword.click();
//		for(int i=0;i<4;i++) {
//			btn_Enter_0.click();
//		}
//		
//		btnTick.click();
//	}
//		public void setPassword_In_ReEnter_Field_Only() {
//			txtBoxReEnterPassword.click();
//			for(int i=0;i<4;i++) {
//	           btn_ReEnter_1.click();			
//			}
//			btnTick.click();
//	}
//		
//		public void setPassword_with_below_boundary_values_In_both_fields() {
//			txtBoxEnterPassword.click();
//			for(int i=0;i<3;i++) {
//				btn_Enter_2.click();
//			}
//			btnEnter.click();
//			//txtBoxReEnterPassword.
//			for(int i=0;i<3;i++) {
//	           btn_ReEnter_3.click();			
//			}
//			btnTick.click();
//			
//		}
//		public void setPassword_with_above_boundary_values_In_both_fields(String textBoxName) {
//			if(textBoxName.equalsIgnoreCase("EnterPasswordField"))
//			{
//			txtBoxEnterPassword.click();
//			for(int i=0;i<6;i++) {
//				btn_Enter_2.click();
//			}
//			}
//			else if(textBoxName.equalsIgnoreCase("ReEnterPasswordField")) {
//			txtBoxReEnterPassword.click();
//			//txtBoxReEnterPassword.
//			for(int i=0;i<6;i++) {
//	           btn_ReEnter_3.click();			
//			}
//			}
//			
//			
//		}
//   
//		public void setPassword_with_below_boundary_values(String Enter_TextBox_Name) {
//			
//			if(Enter_TextBox_Name.equalsIgnoreCase("EnterPasswordfield")) {
//			txtBoxEnterPassword.click();
//			btn_Enter_0.click();
//			btn_Enter_1.click();
//			btn_Enter_2.click();			
//			btnEnter.click();
//			btnTick.click();
//			}
//			else {
//				txtBoxReEnterPassword.click();
//				btn_ReEnter_3.click();
//				btn_ReEnter_4.click();
//				btn_ReEnter_2.click();
//				btnTick.click();
//			}
//			
//		}
//		
//
//		public void setPassword_0(String Enter_textBox_Name) {
//			if(Enter_textBox_Name.equalsIgnoreCase("EnterPasswordfield")) {
//			txtBoxEnterPassword.click();
//			for(int i=0;i<3;i++) {
//			btn_Enter_0.click();
//		}
//			}
//			else {
//				txtBoxReEnterPassword.click();
//				for(int i=0;i<3;i++) {
//				btn_ReEnter_0.click();
//			}
//			}
//		}
//			public void setPassword_1_In_Enter_field(String Enter_TextBox_Name) {
//				if(Enter_TextBox_Name.equalsIgnoreCase("EnterPasswordfield")) {
//					txtBoxEnterPassword.click();
//					for(int i=0;i<3;i++) {
//					btn_Enter_1.click();
//				}
//					}
//					else if(Enter_TextBox_Name.equalsIgnoreCase("ReEnterPasswordfield")){
//						txtBoxReEnterPassword.click();
//						for(int i=0;i<3;i++) {
//						btn_ReEnter_1.click();
//					}
//					}
//				}
//					
//		
//
//		public String textbox_Enter_field_Value() {
//			String value= txtBoxEnterPassword.getText();
//			return value;
//		}
//		
//		
//		public String textbox_ReEnter_field_Value() {
//			String value= txtBoxReEnterPassword.getText();
//			return value;
//		}
//		
//		
//		
//     public void delete_Values(String Enter_textBox_Name) {
//    	if(Enter_textBox_Name.equalsIgnoreCase("EnterPasswordfield")) {
//    	 for(int i=0;i<3;i++) {
//    		 btn_Enter_delete.click();
//    	 }
//    	 }
//    	else if(Enter_textBox_Name.equalsIgnoreCase("ReEnterPasswordfield")){
//    		 for(int i=0;i<3;i++) {
//        		 btn_ReEnter_delete.click();
//        	 }
//    	}
//}
//
//     public void Paste_Values_In_Enter_Field(String text){
//    	super.Copy_And_Paste_Values(text, txtBoxEnterPassword);
// 		
// 	}
//   
//     public void Paste_Values_In_ReEnter_Field(String text){
//     	super.Copy_And_Paste_Values(text, txtBoxReEnterPassword);
//  		
//  	}
//    
//     public void clickPassword() {
//    	 txtBoxEnterPassword.click();
//     }
//     
//     public void clickReEnterPassword() {
//    	 txtBoxReEnterPassword.click();
//     }
//     
//     public boolean isPasswordCopyable() {
//    	return super.isLongClickable(txtBoxEnterPassword);
//    	
//     }
//     
//     public boolean isReEnterPasswordCopyable() {
//    	return super.isLongClickable(txtBoxReEnterPassword);
//    	
//     }
//     
//     public void clickEyeIcon() {
//    btnShowPassword.click();
//    btnShowReEnteredPassword.click();
//     }
}

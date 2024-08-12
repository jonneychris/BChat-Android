package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RecoverySeedPage extends ActionsClass {

	AndroidDriver driver;
	public RecoverySeedPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='IMPORTANT']")
	private WebElement importantScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Verify PIN']")
	private WebElement PinScreenTitle;
	
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
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnYesIamSafe;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnCopy;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Recovery Seed']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[@text='*']")
	private WebElement textvalueoffirstField;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.TextView[@text='*']")
	private WebElement textvalueofsecondField;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.TextView[@text='*']")
	private WebElement textvalueofthirdField;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.TextView[@text='*']")
	private WebElement textvalueoffourthField;
	
	
	public void click_Yes_Iam_Safe () {
		btnYesIamSafe.click();
	}
	
	public String importantScreen() {
		
		String pagetitle= importantScreen.getText();
		return pagetitle;
	}


	public String pageTitle() {
		
		return pageTitle.getText();
		
	}
	
	public void click_BackArrow () {
		btnBackArrow.click();
	}
	
	public void Enter_valid_Pin () {
		
		for(int i=0;i<4;i++) {
			btn_Enter_1.click();
		}
	}
	
      public void Enter_InValid_Pin () {
		
		for (int i=0;i<4;i++) {
			btn_Enter_5.click();
		}
	}
      
      public void click_Copy () {
    	  btnCopy.click();
      }
      
      public void Enter_Value_1 () {
    	  for (int i=0;i<3;i++) {
    		  btn_Enter_1.click();
    	  }
      } 
     public void Enter_Value_2 () {
        	  for (int i=0;i<3;i++) {
        		  btn_Enter_2.click();
        	  }
        	  
      }
      
      public void Delete_Values_In_password () {
    	  for(int i=0;i<3;i++) {
  			btn_delete.click();
  		}
      }
      
      public List<String> text_Value_inPin_fields () {
  		List<String> list = new ArrayList<String>();
  				list.add(textvalueoffirstField.getText());
  				list.add(textvalueofsecondField.getText());
  				list.add(textvalueofthirdField.getText());
  				
  				return list;    	
      }
      
      public String Pin_Screen_title () {
    	  return PinScreenTitle.getText();
      }
}

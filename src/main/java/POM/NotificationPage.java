package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utiles.ActionsClass;
import Utiles.baseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationPage extends ActionsClass{

	AndroidDriver driver;
	public NotificationPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionAllNotifications;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
	private WebElement optionPriority;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionUseFastMode;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView")
	private WebElement optionSound;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionVibrate;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionInChatSounds;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[10]/android.widget.RelativeLayout/android.widget.TextView")
	private WebElement optionShow;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.TextView[@text='Default']")
	private WebElement priorityScreenTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cancelButton")
	private WebElement btnCancelInShowPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/messageTextView")
	private WebElement showPopuptile;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Name and content']")
	private WebElement optionNameAndContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Name only']")
	private WebElement optionNameOnly;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No name or content']")
	private WebElement optionNoNameOrContent;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[10]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.TextView")
	private WebElement SelectedoptionInShowPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/recyclerView")
	private WebElement optionInShow;
	
	public void click_All_Notification_option () {
		optionAllNotifications.click();
	}
	
	public WebElement get_All_options_Element () {
		List<WebElement> list = new ArrayList<WebElement>();
		
		
		list.add(optionPriority);
		list.add(optionUseFastMode);
		list.add(optionVibrate);
		list.add(optionSound);
		list.add(optionInChatSounds);
		list.add(optionShow);
		WebElement Element = null;
		for(int i=0;i< list.size();i++) {
			
			 Element =list.get(i) ;
		}
		
		return Element;
	}
	
	public String pageTitle () {
		return pageTitle.getText();
	}
	
	public String Show_Popup_Title () {
		return showPopuptile.getText();
	}

	public String priority_screen_title () {
		return priorityScreenTitle.getText();
	}
	public void click_option_Priority () {
		optionPriority.click();
	}
	
	public void click_option_Show () {
		optionShow.click();
	}

	public void select_option_Name_and_content () {
		optionNameAndContent.click();
	}

	public void select_option_Name_Only () {
		optionNameOnly.click();
	}
	
	public void select_option_No_Name_Or_content () {
		optionNoNameOrContent.click();
	}
	
	public void click_cancel_In_Show_Popup() {
		btnCancelInShowPopup.click();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public String get_Showing_option_In_Show_field () {
		return SelectedoptionInShowPopup.getText();
	}
	
	public void Select_options_in_Show () {
		
			
			click_option_Show();
		    optionNameAndContent.click();
		    click_option_Show();
		    optionNameOnly.click();
		    click_option_Show();
		    optionNoNameOrContent.click();
	
			
	}
}

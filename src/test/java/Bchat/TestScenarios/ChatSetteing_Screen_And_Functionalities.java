package Bchat.TestScenarios;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utiles.baseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.reactivex.rxjava3.functions.Action;

public class ChatSetteing_Screen_And_Functionalities extends baseClass{

	/*
	 PreSetup
	 */
	@Test(priority = 0)
	public void PreSetup () {
		
	
	}
	
	
	/*
	Validate whether able to navigate back to the my account screen
	*/
	@Test
	public void To_Validate_whether_Able_to_navigate_back_to_my_account_screen () {
		
	}
	
	/*
	Validate the working of the enter is send option in the messaging screen in on condition.
    */
   @Test(priority = 2)
	public void To_Validate_working_of_enterkey_is_send_option_in_messaging_screen_in_on_condition () {
	  
	   
	   ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	  
	     
	   
	   
   }
	
	
	/*
	Validate the working of the enter is send option in the messaging screen in off condition.
	*/


}

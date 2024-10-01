package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyWalletPage extends ActionsClass {

	AndroidDriver driver;
	public MyWalletPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet']")
	private WebElement enableWalletScreenTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create PIN']")
	private WebElement CreatePinScreentitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify PIN']")
	private WebElement VerifyPinScreentitle;
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Wallet']")
	private WebElement MyWalletScreentitle;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement CheckBox;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnEnableWallet;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.view.View[6]/android.widget.TextView[1]")
	private WebElement transactionEmptyScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Synchronized']")
	private WebElement contentSynchronized;
	
	@AndroidFindBy(accessibility = "Scan")
	private WebElement btnScanner;
	
	@AndroidFindBy(accessibility = "Send")
	private WebElement btnSend;
	
	@AndroidFindBy(accessibility ="Receive")
	private WebElement btnReceive;
	
	@AndroidFindBy(accessibility ="Rescan")
	private WebElement btnSyncOption;
	
	@AndroidFindBy(accessibility ="wallet settings")
	private WebElement btnSettings;
	
	@AndroidFindBy(accessibility ="Transaction Filter")
	private WebElement btnTransactionFilter;

	@AndroidFindBy(id = "io.beldex.bchat:id/reConnectButton_Alert")
	private WebElement reconnectOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/rescanButton_Alert")
	private WebElement rescanOption;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[1][@text='Reconnecting...']")
	private WebElement StatusReconnecting;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan']")
	private WebElement ScanpageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Send']")
	private WebElement SendpageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Receive']")
	private WebElement ReceivepageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Rescan']")
	private WebElement ReScanpageTitle;
	
	@AndroidFindBy(className ="android.widget.TextView")
	private WebElement SyncOptionpageTitle;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"divider circle\"])[1]")
	private WebElement TransactionFilterEnabled;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnRescan;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[2][@index='1']")
	private WebElement fiatcurrencyValue;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[3][@index='4']")
	private WebElement BdxValue;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement blockheighttextbox;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement btnSwitchblockheightAnddate;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[4]")
	private WebElement errormsg;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Restore from BlockHeight']")
	private WebElement placholder;
	
	@AndroidFindBy(accessibility  = "Calendar")
	private WebElement btnCalendar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OK']")
	private WebElement btnOkInCalendar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Ok']")
	private WebElement btnOkInFilterCalendar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Wallet Syncing..']")
	private WebElement statusSyncing;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@index='0']")
	private WebElement BlocksRemaining;
	
	@AndroidFindBy(accessibility = "Change to previous month")
	private WebElement ChangeToPreviousMonth;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[1]")
	private WebElement IncomingCheckBox;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[2]")
	private WebElement OutgoingCheckBox;
	
	@AndroidFindBy(accessibility = "Filter By Date")
	private WebElement btnFilterDate;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"From Date\"])[1]")
	private WebElement btnFromDate;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"To Date\"])[1]")
	private WebElement btnToDate;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Select Date Range']")
	private WebElement FilterByDatePopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	private WebElement btnCancelInFilter;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[2][@index='5']")
	private WebElement firstTransactionInHistory;
	
	@AndroidFindBy(xpath="//android.widget.TextView[2][@index='2']")
	private WebElement firsttransactionamount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Details']")
	private WebElement DetailsScreentitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[5][@index='5']")
	private WebElement transactionID;
	
	@AndroidFindBy(xpath ="com.android.chrome:id/url_bar")
	private WebElement explorerUrl;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.TextView[11]")
	private WebElement amountInDetailsScreen;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement copyIconInDetails;
	
	@AndroidFindBy(accessibility = "back arrow")
	private WebElement backarrowInDetails;
	
	public String Enable_Wallet_Screen_Title () {
		return enableWalletScreenTitle.getText();
	}
	
	public String CreatePin_Screen_Title () {
		return CreatePinScreentitle.getText();
	}
	
	public String VerifyPin_Screen_Title () {
		return VerifyPinScreentitle.getText();
	}
	
	public String MyWalletScreenTitle () {
		return MyWalletScreentitle.getText();
	}
	
	public void click_CheckBox () {
		CheckBox.click();
	}
	
	
	public void click_Enable_Wallet () {
		btnEnableWallet.click();
	}
	
	public void Click_Back_Arrow () {
		btnBackArrow.click();
	}

	
	public WebElement Element_Of_Enable_wallet_button () {
		return btnEnableWallet;
	}
	
	public String Transaction_History_empty_screen () {
		return transactionEmptyScreen.getText();
	}
	
	public WebElement Status_Synchronized () {
		return contentSynchronized;
	}
	
	public String Status_Reconnecting () {
		return StatusReconnecting.getText();
	}
	
	public void click_Scan_option () {
		btnScanner.click();
	}
	
    public void click_Send_option () {
		btnSend.click();
	}

    public void click_Recive_option () {
		btnReceive.click();
	}

    public void click_Sync_option () {
		btnSyncOption.click();
	}

    public void click_Reconnect_option () {
    	reconnectOption.click();
    }

    public void click_Rescan_Option () {
    	rescanOption.click();
    }
    
    public void click_Transaction_Filter () {
    	btnTransactionFilter.click();
    }
    
    public void click_WalletSettings_Option () {
    	btnSettings.click();
    }
    
    public String Send_Page_Title () {
    	return SendpageTitle.getText();
    }
    
    public String Receive_Page_Title () {
    	return ReceivepageTitle.getText();
    }
    
    public String SyncOption_Page_Title () {
    	return SyncOptionpageTitle.getText();
    }
    
    public String Scan_Page_Title () {
    	return ScanpageTitle.getText();
    }
    
    public WebElement Transaction_Filter_Enabled () {
		return TransactionFilterEnabled;   	
   }
    
    public String Rescan_page_Title () {
    	return ReScanpageTitle.getText();
    }
    
    public void click_Btn_Rescan () {
    	btnRescan.click();
    }

    public String get_FiatCurrency_value () {
    	return fiatcurrencyValue.getText();
    }

    public String get_Bdx_value () {
    	return BdxValue.getText();
    }
    
    public String get_Values_From_Blockheight_textbox () {
    	return blockheighttextbox.getText();
    }
 
    public void click_To_Swicth_rescan_option () {
    	btnSwitchblockheightAnddate.click();
    }
    
    public void Enter_values_In_Blockheight_textbox (String value) {
    	blockheighttextbox.sendKeys(value);
    }
    
    public String get_Error_Msg () {
    	return errormsg.getText();
    }
    
    public void clear_blockheight_textbox () {
       blockheighttextbox.clear();	
    }
    
    public String get_placholder_value () {
    	return placholder.getText();
    }
    
    public void paste_Values (String value) {
		   Copy_And_Paste_Values(value,blockheighttextbox);
	   }
    
    public void rescan_From_date () {
    	btnCalendar.click();
    	btnOkInCalendar.click();
    	click_Btn_Rescan();
    }
    
    public String get_Status_Syncing () {
    	return statusSyncing.getText();
    }
    
    public void click_Filter_By_date () {
    	btnFilterDate.click();
    }

    public void Select_FromDate_previousMonth (int date) {
    	
    	btnFromDate.click();
    	ChangeToPreviousMonth.click();
    	driver.findElement(By.xpath("//android.widget.TextView["+date+"]/android.widget.Button[@index='1']")).click();
    	btnOkInFilterCalendar.click();
    }
    
    public void click_Incoming_CheckBox () {
    	IncomingCheckBox.click();
    }
    
    public void click_Outgoing_CheckBox () {
    	OutgoingCheckBox.click();
    }
    
    public void Select_ToDate_As_TodayDate () {
    	btnToDate.click();
    	btnOkInFilterCalendar.click();
    }
    
    public String Filter_By_Date_Popup_Title() {
		return FilterByDatePopup.getText();
	}
    
    public void click_ok_In_FilterDate () {
    	btnOkInFilterCalendar.click();
    }
    
    public int get_Blocks_Remaining (){
    	String blocksRemaining = BlocksRemaining.getText();
    	String blocksCount = blocksRemaining.replaceAll(",", "").substring(0, 7).trim();
    	 return Integer.parseInt(blocksCount); 	
    }
    
    public void click_Cancel_In_FilterDate () {
    	btnCancelInFilter.click();
    }
    
    public void click_First_Transaction () {
    	firstTransactionInHistory.click();
    }
    
    public String get_first_Transaction_amount () {
    	return firsttransactionamount.getText();
    }
    
    public String Details_screen_title () {
    	return DetailsScreentitle.getText();
    }
    
    public String get_Amount_In_details () {
    	return amountInDetailsScreen.getText();
    }
    
    public void click_CopyIcon_In_details () {
    	copyIconInDetails.click();
    }
    
    public void click_transactionID () {
    	transactionID.click();
    }
    
    public String get_Explorer_Url () {
    	return explorerUrl.getText();
    }
    
    public void click_BackArrow_In_details () {
    	backarrowInDetails.click();
    }
    
    public WebElement Element_of_First_Transaction () {
    	return firstTransactionInHistory;
    }
}

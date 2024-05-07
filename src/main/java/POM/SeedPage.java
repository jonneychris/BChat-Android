package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SeedPage extends ActionsClass {
	
	
	AndroidDriver driver;
	public SeedPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/recoveryPhrasePasteIcon")
	private WebElement btnPaste;
	
	@AndroidFindBy(id="io.beldex.bchat:id/recoveryPhraseCountWord")
	private WebElement NumberCount;
	
	@AndroidFindBy(id="io.beldex.bchat:id/clearButton")
	private WebElement btnClear;


	@AndroidFindBy(id="io.beldex.bchat:id/restoreButton")
	private WebElement btnNext;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mnemonicEditText")
	public WebElement SeedTextBox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	private WebElement textPageTitle;
	
	
	
	public WebElement SeedTextBox () {
		 return SeedTextBox;
	}
	
	public String Placeholder () {
		return  SeedTextBox.getText();
		
	}
	public String SeedtextboxValues() {
		return SeedTextBox.getText();
	}
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	
	public void clickClear () {
		btnClear.click();
	}
	
	public void clickNext () {
		btnNext.click();
	}
	
	public void clickTextBox () {
		SeedTextBox.click();
	}
	
	public void clickPasteButton () {
		btnPaste.click();
	}
	public void pasteSeedValue() {
		SeedTextBox.click();
		driver.setClipboardText("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice venomous");
	    btnPaste.click();
	}
	
	
	public void EnterSeedValue() {
		SeedTextBox.click();
		SeedTextBox.sendKeys("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice venomous");
	    
	}
	
	public String SeedValueCount () {
		String count = NumberCount.getText();
		return count;
	}
	
	public void set_Below_Boundary_SeedValue() {
		SeedTextBox.click();
		SeedTextBox.sendKeys("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice ");
	    	   
	}
	
	public void set_above_Boundary_SeedValue() {
		SeedTextBox.click();
		SeedTextBox.sendKeys("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice voice ");
	    	   
	}
	
	public void setSeedValue(String value1) {
		SeedTextBox.click();
		SeedTextBox.sendKeys(value1);
		
	}
	
	public void FindActivity() {
		
		activeElement();
	}
	
	public void clearSeedValues () {
		SeedTextBox.clear();
	}

	
}

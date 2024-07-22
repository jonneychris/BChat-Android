package POM;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HopsPage extends ActionsClass {

	
	AndroidDriver driver;
	public HopsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hops']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[5][@text='Master Node']")
	private WebElement MasterNodeContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[3][@text='Entry Node']")
	private WebElement EntryNodeContent;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement backArrow;
	
	public String pageTitle () {
		return pageTitle.getText();
	}
	
	public  WebElement Element_Master_Node () { 	       
		return MasterNodeContent;
	}
	
	public  WebElement Element_Entry_Node () { 	       
		return EntryNodeContent;
	}
	
	public void click_Back_Arrow () {
		backArrow.click();
	}
	
}

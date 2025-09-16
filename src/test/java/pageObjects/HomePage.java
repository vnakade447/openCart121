package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()=\"Register\"]")
	WebElement lnkRegistration;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	public void myAccount() {
		lnkMyaccount.click();
	}
	
	public void registration() {
		lnkRegistration.click();
	}
	
	public void myLogin() {
		lnkLogin.click();
	}

}

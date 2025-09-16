package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telePhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyPolicys;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
			lastName.sendKeys(lastname);
		}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void setTelephoe(String telephone) {
		telePhone.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}
	
	public void setPrivacyPolicy() {
		privacyPolicys.click();
	}
	
	public void clickCountinue() {
		continueButton.click();
	}
	
	public String getConfirmationMeassge() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	

}






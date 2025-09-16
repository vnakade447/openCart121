package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	
	WebDriver driver;

	public loginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']")
	WebElement username;
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement password;
	@FindBy(xpath="//input[@value='Login']") 
	WebElement login;
	
	public void userName(String Username) {
		username.sendKeys(Username);
	}
	
	public void passWord(String pass) {
			password.sendKeys(pass);
		}
	
	public void loginButton() {
		login.click();
	}




}

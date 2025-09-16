package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("Starting the TC002_LoginTest case");
		
		try {
			HomePage hp=new HomePage(driver);
			hp.myAccount();
			hp.myLogin();
			
			loginPage lp=new loginPage(driver);
			lp.userName(properties.getProperty("email")+"@gmail.com");
			lp.passWord(properties.getProperty("pass"));
			lp.loginButton();
			
			MyAccountPage myp=new MyAccountPage(driver);
			boolean targetPage=myp.isMyAccountPageExits();
			Assert.assertEquals(targetPage, true, "Login failed");
			myp.logout();
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finshed the TC002_LoginTest case");
	}
}

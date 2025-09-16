package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class , groups="DataDriven")
	public void verify_LoginDDT(String uname, String pass,String exp) {
		
		logger.info("Test Case started TC003_LoginDDT for testing ");
		try {
			HomePage hp=new HomePage(driver);
			hp.myAccount();
			hp.myLogin();
			
			loginPage lp=new loginPage(driver);
			lp.userName(uname);
			lp.passWord(pass);
			lp.loginButton();
			
			MyAccountPage myp=new MyAccountPage(driver);
			boolean targetPage=myp.isMyAccountPageExits();
			
			
			if(exp.equalsIgnoreCase("vlaid")) {
				if(targetPage==true) {
					Assert.assertTrue(true);
					myp.logout();
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
					Assert.assertTrue(false);
					myp.logout();
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finshed the testing for TC003_LoginDDT");
	}

}

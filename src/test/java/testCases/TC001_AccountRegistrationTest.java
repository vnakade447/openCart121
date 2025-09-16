package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	//WebDriver driver;
	
	@Test(groups={"Regression","Master"})
	
	public void verify_account_regidtration() {
		
		logger.info("starting Testcase TC001_AccountRegistrationTest");
		
		try 
		{
			HomePage homepage=new HomePage(driver);
			homepage.myAccount();
			logger.info("Clicked on my account link");
			homepage.registration();
			logger.info("Clicked on my register link");
			
			logger.info("prviding cutomer info");
			AccountRegistrationPage arp=new AccountRegistrationPage(driver);
			arp.setFirstName(randomString().toUpperCase());
			arp.setLastName(randomString().toUpperCase());
			arp.setEmail(randomString()+"@gmail.com");
			arp.setTelephoe(randomNumbers());
			
			String pass=randomAlphaNumeric();
			
			arp.setPassword(pass);
			arp.setConfirmPassword(pass);
			arp.setPrivacyPolicy();
			arp.clickCountinue();
			
			logger.info("Validating info");
			String message=arp.getConfirmationMeassge();
			Assert.assertEquals(message, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.info("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("Finished Testcase TC001_AccountRegistrationTest");
	}
	

}

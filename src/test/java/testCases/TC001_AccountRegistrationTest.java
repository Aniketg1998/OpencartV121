package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("******* Starting TC001_AccountRegistrationTest *******");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer details....");
		arp.setFirstName(randomeString());
		arp.setLastName(randomeString());
		arp.setEmail(randomeString()+"@gmail.com");
		arp.setTelepjone(randomeNumber());
		String pwd = randomAlphaNumeric();
		arp.setPassword(pwd);
		arp.setConfirmPassword(pwd);
		arp.setPrivacyPolicy();
		arp.clickContinue();
		
		logger.info("Validating expected message..");
		String confmsg = arp.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(confmsg,  "Your Account Has Been Created!");
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******* Finished TC001_AccountRegistrationTest *******");
	}
	
	
}

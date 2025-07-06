package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("******** Starting TC002 LoginTets *********");
		
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			AccountLoginPage lp = new AccountLoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			Assert.assertTrue(targetPage);	//Assert.assertEquals(tagetPage, true, "Login Failed");
			
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("******** Finished TC002 LoginTets *********");
	}
	
}

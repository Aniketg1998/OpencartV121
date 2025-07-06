package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups="Datadriver")  //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("***** Starting TC003_LoginDDT ***********");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			AccountLoginPage lp = new AccountLoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("valid")) 
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("************* Finished TC003_LoginDDT *********");
	}
	
}

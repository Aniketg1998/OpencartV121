package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;

	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	
	public void setLastName(String fname) {
		txtLastName.sendKeys(fname);
	}
	
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	
	public void setTelepjone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	
	
	public void clickContinue() {
		btnContinue.click();
		
		/*
		 JavaScriptExecutor js = (JavaScriptExecutor) driver;
		 js.executeScript("arguments[0].click();", btnContinue);
		 */
	}
	
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
}

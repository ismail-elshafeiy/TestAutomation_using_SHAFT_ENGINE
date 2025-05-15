package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage {
	// driver
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Elements Locators
	private By email_TxtBox = By.id("Email");
	private By password_TxtBox = By.id("Password");
	private By rememberMe_ChkBx = By.cssSelector("input#RememberMe");
	private By login_Btn = By.cssSelector("button.button-1.login-button");
	private By myAccount_Link = By.cssSelector("a.ico-account");

	public static By myAccount_txt () {
		return By.cssSelector("a.ico-account");
	}


	/////////////////////////////////////////////////////////////////
	//////////////////  Business Actions ////////////////////////////
	/////////////////////////////////////////////////////////////////

	@Step ("Enter Email [{ email }] And password [{ password }]")
	public HomePage loginViaEmail (String email, String password) {
		driver.element()
				.type(email_TxtBox, email)
				.type(password_TxtBox, password)
				.type(login_Btn, Keys.ENTER);
		return new HomePage(driver);
	}

	@Step ("Select Remember Me ? {state}")
	public LoginPage selectRememberMe_ChkBx (String state) {
		if ( state.equalsIgnoreCase("uncheck") && driver.element().isElementDisplayed(rememberMe_ChkBx) ) {
			driver.element().click(rememberMe_ChkBx);

		} else if ( state.equalsIgnoreCase("check") && ! driver.element().isElementDisplayed(rememberMe_ChkBx) ) {
			driver.element().click(rememberMe_ChkBx);
		}
		return this;
	}


}

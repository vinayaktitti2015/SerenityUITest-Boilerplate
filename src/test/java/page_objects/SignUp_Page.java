package page_objects;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Constants;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SignUp_Page extends PageObject {
	public static String NAME;
	public static String EMAIL;

	@FindBy(xpath = "//div[contains(text(),'Sign In')]")
	public WebElementFacade btn_signIn_MenuHeader;

	@FindBy(xpath = "//a[contains(@class,'list-group-item create-account')]")
	public WebElementFacade btn_createNewAccount;

	@FindBy(xpath = "//input[@id='ap_customer_name']")
	public WebElementFacade input_name;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElementFacade input_email;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@id='ap_password_check']")
	public WebElementFacade input_reEnterPassword;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElementFacade btn_createIMDBAccount;

	@FindBy(xpath = "//span[contains(text(),'Sign in with IMDb')]")
	public WebElementFacade btn_signIn_withIMDB;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElementFacade btn_signIn_Email;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElementFacade btn_signIn_Password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElementFacade btn_signIn;

	@FindBy(xpath = "//span[contains(@class,'imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle')]")
	public WebElementFacade label_accountName;
	
	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	public WebElementFacade btn_signOut;

	// methods
	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(btn_signIn_MenuHeader));
		btn_signIn_MenuHeader.click();

	}

	public void newAccountSignUp() {

		NAME = RandomStringUtils.randomAlphabetic(8);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		EMAIL = Constants.USERNAME + randomInt + "@gmail.com";

		btn_createNewAccount.click();
		waitFor(input_name);
		input_name.clear();
		input_name.sendKeys(NAME);
		input_email.clear();
		input_email.sendKeys(EMAIL);
		input_password.clear();
		input_password.sendKeys(Constants.PASSWORD);
		input_reEnterPassword.clear();
		input_reEnterPassword.sendKeys(Constants.REPEATPASSWORD);
		btn_createIMDBAccount.click();

	}

	public void verifyAccountPageRedirection() {
		String text = label_accountName.getText();
		assertThat(text).isEqualTo(NAME);
	}

	public void verifyNewAccountLogin() {
		btn_signIn_withIMDB.click();
		btn_signIn_Email.clear();
		btn_signIn_Email.sendKeys(EMAIL);
		btn_signIn_Password.sendKeys(Constants.PASSWORD);
		btn_signIn.click();
		verifyAccountPageRedirection();
	}
	
	public void verifyLogOut() {
		label_accountName.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(btn_signOut));
		Actions action = new Actions(getDriver());
		action.moveToElement(btn_signOut).click().perform();
		
		String text = btn_signIn_MenuHeader.getText();
		assertThat(text).isEqualTo("Sign In");
		getDriver().manage().deleteAllCookies();
		
	}
}

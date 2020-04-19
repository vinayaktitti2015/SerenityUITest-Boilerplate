package step_definitions;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import page_objects.IMDB_HomePage;
import page_objects.NavigateTo;
import page_objects.SignUp_Page;
import page_objects.TVShows_Page;
import utils.Helper;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUp_step_definitions {

	@Steps
	NavigateTo navigateTo;

	@Steps
	private IMDB_HomePage homePage;

	@Steps
	private SignUp_Page signUpPage;

	@Steps
	Helper helper;

	@When("^I click SignIn on menu header$")
	public void i_click_SignIn() {
		signUpPage.clickSignIn();
	}

	

	@When("^I SignUp new account$")
	public void i_SignUp_new_account() {
		signUpPage.newAccountSignUp();
	}

	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String arg1) {
		
	}
	
	@When("^I login as user$")
	public void i_login_as_user() {
		signUpPage.verifyNewAccountLogin();
	}

	@Then("^I should see navigate to account page$")
	public void i_should_see_navigate_to_account_page() {
		signUpPage.verifyAccountPageRedirection();
	}
	
	@Then("^I Logout as user$")
	public void i_logout() {
		signUpPage.verifyLogOut();
	}

}

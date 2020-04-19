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
import page_objects.TVShows_Page;
import utils.Helper;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage_step_definitions {

	@Steps
    NavigateTo navigateTo;
	
	@Steps
	private IMDB_HomePage homePage;
	
	@Steps
	private TVShows_Page tvShowsPage;
	
	@Steps
	Helper helper;

	@Given("^user is on IMDB homepage$")
	public void user_is_on_IMDB_homepage() {
		navigateTo.theIMDBHomePage();
	}

	@When("^I mousehover on Menu and click on \"([^\"]*)\"$")
	public void i_mousehover_on_Menu_and_click_on_Top_TV_shows(String args) {
		homePage.mouseHoverAndClick(args);
	}

	@Then("^I should redirected to \"([^\"]*)\" page$")
	public void i_should_redirected_to_page(String arg1) throws IOException {
		Helper.verify_Title(arg1);
	}

	@Then("^get the results which is rated as \"([^\"]*)\" in the test result$")
	public void get_the_results_which_is_rated_as_in_the_test_result(String arg1) {
		tvShowsPage.getTitleResults();
	}
	
	@When("^I enter \"([^\"]*)\" in search field$")
	public void i_enter_in_search_field(String arg1) {
		homePage.enterSearchKeyword(arg1);
	}
	
	@Then("^The searchHeader should contain \"([^\"]*)\"$")
	public void the_searchHeader_should_contain(String arg1) {
	    homePage.verifyFindSearchTerm(arg1);
	}

}

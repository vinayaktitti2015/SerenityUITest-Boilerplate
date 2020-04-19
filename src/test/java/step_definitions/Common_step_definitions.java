package step_definitions;

import static org.junit.Assert.assertTrue;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.io.IOException;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import utils.Helper;

public class Common_step_definitions {

	@Steps
	Helper helper;
	
	@Then("^The URL should contain \"([^\"]*)\"$")
    public void the_URL_should_contain(String arg1) throws Throwable {
        String url = getDriver().getCurrentUrl();
        assertTrue("URL Not Found: " + arg1, url.contains(arg1));

    }
	
	@Then("^The header should contain \"([^\"]*)\"$")
	public void the_header_should_contain(String arg1) throws IOException {
	   Helper.verify_Header(arg1);
	}
	
	@Then("^I should see \"([^\"]*)\" text displayed$")
	public void i_should_see_text_displayed(String arg1) throws IOException {
		helper.verify_ContainsText(arg1);
	}
	
}

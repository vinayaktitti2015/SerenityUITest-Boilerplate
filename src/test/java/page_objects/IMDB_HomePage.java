package page_objects;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import utils.Helper;

@DefaultUrl("https://www.imdb.com")
public class IMDB_HomePage extends PageObject {

	@Steps
	Helper helper;

	// homepage objects
	@FindBy(xpath = "//div[text()='Menu']")
	public WebElementFacade btn_Menu_Header;

	@FindBy(xpath = "//span[text()='TV Shows']")
	public WebElementFacade label_TVShows;

	@FindBy(xpath = "//input[@id='suggestion-search']")
	public WebElementFacade input_searchIMDB;

	@FindBy(xpath = "//button[@id='suggestion-search-button']//*[@class='ipc-icon ipc-icon--magnify']")
	public WebElementFacade icon_search;

	@FindBy(xpath = "//h1[@class='findHeader']")
	public WebElementFacade label_findHeader;

	@FindBy(xpath = "//span[@class='findSearchTerm']")
	public WebElementFacade label_findSearchHeaderTerm;

	public void mouseHoverAndClick(String args) {
		btn_Menu_Header.click();
		waitFor(label_TVShows);
		helper.clickRandomText(args);
	}

	public void enterSearchKeyword(String args) {
		input_searchIMDB.clear();
		input_searchIMDB.sendKeys(args);
		icon_search.click();
	}

	public void verifyFindSearchTerm(String args) {
		String text = label_findSearchHeaderTerm.getTextContent();
		assertThat(text).isEqualTo(args);

	}
}

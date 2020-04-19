package page_objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TVShows_Page extends PageObject {

	// homepage objects
	@FindBy(xpath = "//h1[@class='header']")
	public WebElementFacade label_Header;

	@FindBy(xpath = "(//td[@class='ratingColumn imdbRating']//strong)/preceding::td[1]/a[1]")
	public WebElementFacade label_TitleColumn;

	@FindBy(xpath = "(//td[@class='ratingColumn imdbRating']//strong)")
	public By label_UserRatings;

	public String getTitleResults() {
		String titleResult = null;
		
		By element = By.xpath("(//td[@class='ratingColumn imdbRating']//strong)");
		List<WebElement> list = getDriver().findElements(element);
		int rows_count = list.size();

		for (WebElement result : list) {
			for (int row = 0; row < rows_count; row++) {
				if (result.getText().contains("9.5")) {
					WebElement Element = result.findElement(By.xpath("(//td[@class='ratingColumn imdbRating']//strong)["
							+ (row + 1) + "]/preceding::td[1]/a[1]"));
					 titleResult = Element.getText();
					System.out.println("Title Result: " + titleResult);
				}
				break;
			}
		}
		return titleResult;

	}
}

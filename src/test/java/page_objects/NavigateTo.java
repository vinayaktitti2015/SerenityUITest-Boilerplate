package page_objects;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    IMDB_HomePage homePage;

    @Step("Open the IMDB home page")
    public void theIMDBHomePage() {
    	homePage.open();
    }
}

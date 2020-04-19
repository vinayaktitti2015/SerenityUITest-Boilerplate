package utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import common.BaseTest;
import net.thucydides.core.annotations.Managed;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.assertj.core.api.SoftAssertions;

public class Helper extends BaseTest {

	public static void verify_Title(String arg1) throws IOException {
		new WebDriverWait(getDriver(), 5).until(titleContains(arg1));
		assertThat(getDriver().getTitle().contains(arg1));
	}

	public static void verify_Header(String arg1) throws IOException {
		WebElement element = getDriver().findElement(By.xpath("//h1[@class='header']"));
		String text = element.getText();
		assertThat(text).isEqualTo(arg1);
	}

	public static void verify_TextEquals(WebElement locator, String expected) throws IOException {
		WebElement TextFile = locator;
		String actual = TextFile.getText();
		Assert.assertEquals(actual, expected);
	}

	public static void verify_ContainsText(String expected) throws IOException {
		String bodyText = getDriver().findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains(expected), expected + " Text Not Found");
	}

	public static void verify_TextExist(String expected) throws IOException {
		List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + expected + "')]"));
		Assert.assertTrue(list.size() > 0, expected + " Text Not Found");
	}

	public static void verify_ContainsURL(String expected) throws IOException {
		String URL = getDriver().getCurrentUrl();
		Assert.assertTrue(URL.contains(expected), expected + "URL Not Found");
	}

	public static void verify_Text_Boolean(WebElement locator, String textname) throws IOException {

		try {

			WebElement TextFile = locator;
			String Actual = TextFile.getText();
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					Actual);

			if (!ImagePresent) {
				System.out.println(Actual + "  Text NOT Found.");
			} else {
				System.out.println(Actual + " Text  Found.");
			}

		} catch (Exception e) {
			System.out.println(e.getClass());
			e.printStackTrace();
		}

	}

	public static boolean retryingFindClickStaleElement(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 15);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// dropdown handling
	public static void selectByIndex(WebElement locator, int indx) throws IOException {
		WebElement dropdown = locator;
		Select value = new Select(dropdown);
		value.selectByIndex(indx);
	}

	public static void selectByVisibleText(WebElement locator, String strng) throws IOException, InterruptedException {
		WebElement dropdown = locator;
		Select value = new Select(dropdown);
		value.selectByVisibleText(strng);
	}

	public static void selectByValue(WebElement locator, String strng) throws IOException, InterruptedException {
		WebElement dropdown = locator;
		Select value = new Select(dropdown);
		value.selectByValue(strng);
	}

	// click functions
	public static void clickRandomText(String args) {
		WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'" + args + "')]"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		// Actions action = new Actions(getDriver());
		// action.moveToElement(element).click().perform();
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView()", element);
		jse.executeScript("arguments[0].click();", element);

	}

}

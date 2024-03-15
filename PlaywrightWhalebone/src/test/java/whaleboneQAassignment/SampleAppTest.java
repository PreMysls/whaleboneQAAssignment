package whaleboneQAassignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SampleAppTest {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("http://uitestingplayground.com");
		page.locator("//a[contains(text(),'Sample App')]").click();

		page.locator("(//input[@class='form-control'])[1]").fill("honzik2");
		page.locator("(//input[@class='form-control'])[2]").fill("pwd");

		final String loggedOutLoginStatus = "User logged out.";
		final String invalidUsernamePasswordLoginStatus = "Invalid username/password";
		final String userName = "Premysl";
		final String shortUserName = "a";
		final String passwordCorrect = "pwd";
		final String longSpecialChars = "/[#{special_chrs.gsub(/./){|char| \"\\\\#{char}\"}}]/~!@#$%^&*()-_=+[]\\{}|;':\",./<>?";

		// test1, confirm empty form
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText(invalidUsernamePasswordLoginStatus);

		// test2, only username
		page.reload();
		page.locator("(//input[@class='form-control'])[1]").fill(userName);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText(invalidUsernamePasswordLoginStatus);

		// test 3, only password
		page.reload();
		page.locator("(//input[@class='form-control'])[2]").fill(passwordCorrect);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText(invalidUsernamePasswordLoginStatus);

		// test 4, correct username, wrong long password with special chars
		page.reload();
		page.locator("(//input[@class='form-control'])[1]").fill(userName);
		page.locator("(//input[@class='form-control'])[2]").fill(longSpecialChars);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText(invalidUsernamePasswordLoginStatus);

		// test 5, correct user and password
		page.reload();
		page.locator("(//input[@class='form-control'])[1]").fill(userName);
		page.locator("(//input[@class='form-control'])[2]").fill(passwordCorrect);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText("Welcome, " + userName + "!");

		// test 6, correct long username with special chars, correct password
		page.reload();
		page.locator("(//input[@class='form-control'])[1]").fill(longSpecialChars);
		page.locator("(//input[@class='form-control'])[2]").fill(passwordCorrect);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText("Welcome, " + longSpecialChars + "!");

		// test 7, short username
		page.reload();
		page.locator("(//input[@class='form-control'])[1]").fill(shortUserName);
		page.locator("(//input[@class='form-control'])[2]").fill(passwordCorrect);
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText("Welcome, " + shortUserName + "!");

		// test 8, log out
		page.locator("#login").click();
		assertThat(page.locator("#loginstatus")).hasText(loggedOutLoginStatus);

		page.close();
		browser.close();
		playwright.close();
	}
	
//	private static void performLogin(Page page, String userName, String password, String expectedStatus) {
//        page.reload();
//        page.fill("(//input[@class='form-control'])[1]", userName);
//        page.fill("(//input[@class='form-control'])[2]", password);
//        page.click("#login");
//        assertThat(page.locator("#loginstatus")).hasText(expectedStatus);
//    }	
}

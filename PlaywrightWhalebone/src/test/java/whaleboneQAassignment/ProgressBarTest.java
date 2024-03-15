package whaleboneQAassignment;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class ProgressBarTest {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("http://uitestingplayground.com/");
			
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Progress Bar")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
//			page.getByText("75%", new Page.GetByTextOptions().setExact(true)).click();
			page.waitForSelector("div.progress-bar div[style='width: 75%;']", new Page.WaitForSelectorOptions());
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Stop")).click();

			page.close();
			browser.close();
			playwright.close();
		}
	}
}
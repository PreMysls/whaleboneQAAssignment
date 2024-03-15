package whaleboneQAassignment;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.io.IOException;

public class LoadDelayTest {
    public static void main(String[] args) throws IOException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        Double reasonableTime = 10000d;
        page.setDefaultTimeout(reasonableTime);

        page.navigate("http://uitestingplayground.com/loaddelay");

        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button Appearing After Delay")))
                .isVisible();

        page.close();
        browser.close();
        playwright.close();
    }
}
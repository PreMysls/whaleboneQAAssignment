package whaleboneQAassignment;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.microsoft.playwright.APIRequest;
//import com.microsoft.playwright.APIRequestContext;
//import com.microsoft.playwright.APIResponse;
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.options.AriaRole;
//import com.microsoft.playwright.BrowserType.LaunchOptions;
//import com.microsoft.playwright.ElementHandle;
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.*;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.net.URL;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NHLtest {
	public static void main(String[] args) {
		
//		try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = context.newPage();
//
//            // Navigate to the Canadiens roster page
//            page.navigate("https://www.nhl.com/canadiens/roster");
//
//            // Wait for the roster table to load
//            page.waitForSelector(".roster--full-table");
//
//            // Get all player rows
//            List<ElementHandle> playerRows = page.locator(".roster--full-table tbody tr").elements();
//
//            // Count Canadian and US players
//            int canadianPlayers = 0;
//            int usPlayers = 0;
//            for (ElementHandle row : playerRows) {
//                String playerNationality = row.locator("td").nth(3).innerText().trim();
//                if (playerNationality.equalsIgnoreCase("CAN")) {
//                    canadianPlayers++;
//                } else if (playerNationality.equalsIgnoreCase("USA")) {
//                    usPlayers++;
//                }
//            }
//
//            // Print the counts
//            System.out.println("Number of Canadian players: " + canadianPlayers);
//            System.out.println("Number of US players: " + usPlayers);
//
//            // Verify more Canadian players than US players
//            if (canadianPlayers > usPlayers) {
//                System.out.println("There are more Canadian players than players from the USA.");
//            } else {
//                System.out.println("There are not more Canadian players than players from the USA.");
//            }
//
//            // Close the browser
//            browser.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
	}
}

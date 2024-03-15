package whaleboneQAassignment;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class JsonParser {
    public static void main(String[] args) throws IOException {
        Playwright playwright = Playwright.create();
        APIRequest request = playwright.request();
        APIRequestContext requestContext = request.newContext();
        APIResponse apiResponse = requestContext.get("https://qa-assignment.dev1.whalebone.io/api/teams");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
        String jsonPrettyResponse = jsonResponse.toPrettyString();
        JSONObject jsonObject = new JSONObject(jsonPrettyResponse);
        JSONArray jsonTeams = jsonObject.getJSONArray("teams");
        List<Team> teamList = objectMapper.readValue(jsonTeams.toString(), new TypeReference<List<Team>>() {});
       
        // test1, verify number of teams
        assert jsonTeams.length() == 32;
        
        ListIterator<Team> listIterator = teamList.listIterator();
        int oldestTeamIndex = 0;
        int currentTeamIndex = 0;
        int oldestFounded = 2024;
        int countOfMetropolitanTeams = 0;

        while (listIterator.hasNext()) {
            currentTeamIndex = listIterator.nextIndex();
            if (teamList.get(currentTeamIndex).getFounded() < oldestFounded) {
                oldestFounded = teamList.get(currentTeamIndex).getFounded();
                oldestTeamIndex = currentTeamIndex;
            }
            if (teamList.get(currentTeamIndex).getDivision().getId() == 2) {
                countOfMetropolitanTeams++;
            }
            listIterator.next();
        }

        // test2, verify that oldest team is Montreal Canadians
        assert teamList.get(oldestTeamIndex).getName().equals("Montreal Canadiens");
        
        //test3, verify there's a city with more than 1 team and verify names of those teams
       
        //test4, verify there are 8 teams in the Metropolitan division and verify them by their names
        assert countOfMetropolitanTeams == 8;
    }
}

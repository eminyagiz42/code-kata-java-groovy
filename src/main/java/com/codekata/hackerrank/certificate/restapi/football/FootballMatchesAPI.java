package com.codekata.hackerrank.certificate.restapi.football;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class FootballMatchesAPI {


    public static void main(String[] args) throws IOException, ParseException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String team = bufferedReader.readLine();
        int year = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.getTotalGoals(team, year);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */
        //String team = "Barcelona"; int year = 2011; // Expected output: 35
        String team = "Chelsea";
        int year = 2014; // Expected output: 92
        int result = Result.getTotalGoals2(team, year);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */
    private static final JSONParser parser = new JSONParser();
    private static final String HACKERRANK_URL = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&%s=%s&page=%d";

    public static int getTotalGoals(String team, int year) {
        int sum = 0;
        try {
            int page1 = 1; //page must start from 1
            String teamSide = "team1";
            sum += getGoalsPerPage(HACKERRANK_URL, year, teamSide, team, page1, sum);

            teamSide = "team2";
            sum = getGoalsPerPage(HACKERRANK_URL, year, teamSide, team, page1, sum);

        } catch (Exception ex) {
            System.out.println("An exception occurred");
        }

        return sum;
    }

    public static int getGoalsPerPage(String url, int year, String teamSide, String team, int page, int sum)
            throws ParseException, IOException {

        final String teamGoalsId = teamSide.concat("goals");
        final String hackerrankURL = String.format(url, year, teamSide, team, page);
        final String response = getResponse(hackerrankURL);
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        int totalPages = Integer.parseInt(String.valueOf(jsonObject.get("total_pages")));
        JSONArray dataArray = (JSONArray) jsonObject.get("data");
        for (Object o : dataArray) {
            JSONObject obj = (JSONObject) o;
            String goals = (String) obj.get(teamGoalsId);
            sum += Integer.parseInt(goals);
        }

        System.out.println("page:" + page + " sum:" + sum);
        return page == totalPages ? sum : getGoalsPerPage(url, year, teamSide, team, page + 1, sum);
    }

    private static String getResponse(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");

        int status = con.getResponseCode();
        if (status < 200 || status >= 300) {
            throw new IOException("Error in reading data with status:" + status);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();
        while ((response = br.readLine()) != null) {
            sb.append(response);
        }

        br.close();
        con.disconnect();

        return sb.toString();
    }

    public static int getTotalGoals2(String team, int year) throws IOException { // This solution solves this problem,
                                                                                 // However, Hackerrank doesn't support jackson library
                                                                                 // Solution with Json Simple library is above.
        ObjectMapper objectMapper = new ObjectMapper();

        final int totalPages = getTotalPages(team, year);
        int page = 0;
        String teamSide = "team1";
        int sum = 0;

        boolean flagOnePassed = true;
        while (totalPages != page) {
            String hackerrankURL = String.format(HACKERRANK_URL, year, teamSide, team, ++page);
            String stringResponse = getResponse(hackerrankURL);
            FootballJsonResponse jsonResponse = objectMapper.readValue(stringResponse, FootballJsonResponse.class);

            for (int i = 0; i < jsonResponse.getData().size(); i++) {
                if (teamSide.equals("team1")) {
                    sum += jsonResponse.getData().get(i).getTeam1goals();
                } else if (teamSide.equals("team2")) {
                    sum += jsonResponse.getData().get(i).getTeam2goals();
                }
            }
            //System.out.println("page:" + page + " sum:" + sum);

            //Call the same api with team Side "team2"
            if (page == totalPages) {
                teamSide = "team2";
                if (flagOnePassed) {
                    page = 0;
                    flagOnePassed = false;
                }
            }
        }

        return sum;
    }


    public static int getTotalPages(String team, int year) throws IOException {
        String hackerrankURL = String.format(HACKERRANK_URL, year, "team1", team, 1);
        String team1Response = getResponse(hackerrankURL);
        ObjectMapper objectMapper = new ObjectMapper();
        FootballJsonResponse jsonResponse = objectMapper.readValue(team1Response, FootballJsonResponse.class);
        return jsonResponse.getTotalPages();
    }
}

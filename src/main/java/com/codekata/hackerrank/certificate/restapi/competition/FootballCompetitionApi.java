package com.codekata.hackerrank.certificate.restapi.competition;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class FootballCompetitionApi {

    //TODO Review Later

    //https://dailyjournal.gitbook.io/solutions/v/hackerrank-solutions/certify/rest-api-intermediate#id-2-rest-api-football-competition-winners-goals

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String competition = bufferedReader.readLine();
        int year = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.getWinnerTotalGoals(competition, year);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        String competition = "UEFA Champions League";
        int year = 2011; // expected output: 28
        int result = Result.getWinnerTotalGoals(competition, year);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'getWinnerTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING competition
     *  2. INTEGER year
     */
    private static final String HACKERRANK_COMPETITION_URL = "https://jsonmock.hackerrank.com/api/football_competitions?name=%s&year=%d";
    private static final String HACKERRANK_MATCHES_URL = "https://jsonmock.hackerrank.com/api/football_matches?competition=%s&year=%d&%s=%s&page=%d";

    public static int getWinnerTotalGoals(String competition, int year) {

        int sum = 0;

        try {
            competition = URLEncoder.encode(competition, StandardCharsets.UTF_8.toString());
            String team = getWinner(competition, year); // Chelsea
            int page1 = 1; //page must start from 1
            String teamSide = "team1";
            sum += getGoalsPerPage(HACKERRANK_MATCHES_URL, competition, year, teamSide, team, sum, page1); //21

            page1 = 1;
            teamSide = "team2";
            sum = getGoalsPerPage(HACKERRANK_MATCHES_URL, competition, year, teamSide, team, sum, page1); // 21 + 7

        } catch (Exception ex) {
            System.out.println("An occurred in API Calls");
        }

        return sum;
    }

    public static String getWinner(String competition, int year) throws IOException, ParseException {

        final String hackerrankURL = String.format(HACKERRANK_COMPETITION_URL, competition, year);
        final String response = getResponse(hackerrankURL);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        JSONArray dataArray = (JSONArray) jsonObject.get("data");
        JSONObject obj = (JSONObject) dataArray.get(0);

        return (String) obj.get("winner");
    }


    private static int getGoalsPerPage(String url, String competition, int year, String teamSide, String team, int sum, int page)
            throws ParseException, IOException {

        final String teamGoalsId = teamSide.concat("goals");
        final String hackerrankURL = String.format(url, competition, year, teamSide, team, page);
        final String response = getResponse(hackerrankURL);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        int totalPages = Integer.parseInt(String.valueOf(jsonObject.get("total_pages")));
        JSONArray dataArray = (JSONArray) jsonObject.get("data");
        for (Object o : dataArray) {
            JSONObject obj = (JSONObject) o;
            String goals = (String) obj.get(teamGoalsId);
            sum += Integer.parseInt(goals);
        }

        //System.out.println("page:" + page + " sum:" + sum);
        return page == totalPages ? sum : getGoalsPerPage(url, competition, year, teamSide, team, sum, page + 1);
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
}

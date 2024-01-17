package com.codekata.hackerrank.certificate.software.ip;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class IpTracker {
    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String ip = bufferedReader.readLine();
        String result = Result.ipTracker(ip);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        String ip = "172.217.20.46"; //expected output: US
        String result = Result.ipTracker(ip);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'ipTracker' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/ip?ip=<ip>
     *
     * The function is expected to return a STRING.
     * The function accepts a singe parameter ip.
     *
     * In case of no ip record, return string 'No Result Found'
     */
    public static String ipTracker(String ip) throws IOException {

        //String myJsonString = "{\"page\":1,\"per_page\":10,\"total\":1,\"total_pages\":1,\"data\":[{\"ip\":\"172.217.20.46\",\"country\":\"US\"}]}";

        final String hackerrankURL = "https://jsonmock.hackerrank.com/api/ip?ip=".concat(ip);
        final String ipTrackerResponse = getIpTrackerResponse(hackerrankURL);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonResponse jsonResponse = objectMapper.readValue(ipTrackerResponse, JsonResponse.class);

        try {
            return jsonResponse.getData().get(0).getCountry();
        } catch (Exception ex) {
            return "No Result Found";
        }
    }


    private static String getIpTrackerResponse(String endpoint) throws IOException {
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

class JsonResponse {

    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<Datum> data;

    public ArrayList<Datum> getData() {
        return data;
    }
}

class Datum {
    public String ip;
    public String country;

    public String getCountry() {
        return country;
    }
}



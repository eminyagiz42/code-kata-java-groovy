package com.codekata.hackerrank.certificate.restapi.football;

import java.util.ArrayList;

public class FootballJsonResponse {

        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private ArrayList<Datum> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public ArrayList<Datum> getData() {
            return data;
        }

    public int getTotalPages() {
        return total_pages;
    }
}

    class Datum {
        private String competition;
        private String year;
        private String round;
        private String team1;
        private String team2;
        private int team1goals;
        private int team2goals;

        public String getCompetition() {
            return competition;
        }

        public void setCompetition(String competition) {
            this.competition = competition;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getRound() {
            return round;
        }

        public void setRound(String round) {
            this.round = round;
        }

        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }

        public int getTeam1goals() {
            return team1goals;
        }

        public void setTeam1goals(int team1goals) {
            this.team1goals = team1goals;
        }

        public int getTeam2goals() {
            return team2goals;
        }

        public void setTeam2goals(int team2goals) {
            this.team2goals = team2goals;
        }
    }

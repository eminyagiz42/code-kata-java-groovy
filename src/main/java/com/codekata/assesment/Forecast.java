package com.codekata.assesment;

public class Forecast {

    public int temperature;
    public int pressure;

    public static void changeTheString(String wheater) {
        wheater = "sunny";
    }

    public static void changeTheArray(String [] array) {
        array[1] = "Sunday";
    }

    public static void changeTheObj(Forecast forecast) {
        forecast.temperature = 35;
    }

    public static void main(String[] args) {
        String wh = "rainy";
        changeTheString(wh);
        System.out.println("the weather is " + wh);

        String [] days = new String[]  {"monday", "friday" };
        changeTheArray(days);
        System.out.println("the days are " + days[0] + " and " + days[1]);

        Forecast forecast = new Forecast();
        forecast.temperature = 123;
        forecast.pressure = 100;
        changeTheObj(forecast);
        System.out.println("the forecast is " + forecast.temperature);
    }

    /* Output:
    the weather is rainy
    the days are monday and Sunday
    the forecast is 35
     */

    interface ReadWriteDouble{
        double read();
        void writeDown(double value);
    }


}

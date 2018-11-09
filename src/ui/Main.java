package ui;


import logbook.CardioExercise;
import logbook.Exercise;
import logbook.ResistanceExercise;
import logbook.Workout;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static logbook.Intensity.LOW;
import static ui.JsonReader.readJsonFromUrl;


public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {

        BufferedReader br = null;

        try {
            String apikey = "47358c88145ee6d6db5ce5ce36f5f216";
            String vancouverweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
            String theURL = vancouverweatherquery + apikey; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            List<String> weatherlines = splitOnComma(sb.toString());
            PrintWriter writer = new PrintWriter("weatherdata", "UTF-8");
            for (String l: weatherlines) {
                writer.println(l);
            }
            writer.close();

//            printCityAndCountry(weatherlines.get(23), weatherlines.get(19));
            printWeatherDescription(weatherlines.get(4));


            JSONObject json = readJsonFromUrl("https://favqs.com/api/qotd");
//            System.out.println(json.toString());

//            System.out.println(json.get("quote"));
            List<String> lines = splitOnComma(json.toString());

            PrintWriter writer2 = new PrintWriter("quotedata", "UTF-8");
            for (String l: lines) {
                writer2.println(l);
            }
            writer2.close();

            printQuotationAndAuthor(lines.get(7), lines.get(2));





            // 4 main, 5 description, 14 wind, country 20, city 24, total 25 lines



//            System.out.println(sb);


        } finally {

            if (br != null) {
                br.close();
            }
        }
        UserInterface ui = new UserInterface();
        //   SwingUtilities.invokeLater(ui);


        try {
            ui.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public static ArrayList<String> splitOnQuotation(String line) {
        String[] splits = line.split("\"");
        return new ArrayList<>(Arrays.asList(splits));
    }

    /*public static void printCityAndCountry(String city, String country) {
        String cleanedcity = city.substring(4,7);           // 9 and 17
        String cleanedcountry = country.substring(10,12);

        System.out.println(cleanedcity + ", " + cleanedcountry);


    }*/

    public static void printWeatherDescription(String weather) {
        List<String> lines = splitOnQuotation(weather);
        String forecast = "";
        for (String line: lines) {
            forecast += line;
        }

        forecast = forecast.substring(12);

        System.out.println("Forecast: " + forecast);

        if (forecast.contains("cloud")) {
            System.out.println("Cloudy with a chance of meatballs");
        } else if (forecast.contains("clear")) {
            System.out.println("Great day for a run!");
        } else if (forecast.contains("rain") || forecast.contains("drizzle")) {
            System.out.println("Better stay inside!");
        }
        System.out.println();




    }

    public static void printQuotationAndAuthor(String quote, String author) {
        String cleanedAuthor = removeCommas(author);
        cleanedAuthor = cleanedAuthor.substring(7);


        String cleanedQuote = quote.substring(7);

        System.out.println(cleanedQuote);
        System.out.println("-" + cleanedAuthor);
        System.out.println();
    }

    public static String removeCommas(String str) {
        List<String> lines = splitOnQuotation(str);
        String cleanedString = "";
        for (String line:lines) {
            cleanedString += line;
        }

        return cleanedString;
    }



}




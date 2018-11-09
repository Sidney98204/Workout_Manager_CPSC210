package ui;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ui.JsonReader.readJsonFromUrl;

public class ReadWebPageEx {

    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://favqs.com/api/qotd");
        System.out.println(json.toString());
        System.out.println(json.get("quote"));
        List<String> lines = splitOnComma(json.toString());

        PrintWriter writer = new PrintWriter("quotedata", "UTF-8");
        for (String l: lines) {
            writer.println(l);
        }
        writer.close();



        // private, "favorites_count, "author, "dialogue" upvotescount, authorpermalink, id, body, url, tags, downvote count
    }

    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public static ArrayList<String> splitOnQuotation(String line) {
        String[] splits = line.split("\"");
        return new ArrayList<>(Arrays.asList(splits));
    }
}

package com.example.transfunc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class translator {
    public String TranslateText(String inputText) throws Exception {
        String urlStr = "https://api.mymemory.translated.net/get?q=" + inputText + "&langpair=hi|en";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsonResponse = new JSONObject(response.toString());
        String translatedText = jsonResponse.getJSONObject("responseData").getString("translatedText");
        return translatedText;
    }

}
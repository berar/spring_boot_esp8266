package io.berar.esp8266.service;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aleks_000 on 7/4/2016.
 */
public class ESP8266Service {

    private static final String URL = "http://192.168.0.11/";

    public static void switchIt(boolean turnOn) throws Exception {
        handleESP8266(turnOn);
        if (turnOn) {
            new Thread(() -> {
                try {
                    Thread.sleep(5 * 1000);
                    ESP8266Service.handleESP8266(false);
                } catch (Exception e) {}
            }).start();
        }
    }

    private static void handleESP8266(boolean turnOn) throws Exception {
        String url = URL + "?pin=" + (turnOn ? "ON" : "OFF");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode();
    }
}

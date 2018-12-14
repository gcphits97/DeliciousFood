package com.example.simplifyv2.deliciousfood.Server;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadJSONDonHang extends AsyncTask<String, Void, String> {
    String path;
    StringBuilder data;
    public DownloadJSONDonHang(String path) {
        this.path = path;
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = "";
            data = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}

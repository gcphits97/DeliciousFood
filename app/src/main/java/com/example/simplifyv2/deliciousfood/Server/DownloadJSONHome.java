package com.example.simplifyv2.deliciousfood.Server;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownloadJSONHome extends AsyncTask<String, Void, String> {
    StringBuilder data;
    String path = "";
    List<HashMap<String, String>> attributes;
    String key = "";
    String value = "";

    public DownloadJSONHome(String path, List<HashMap<String, String>> attributes) {
        this.path = path;
        this.attributes = attributes;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                /*
                set phương thức post
                mở đường dẫn dữ liệu đi ra
                mở đường dẫn dữ liệu đi vào
                 */
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
                /*
                get đường dẫn
                 */
            Uri.Builder uri = new Uri.Builder();

            int count = attributes.size();
            for (int i = 0; i < count; i++) {
                for (Map.Entry<String, String> values : attributes.get(i).entrySet()) {
                    key = values.getKey();
                    value = values.getValue();
                }
                uri.appendQueryParameter(key, value);
            }
            String sentData = uri.build().getEncodedQuery();
                /*
                mở luồng ra và ghi dữ liệu luồng ra
                 */
            OutputStream outputStream = connection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(sentData);
            bufferedWriter.flush();
                /*
                đóng luồng
                 */
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
                /*
                mở kết nối
                 */
            connection.connect();
                /*
                đọc luồng dữ liệu vào
                 */
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            data = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
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

package com.vapps.uvpa;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  DownloadData extends AppCompatActivity {

    ArrayList<String> phoneURLs = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_data);

        for (int i = 1 ; i <2 ; ++i )

        { newlist(i);}


    }




public void newlist(int i) {

    DownloadTask task = new DownloadTask();
    String result = null;

    try {



        result = task.execute("https://www.gsmarena.com/xiaomi-phones-f-80-0-p"+i+".php").get();

        String[] splitResult = result.split("<div class=\"review-nav pullNeg col pushT10 \">");

        Pattern p = Pattern.compile("<strong><span>(.*?)</span></strong>");
        Matcher m = p.matcher(splitResult[0]);

        while (m.find()) {

            phoneURLs.add(m.group(1));

        }



    } catch (InterruptedException | ExecutionException e1) {
        e1.printStackTrace();
    }


    Log.i("META",phoneURLs.toString());
    phoneURLs.clear();


}









    class DownloadTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection)url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();
                }

                return result;

            }
            catch (Exception e) {

                e.printStackTrace();

            }

            return null;
        }
    }}




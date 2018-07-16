package com.vapps.uvpa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;



class DownloadIconInBackground extends AsyncTask<String,Void,Bitmap>
{



    @Override
    protected Bitmap doInBackground(String... urls)
    {


        try {
            URL url = new URL(urls[0]);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            return bitmap;



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        Log.i("MEta",bitmap.toString());



        super.onPostExecute(bitmap);
    }
}


public class UserSymbol extends AppCompatActivity {

    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_symbol);

        imageView = findViewById(R.id.icondp);


        try {


            DownloadIconInBackground task = new DownloadIconInBackground();

            Bitmap bitmap = task.execute("https://scontent.fbom4-2.fna.fbcdn.net/v/t31.0-8/21272680_1197433690361703_4957321854011672867_o.jpg?_nc_cat=0&oh=ba85ff633e756f222cff40a151c89647&oe=5B50AD88").get();

           imageView.setImageBitmap(bitmap);


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

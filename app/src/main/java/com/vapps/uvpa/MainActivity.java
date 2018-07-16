package com.vapps.uvpa;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {



    private Spinner spinner;
    private Spinner seriesSearch;

    private Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Login = (Button)findViewById(R.id.login_button);

        spinner = findViewById(R.id.spinner_search);

        seriesSearch = findViewById(R.id.spinner_seriesSearch);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.brand_names,R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        PhoneDataDbHelper phoneDataDbHelper = new PhoneDataDbHelper(this);

        SQLiteDatabase sqLiteDatabase = phoneDataDbHelper.getWritableDatabase();

        InputStream inputStream = getResources().openRawResource(R.raw.phonedat);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String Phones="";
        try {
             Phones = bufferedReader.readLine();


        } catch (IOException e)
        {
            e.printStackTrace();
        }


        String SplittedPhones[] = Phones.split("VANIKPHONES");

        String SamsungPhones[] = SplittedPhones[1].split(",");

        Log.i("METAD",SplittedPhones[0]);

        Log.i(" METAD5",SamsungPhones[0]);

        ContentValues  contentValues = new ContentValues();

        for (String each : SamsungPhones)
        {
            contentValues.put(PhoneDataContract.PhonedData.COLUNMN_SAMSUNG,each);

            contentValues.put(PhoneDataContract.PhonedData.COLUNMN_MI,0);


            sqLiteDatabase.insert(PhoneDataContract.PhonedData.TABLE_NAME, null ,contentValues);

            contentValues = new ContentValues();
        }


        String XiaomiPhones[] = SplittedPhones[4].split(",");





        Cursor cursor = sqLiteDatabase.query
                (

                PhoneDataContract.PhonedData.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );


        int count = cursor.getCount();

        Log.i("METAD3", Integer.toString(count));

        List<String> seriesNames = new ArrayList<String>();

        while(cursor.moveToNext())
        {


               String seriesName= cursor.getString(cursor.getColumnIndex(PhoneDataContract.PhonedData.COLUNMN_SAMSUNG));


            seriesNames.add(seriesName);

        }


        Log.i("METAD2",seriesNames.toString());
        cursor.close();

      ArrayAdapter<String> adapter1 =  new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,seriesNames);

              seriesSearch.setAdapter(adapter1);


    }


    public void Login(View view)
    {

        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();

    }



}

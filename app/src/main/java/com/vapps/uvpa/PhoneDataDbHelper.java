package com.vapps.uvpa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ' on 15-05-2018.
 */


public class PhoneDataDbHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "phoneData.db";

    public static final int DATABASE_VERSION = 1;

    public PhoneDataDbHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQ_CREATE_PHONE_TABLE = "CREATE TABLE " + PhoneDataContract.PhonedData.TABLE_NAME + " (" +
                PhoneDataContract.PhonedData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PhoneDataContract.PhonedData.COLUNMN_SAMSUNG + " TEXT, " +
                PhoneDataContract.PhonedData.COLUNMN_MI + " TEXT )";


        sqLiteDatabase.execSQL(SQ_CREATE_PHONE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ PhoneDataContract.PhonedData.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }



}

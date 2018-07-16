package com.vapps.uvpa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Payment_details extends AppCompatActivity {

    private CardForm cardForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);


           cardForm = findViewById(R.id.card_form);



    }
}

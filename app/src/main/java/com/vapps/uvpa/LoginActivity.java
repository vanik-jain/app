package com.vapps.uvpa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import java.util.List;


public class LoginActivity extends AppCompatActivity {



Button Payment;


      /*
          // if (view.getId() == R.id.changeSignupModeTextView) {

       //         Button signupButton = (Button) findViewById(R.id.signupButton);

                if (signUpModeActive) {

                    signUpModeActive = false;
                  //  signupButton.setText("Login");
                    changeSignupModeTextView.setText("Or, Signup");

                } else {

                    signUpModeActive = true;
                   // signupButton.setText("Signup");
                    changeSignupModeTextView.setText("Or, Login");

                }

            }



        public void signUp(View view) {

            EditText usernameEditText = (EditText) findViewById(R.id.editText);

            EditText passwordEditText = (EditText) findViewById(R.id.editText2);

            if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {

                Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();

            } else {

                if (signUpModeActive) {

                    ParseUser user = new ParseUser();

                    user.setUsername(usernameEditText.getText().toString());
                    user.setPassword(passwordEditText.getText().toString());

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {

                                Log.i("Signup", "Successful");

                            } else {

                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                } else {

                    ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if (user != null) {

                                Log.i("Signup", "Login successful");

                            } else {

                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                            }


                        }
                    });


                }
            }


        }
*/

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
          //  changeSignupModeTextView = (TextView) findViewById(R.id.changeSignupModeTextView);

        //    changeSignupModeTextView.setOnClickListener(this);







            Parse.enableLocalDatastore(this);





            Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                    .applicationId("484408b35caef616b69b3586abeadce608c74b7f")
                    .clientKey("a5662c611f3cc32b674a8396051151ee649fcbd7")
                    .server("http://18.188.126.143:80/parse/")
                    .build()


            );



            ParseACL defaultACL = new ParseACL();
            defaultACL.setPublicReadAccess(true);
            defaultACL.setPublicWriteAccess(true);
            ParseACL.setDefaultACL(defaultACL, true);
            ParseAnalytics.trackAppOpenedInBackground(getIntent());


        }


        public void Payment(View view)
        {

            startActivity(new Intent(LoginActivity.this,Payment_details.class));
            finish();

        }



    }




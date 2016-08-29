package com.firstone.collegeeventsnotifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    Boolean isInternetPresent = false;
    CheckInternet cc;
    private Button button;
    private Button button2;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        // creating connection detector class instance
        cc = new CheckInternet(getApplicationContext());
        // get Internet status
        isInternetPresent = cc.isConnectingToInternet();
        if (!isInternetPresent) {
            showAToast("Internet connection not available");

        }


        if(isInternetPresent){

            button.setOnClickListener(new View.OnClickListener() {



                public void onClick(View view) {

                    Intent i = new Intent(getApplicationContext(),
                            Register.class);
                    startActivity(i);
                    finish();
                }
            });


            button2.setOnClickListener(new View.OnClickListener() {



                public void onClick(View view) {

                    Intent i = new Intent(getApplicationContext(),
                            LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    else
        { showAToast("Please Connect to Internet and Restart App");

        }}


    public void showAToast (String st){
        try{ toast.getView().isShown();
            toast.setText(st);
        } catch (Exception e) {
            toast = Toast.makeText(getApplicationContext(),st,toast.LENGTH_SHORT);
        }
        toast.show();  //finally display it
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}

package com.thuya.exemple.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    public final static String Greeting = "Main Greeting";
   // public final static String orgActivityCaller = null;

    private Button bSayHello = null;
    private Button bCallAct3 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSayHello = (Button) findViewById(R.id.button);

        bSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra(Greeting, "Hi Activity 2 from Main");
               // intent.putExtra(orgActivityCaller, "MainActivity");   //can send only one, use Parcel for more

                startActivityForResult(intent,1);
            }
        });


        bCallAct3 = (Button) findViewById(R.id.callA3);

        bCallAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                intent.putExtra(Greeting, "Hey Activity 3 from Main");

                startActivity(intent);
            }
        });

    }



}
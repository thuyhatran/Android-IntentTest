package com.thuya.exemple.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ThirdActivity extends Activity {

    private Button bCallA2 = null;
    public final static String messageFromA3 = "from Third";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();

        String fromMain = intent.getStringExtra(MainActivity.Greeting);

        TextView text = (TextView) findViewById(R.id.textViewA3Receiver);

        text.setText(fromMain);

        bCallA2 = (Button) findViewById(R.id.callA2);

        bCallA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);

                intent.putExtra(messageFromA3, "Hey Second from Third");
               // intent.putExtra(orgActivityCaller, "ThirdActivity");

                startActivityForResult(intent,3);
            }
        });


    }
}

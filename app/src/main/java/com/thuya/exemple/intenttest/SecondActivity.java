package com.thuya.exemple.intenttest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private Button returnMain = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent i = getIntent();
       // String activityCaller =  i.getStringExtra("orgActivityCaller");
       // ComponentName componentName = this.getCallingActivity();

        String callingClassName = this.getCallingActivity().getShortClassName();
        Toast.makeText(getApplicationContext(),callingClassName, Toast.LENGTH_SHORT).show();

        String message;
        if (callingClassName.equalsIgnoreCase(".MainActivity")) {
             message = i.getStringExtra(MainActivity.Greeting);
        }else{ //from ThirdActivity
            message = i.getStringExtra(ThirdActivity.messageFromA3);
        }

        TextView text = (TextView) findViewById(R.id.textView2Receiver);

        text.setText(message);

        returnMain = (Button) findViewById(R.id.button2);

        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });



    }

}

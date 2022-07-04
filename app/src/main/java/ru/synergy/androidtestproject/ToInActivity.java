package ru.synergy.androidtestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ToInActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_in);

        TextView tv = (TextView) findViewById(R.id.tv);
       String str = getIntent().getStringExtra("et");
       tv.setText(str);
    }
}
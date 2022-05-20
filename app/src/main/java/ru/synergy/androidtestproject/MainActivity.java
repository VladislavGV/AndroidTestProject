package ru.synergy.androidtestproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);
        textView.setText("Hello Android!");
        textView.setTextSize(22);
        setContentView(textView);

    }

}
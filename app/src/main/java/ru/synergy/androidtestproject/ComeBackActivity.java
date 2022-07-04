package ru.synergy.androidtestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class ComeBackActivity extends AppCompatActivity {

    EditText textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back);

        textView = (EditText) findViewById(R.id.backtv);
        button = (Button) findViewById(R.id.sendback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); // создали Intent
                intent.putExtra("tv", textView.getText().toString()); // положили дополнительные данные (из textView текст и преобразовали в String)
                setResult(RESULT_OK, intent); // Intent выставили как результат нашей активности
                finish();
            }
        });


    }
}
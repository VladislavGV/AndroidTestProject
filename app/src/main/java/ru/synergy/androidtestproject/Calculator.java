package ru.synergy.androidtestproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

private  static final String LogcatTag = "CALCULATOR_ACTIVITY";
private  static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm oncreate(), and I'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);


/*            //Context training
        TextView textView = new TextView(this); //context данного Activity
        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);

            // доступ из класса Activity  -- наследник Context
        getSystemService(LAYOUT_INFLATER_SERVICE);

            // Shared prefs доступ с использованием контекста приложения
        SharePreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        ////*/

        //// Intent - посылка, намерение



        //




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswer();
                Intent i = new Intent(Calculator.this, MainActivity.class);   // написать письмо, прописывается в любом месте кода
                startActivity(i); // отправляет письмо, прописывается в месте вызова активности
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I'm onStart() and I'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I'm onStop and I'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I'm onDestroy and I'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I'm onPause and I'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I'm onResume and I'm started");
    }

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.substract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton devide = (RadioButton) findViewById(R.id.devide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);


        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been founded");

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "numone is: " + numone + " ; "+" numtwo is: " + numtwo);

        float solution = 0;

        if (add.isChecked()) {
            Log.d(LogcatTag, "Operation is add");
            solution = numone + numtwo;
        }
        if (sub.isChecked()) {
            Log.d(LogcatTag, "Operation is sub");
            solution = numone - numtwo;
        }
        if (multiply.isChecked()) {
            Log.d(LogcatTag, "Operation is multiply");
            solution = numone * numtwo;
        }
        if (devide.isChecked()) {
            Log.d(LogcatTag, "Operation is devide");
            if (numtwo == 0) {
                Toast.makeText(this, "Number cannot be zero", Toast.LENGTH_SHORT);
                return;
            }
            solution = numone / numtwo;
        }

        Log.d(LogcatTag, "The result of operation is: " + solution);



        answer.setText("The answer is " + solution);


       /* Context contextApp = getApplicationContext();
        Context context = getBaseContext();*/


    }

}


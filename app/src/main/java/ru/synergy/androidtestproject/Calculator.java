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

import java.io.IOException;

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
                try {
                    calculateAnswer();
                }
                /*catch (IOException e){
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }
                catch (ArithmeticException e){
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }*/
                catch (Exception e){

                        // прерывание
/*                    e.printStackTrace();
                    Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    finish();*/

                    //восстановление
                    e.printStackTrace(); //всегда прописывается, чтобы дать понять другим разработчикам, почему здесь выпадает ошибка
                    // e.printStackTrace(new PrintWriter());
                     // e.toString();
                    Toast.makeText(Calculator.this, e.getMessage() + " of class"+ e.getClass(), Toast.LENGTH_LONG).show();
                    dropFields(); // сброс полей

                    // e.getClass();


                }
                Intent i = new Intent(Calculator.this, MainActivity.class);   // написать письмо, прописывается в любом месте кода
              // startActivity(i); // отправляет письмо, прописывается в месте вызова активности
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

    private void dropFields() {
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

        answer.setText("Now we have problems. Try again later.");
    }

    private void calculateAnswer() throws ArithmeticException, IOException {
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

        // обработка исключений

 /*       try {
           // int a = 25 / 0;
            throw new ArithmeticException("I am generated exception");
        } catch (ArithmeticException e){
            Toast.makeText(this,"There is a problem inside the app", Toast.LENGTH_SHORT).show();
            finish();
        }*/


        float numone = 0;
        float numtwo = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();
        if(!num1.equals("") && num1 != null) {
        numone = Integer.parseInt(numOne.getText().toString());
        }
        if(!num2.equals("") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }


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
           /* if (numtwo == 0) {
                Toast.makeText(this, "Number cannot be zero", Toast.LENGTH_SHORT);
                return;
            }*/
            solution = numone / numtwo;
        }

        Log.d(LogcatTag, "The result of operation is: " + solution);



        answer.setText("The answer is " + solution);

        switch( (int) (Math.random()*3)) {
            case 0 : throw new ArithmeticException("I am generated arithmetical exception");
            case 1 : throw new IOException("I am generated ioexception");

        }


       /* Context contextApp = getApplicationContext();
        Context context = getBaseContext();*/

        /*throwable - класс!!!
                Exception - наследник

        RunTimeException - очень близки по своей логике к Error.
        IndexOutOfBoundsException - выход из длины массива, не должно так быть.
                ArithmeticException - ошибка арифметических вычислений (перезапуск программы)
        IllegalArgumentException - неправильно переданный параметр(метод, процедура, функция)
        NumberFormatException - неправильный формат ввода чисел


        IOException (input-out Exception) -  стоит всегда обрабатывать.
        SocketException - не смошли наш порт для получения данных. (нет доступа к интернету, невозможно работать)
        FileNotFoundException - отсутствие файла по пути запроса



        Error - ошибки, возникающие в рантайме, не проверяется ошибка, смерть приложения
        OutOfMemoryError - закончилась памятьб нет памяти, чтобы приложение работалоб нужно думать как уменьшить память.
                StackOverFlowError - ошибка переполнения int (32 бита),число больше, чем разрядная сетка, невалидное число.
                LinkageError - ошибка линковки, невозможно бороться разработчикам*/


        // FINISHED LESSON 34


    }

}


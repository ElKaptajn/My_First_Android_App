package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView logoText;
    private EditText inputText;
    private TextView calAnswer;
    private EditText calculatorString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoText = findViewById(R.id.logoText);
        inputText = findViewById(R.id.inputText);
        calAnswer = findViewById(R.id.calAnswer);
        calculatorString = findViewById(R.id.calculatorString);
    }

    public void helloWorldBtnPressed(View view) {
        logoText.setText(inputText.getText().toString());
    }

    public void page2Pressed(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    public void calculator(View view) {

        int result = 0;

        String calString = calculatorString.getText().toString();

        if(calString.contains("+")){
            String[] calArray = calString.split("\\+");
            int numberOne =Integer.parseInt(calArray[0]);
            int numberTwo =Integer.parseInt(calArray[1]);
            result = numberOne +  numberTwo;
        }else if(calString.contains("*")){
            String[] calArray = calString.split("\\*");
            int numberOne =Integer.parseInt(calArray[0]);
            int numberTwo =Integer.parseInt(calArray[1]);
            result = numberOne *  numberTwo;
        }else if (calString.contains("-")){
            String[] calArray = calString.split("-");
            int numberOne =Integer.parseInt(calArray[0]);
            int numberTwo =Integer.parseInt(calArray[1]);
            result = numberOne -  numberTwo;
        }else if (calString.contains("/")){
            String[] calArray = calString.split("/");
            int numberOne =Integer.parseInt(calArray[0]);
            int numberTwo =Integer.parseInt(calArray[1]);
            result = numberOne /  numberTwo;
        }else{
            result = 0;
        }

        calAnswer.setText("Result: " + result);
    }
}
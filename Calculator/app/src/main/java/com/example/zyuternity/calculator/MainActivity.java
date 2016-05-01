package com.example.zyuternity.calculator;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewScreen;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonAddition;
    Button buttonSubtraction;
    Button buttonMultiplication;
    Button buttonDivision;
    Button buttonPoint;
    Button buttonEquals;
    Button buttonDelete;
    String stringScreen = "";
    String stringTemp = "";
    Vector<Double> vector = new Vector<Double>();
    String stringOperator = "";
    double temp;
    StringBuilder stringBuilder;
    boolean checkCaculated = false;
    DecimalFormat numberFormat = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidgets();
    }

    public void setWidgets(){
        textViewScreen = (TextView) findViewById(R.id.textViewScreen);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSubtraction = (Button) findViewById(R.id.buttonSubtraction);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);


        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"0");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button1:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"1");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button2:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"2");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button3:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"3");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button4:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"4");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button5:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"5");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button6:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"6");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button7:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"7");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button8:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"8");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.button9:
                checkCaculated = false;
                textViewScreen.setText(stringScreen+"9");
                stringScreen = textViewScreen.getText().toString();
                break;
            case R.id.buttonAddition:
                if (checkCaculated == false){
                    stringScreen = checkOperatorText(stringScreen);
                    textViewScreen.setText(stringScreen+"+");
                    stringScreen = textViewScreen.getText().toString();
                } else {
                    textViewScreen.setText(stringTemp + "+");
                    stringScreen = textViewScreen.getText().toString();
                    checkCaculated = false;
                }
                break;
            case R.id.buttonSubtraction:
                if (checkCaculated == false){
                    stringScreen = checkOperatorText(stringScreen);
                    textViewScreen.setText(stringScreen+"-");
                    stringScreen = textViewScreen.getText().toString();
                } else {
                    textViewScreen.setText(stringTemp + "-");
                    stringScreen = textViewScreen.getText().toString();
                    checkCaculated = false;
                }
                break;
            case R.id.buttonMultiplication:
                if (checkCaculated == false){
                    stringScreen = checkOperatorText(stringScreen);
                    textViewScreen.setText(stringScreen+"×");
                    stringScreen = textViewScreen.getText().toString();
                } else {
                    textViewScreen.setText(stringTemp + "×");
                    stringScreen = textViewScreen.getText().toString();
                    checkCaculated = false;
                }
                break;
            case R.id.buttonDivision:
                if (checkCaculated == false){
                    stringScreen = checkOperatorText(stringScreen);
                    textViewScreen.setText(stringScreen+"÷");
                    stringScreen = textViewScreen.getText().toString();
                } else {
                    textViewScreen.setText(stringTemp + "÷");
                    stringScreen = textViewScreen.getText().toString();
                    checkCaculated = false;
                }
                break;
            case R.id.buttonDelete:
                if(stringScreen.length() != 0 && checkCaculated == false) {
                    stringScreen = stringScreen.substring(0, stringScreen.length()-1);
                    textViewScreen.setText(stringScreen);
                }
                else {
                    stringScreen = "";
                    textViewScreen.setText(stringScreen);
                    checkCaculated = false;
                }
                break;
            case R.id.buttonPoint:
                if (checkCaculated == false){
                    textViewScreen.setText(stringScreen+".");
                    stringScreen = textViewScreen.getText().toString();
                } else {
                    textViewScreen.setText(stringTemp + ".");
                    stringScreen = textViewScreen.getText().toString();
                    checkCaculated = false;
                }
                break;
            case R.id.buttonEquals:
                if (checkString() == true){
                    caculate();
                    textViewScreen.setText(String.valueOf(numberFormat.format(vector.get(0))));
                    stringScreen = "";
                    stringOperator = "";
                    vector.clear();
                    stringTemp = textViewScreen.getText().toString();
                }
                else Toast.makeText(MainActivity.this, "You are missing a number", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public String checkOperatorText(String stringScreen){
        if (stringScreen.endsWith("+")
                || stringScreen.endsWith("-")
                || stringScreen.endsWith("×")
                || stringScreen.endsWith("÷")){
            stringScreen = stringScreen.substring(0, stringScreen.length()-1);
        }
        return stringScreen;
    }

    public boolean checkString(){
        if (stringScreen.endsWith("+")
                || stringScreen.endsWith("-")
                || stringScreen.endsWith("×")
                || stringScreen.endsWith("÷")
                || stringScreen.startsWith("+")
                || stringScreen.startsWith("-")
                || stringScreen.startsWith("×")
                || stringScreen.startsWith("÷")){
            return false;
        }
        else return true;
    }

    public void caculate(){
        stringTemp = "";
            for (int i = 0; i < stringScreen.length(); i++){
                if (stringScreen.charAt(i) == '+'
                        || stringScreen.charAt(i) == '-'
                        || stringScreen.charAt(i) == '×'
                        || stringScreen.charAt(i) == '÷'){
                    temp = Double.parseDouble(stringTemp);
                    vector.add(temp);
                    stringTemp = "";
                    stringOperator += stringScreen.charAt(i);
                }
                if (i == stringScreen.length() - 1){
                    stringTemp += stringScreen.charAt(i);
                    temp = Double.parseDouble(stringTemp);
                    vector.add(temp);
                    stringTemp = "";
                }
                if (stringScreen.charAt(i) != '+'
                        && stringScreen.charAt(i) != '-'
                        && stringScreen.charAt(i) != '×'
                        && stringScreen.charAt(i) != '÷'
                        && i != stringScreen.length() - 1) {
                    stringTemp += stringScreen.charAt(i);
                }
            }

            stringBuilder = new StringBuilder(stringOperator);

            for (int i = 0; i < stringBuilder.length(); i++){

                if (stringBuilder.charAt(i) == '×'){
                    vector.set(i, vector.elementAt(i) * vector.elementAt(i+1));
                    vector.remove(i+1);
                    stringBuilder.deleteCharAt(i);
                    i -= 1;
                }

                else if (stringBuilder.charAt(i) == '÷'){
                    vector.set(i, vector.elementAt(i) / vector.elementAt(i+1));
                    vector.remove(i+1);
                    stringBuilder.deleteCharAt(i);
                    i -= 1;
                }
            }

            for (int i = 0; i < stringBuilder.length(); i++){

                if (stringBuilder.charAt(i) == '+'){
                    vector.set(i, vector.elementAt(i) + vector.elementAt(i+1));
                    vector.remove(i+1);
                    stringBuilder.deleteCharAt(i);
                    i -= 1;
                }

                else if (stringBuilder.charAt(i) == '-'){
                    vector.set(i, vector.elementAt(i) - vector.elementAt(i+1));
                    vector.remove(i+1);
                    stringBuilder.deleteCharAt(i);
                    i -= 1;
                }
            }
        checkCaculated = true;
//        }
    }
}

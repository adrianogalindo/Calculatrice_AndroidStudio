package com.example.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textField;
    float  numberA = 0;
    String math = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (TextView)findViewById(R.id.textView);
        textField.setText("");
    }

    public void buttonClick(View view){
        switch (view.getId()){
            case R.id.acButton:
                textField.setText("");
                numberA=0;
                math="";
                break;
            case R.id.plusButton:
                calculateNumbers("+");
                break;
            case R.id.minusButton:
                calculateNumbers("-");
                break;
            case R.id.diviseButton:
                calculateNumbers("/");
                break;
            case R.id.multiplyButton:
                calculateNumbers("*");
                break;
            case R.id.equalButton:
                showResults();
                break;
            default :
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }

    public void calculateNumbers(String tipomath){
        numberA = Float.parseFloat(textField.getText().toString());
        math = tipomath;
        textField.setText("");
    }


    public void getKeyboard(String str)
    {
        String ScrCurrent = textField.getText().toString();
        ScrCurrent += str;
        textField.setText(ScrCurrent);
    }


    public void showResults()
    {
        float numberB = Integer.parseInt(textField.getText().toString());
        float result = 0;
        if(math.equals("+"))
        {
            result = numberB + numberA;
        }
        if(math.equals("-"))
        {
            result = numberA - numberB;
        }
        if(math.equals("*"))
        {
            result = numberB * numberA;
        }
        if(math.equals("/"))
        {
            result = numberA / numberB;
        }
        textField.setText(String.valueOf(result));
    }


}

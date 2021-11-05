package com.example.threshholder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.threshholder.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayThreshold(View view){
        EditText editText = (EditText) findViewById(R.id.editTextTimeExposure);
        Double time_exposure = Double.valueOf(editText.getText().toString());
        editText = findViewById(R.id.editTextNpeople);
        Double N = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextCo);
        Double Co = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextV);
        Double V = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextPt);
        Double P2 = Double.valueOf(editText.getText().toString());


        double change_in_c2 = 0;
        change_in_c2 = time_exposure*N*P2/V;


        String message;
        if(change_in_c2 > Co){
            message = "above threshold";
        }else{
            message = "below threshold";
        }
        TextView tv = (TextView)findViewById(R.id.textViewOutput);
        tv.setText(message);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
    public void displayTMax(View view){
        EditText editText = (EditText) findViewById(R.id.editTextTimeExposure);
        Double time_exposure = Double.valueOf(editText.getText().toString());


        editText = findViewById(R.id.editTextNpeople);
        Double N = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextPt);
        Double epsilon = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextACH);
        Double lambda_a = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextQb);
        Double Qb = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextPm);
        Double pm = Double.valueOf(editText.getText().toString());

        editText = findViewById(R.id.editTextCq);
        Double cq = Double.valueOf(editText.getText().toString());



        double T_max = 0;
        T_max = epsilon*lambda_a/(N*Math.pow(Qb,2)*Math.pow(pm,2)*cq);

        String message;
        message = String.valueOf(T_max) + " is the T_max";
        TextView tv = (TextView)findViewById(R.id.textViewOutput);
        tv.setText(message);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
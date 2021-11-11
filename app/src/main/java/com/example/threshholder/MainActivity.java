package com.example.threshholder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.threshholder.MESSAGE";
    Double time_exposure, N, Co, V, P2, epsilon, lambda_a, Qb, pm, cq, change_in_c2;

    EditText time_exposure_input,N_input, Co_input, V_input, P2_input, epsilon_input, lambda_a_input, Qb_input, pm_input, cq_input, change_in_c2_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayThreshold(View view){
        time_exposure_input = findViewById(R.id.editTextTimeExposure);
        time_exposure = Double.valueOf(time_exposure_input.getText().toString());
        N_input = findViewById(R.id.editTextNpeople);
        N = Double.valueOf(N_input.getText().toString());

        Co_input = findViewById(R.id.editTextCo);
        Co = Double.valueOf(Co_input.getText().toString());

        V_input = findViewById(R.id.editTextV);
        V = Double.valueOf(V_input.getText().toString());

        P2_input = findViewById(R.id.editTextPt);
        P2 = Double.valueOf(P2_input.getText().toString());

        change_in_c2 = time_exposure*N*P2/V;


        String message;
        if(change_in_c2 > Co){
            message = "above threshold";
        }else{
            message = "below threshold";
        }
        TextView tv = findViewById(R.id.textViewOutput);
        tv.setText(message);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
    public void displayTMax(View view){

        time_exposure_input = findViewById(R.id.editTextTimeExposure);
        time_exposure = Double.valueOf(time_exposure_input.getText().toString());

        N_input = findViewById(R.id.editTextNpeople);
        N = Double.valueOf(N_input.getText().toString());

        epsilon_input = findViewById(R.id.editTextPt);
        epsilon = Double.valueOf(epsilon_input.getText().toString());

        lambda_a_input = findViewById(R.id.editTextACH);
        lambda_a = Double.valueOf(lambda_a_input.getText().toString());

        Qb_input = findViewById(R.id.editTextQb);
        Qb = Double.valueOf(Qb_input.getText().toString());

        pm_input = findViewById(R.id.editTextPm);
        pm = Double.valueOf(pm_input.getText().toString());

        cq_input = findViewById(R.id.editTextCq);
        cq = Double.valueOf(cq_input.getText().toString());



        double T_max;
        T_max = epsilon*lambda_a/(N*Math.pow(Qb,2)*Math.pow(pm,2)*cq);

        String message;
        message = T_max + " is the T_max";
        TextView tv = findViewById(R.id.textViewOutput);
        tv.setText(message);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
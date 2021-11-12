package com.example.threshholder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import static java.lang.Math.*;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.threshholder.MESSAGE";
    Double time_exposure, N,  V, epsilon, lambda_a, Qb, pm, cq, sr;
//    Double Co,P2, change_in_c2;

    EditText time_exposure_input,N_input, V_input, epsilon_input, lambda_a_input, Qb_input, pm_input, cq_input, sr_input;
//    EditText Co_input,P2_input, Change_in_c2_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void displayThreshold(View view){
//        time_exposure_input = findViewById(R.id.editTextTimeExposure);
//        time_exposure = Double.valueOf(time_exposure_input.getText().toString());
//        N_input = findViewById(R.id.editTextNpeople);
//        N = Double.valueOf(N_input.getText().toString());
//
//        Co_input = findViewById(R.id.editTextCo);
//        Co = Double.valueOf(Co_input.getText().toString());
//
//        V_input = findViewById(R.id.editTextV);
//        V = Double.valueOf(V_input.getText().toString());
//
//        P2_input = findViewById(R.id.editTextPt);
//        P2 = Double.valueOf(P2_input.getText().toString());
//
//        change_in_c2 = time_exposure*N*P2/V;
//
//
//        String message;
//        if(change_in_c2 > Co){
//            message = "above threshold";
//        }else{
//            message = "below threshold";
//        }
//        TextView tv = findViewById(R.id.textViewOutput);
//        tv.setText(message);
////        intent.putExtra(EXTRA_MESSAGE, message);
////        startActivity(intent);
//    }

    static double Round_off(double N, double n)
    {
        //taken from geeks for geeks
        int h;
        double l, a, b, c, d, e, i, j, m, f, g;
        b = N;
        c = floor(N);

        // Counting the no. of digits to the left of decimal point
        // in the given no.
        for (i = 0; b >= 1; ++i)
            b = b / 10;

        d = n - i;
        b = N;
        b = b * pow(10, d);
        e = b + 0.5;
        if ((float)e == (float)ceil(b)) {
            f = (ceil(b));
            h = (int)(f - 2);
            if (h % 2 != 0) {
                e = e - 1;
            }
        }
        j = floor(e);
        m = pow(10, d);
        j = j / m;
        System.out.println("The number after rounding-off is "
                + j);
        return(j);
    }
    public void displayTMax(View view){

        N_input = findViewById(R.id.editTextNpeople);
        N = Double.valueOf(N_input.getText().toString());

        epsilon_input = findViewById(R.id.editTextRiskTolerance);
        epsilon = Double.valueOf(epsilon_input.getText().toString());

        lambda_a_input = findViewById(R.id.editTextACH);
        lambda_a = Double.valueOf(lambda_a_input.getText().toString());

        Qb_input = findViewById(R.id.editTextQb);
        Qb = Double.valueOf(Qb_input.getText().toString());

        pm_input = findViewById(R.id.editTextPm);
        pm = Double.valueOf(pm_input.getText().toString());

        cq_input = findViewById(R.id.editTextCq);
        cq = Double.valueOf(cq_input.getText().toString());

        V_input = findViewById(R.id.editTextV);
        V = Double.valueOf(V_input.getText().toString());

        sr_input = findViewById(R.id.editTextSr);
        sr = Double.valueOf(sr_input.getText().toString());

        double T_max;
        T_max = epsilon*lambda_a*V/(N*Math.pow(Qb,2)*Math.pow(pm,2)*cq*sr);

        String message;
        message = Round_off(T_max, 3) + " hours is the maximum exposure time";
//        message = T_max+ " is the maximum exposure time";
        TextView tv = findViewById(R.id.textViewOutput);
        tv.setText(message);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
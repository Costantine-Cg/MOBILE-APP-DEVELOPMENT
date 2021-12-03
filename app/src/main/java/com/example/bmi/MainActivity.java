package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc_bn = findViewById(R.id.button);

        calc_bn.setOnClickListener(this);
    }

    public static class Calc_bmi{
        private static double height;
        private static double weight;
        static String comment;

        public static void setHeight(double h){
            height = h;
        }
        public static void setWeight(double w){
            weight = w;
        }

        public static String bmi(){
            double result =  weight / (height * height);

            if( result < 18.5 ){
                comment = " Underweight";
                return result + comment;
            }
            else if( result < 24.9){
                comment = " Normal weight";
                return result + comment;
            }
            else if(result <29.9){
                comment = " Over weight";
                return result + comment;
            }
            else{
                comment = " obese";
                return result + comment;
            }
        }
    }

    @Override
    public void onClick(View v) {
        EditText heightText = findViewById(R.id.EditText_height);
        EditText weightText = findViewById(R.id.editText_weight);

        double height = Double.parseDouble(heightText.getText().toString());
        double weight = Double.parseDouble(weightText.getText().toString());

        Calc_bmi.setHeight(height);
        Calc_bmi.setWeight(weight);

        String bmi = Calc_bmi.bmi();
        displayAreaDialogMessage(bmi);


    }

    private void displayAreaDialogMessage(String bmi) {

        AlertDialog.Builder builder =new AlertDialog.Builder(this );
        builder.setMessage("Your BMI is "+ bmi);
        builder.setTitle("BMI result");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
package edu.csulb.android.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calc;
    EditText amount;
    SeekBar sb;
    RadioButton radioButton;
    CheckBox cb;
    TextView installment;
    RadioGroup radioGroup;
    int rate_annual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc =(Button)findViewById(R.id.buttonCalc);
        sb =(SeekBar)findViewById(R.id.seekBar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rate_annual= progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onCalc(View v) {

        //Toast.makeText(this, String.valueOf(rate_annual),Toast.LENGTH_LONG).show();
        amount =(EditText)findViewById(R.id.EdittextAmount);
        cb = (CheckBox)findViewById(R.id.checkBox);
        installment = (TextView)findViewById(R.id.textViewInstall);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        if (amount.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a valid amount borrowed", Toast.LENGTH_LONG).show();
        }
        else if (radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Please select a rate of interest", Toast.LENGTH_LONG).show();
        }
        else {
            double p = Double.parseDouble(amount.getText().toString());//principal amount

            int id = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(id);
            int n = 12 * (Integer.parseInt(radioButton.getText().toString()));//number of months

            double t = (float) (0.1 * p / 100); //tax and insurance
            double m=0;

            if (rate_annual == 0) {
                if (cb.isChecked()) {
                    m = p / n + t;
                } else {
                    m = p / n;
                }
            }

            if (rate_annual != 0) {
                double j = rate_annual / 1200.0;
                double a = 1 - Math.pow(1 + j, (-n));

                if (cb.isChecked()) {
                    m = (p * (j / a)) + t;
                    }
                else {
                    m = p * j / a;
                    }
            }

            float monthly = Float.valueOf(String.valueOf(m));
            installment.setText("The monthly installment = " + monthly);
        }
    }
}


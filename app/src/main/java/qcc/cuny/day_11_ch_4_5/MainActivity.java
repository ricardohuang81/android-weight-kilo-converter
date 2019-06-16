package qcc.cuny.day_11_ch_4_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
// declare variables
    double conversionRate = 2.2;
    double weightEntered, convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        // CREATE OBJECTS
        final EditText weight = (EditText)findViewById(R.id.weight);
        final RadioButton lbToKilo = (RadioButton)findViewById(R.id.radioButton1);
        final RadioButton klToLb = (RadioButton)findViewById(R.id.radioButton2);
        final TextView results = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.buttonConvert);
        //
        //
        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // get the weight from the weight object and convert it into a double
                weightEntered = Double.parseDouble(weight.getText().toString());
                // set the display of the results to one decimal place
                DecimalFormat tenth = new DecimalFormat("###.#");
                // IF "radioButton1" WAS CHECKED
                if (lbToKilo.isChecked()) {
                    if (weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        results.setText(tenth.format(convertedWeight) + " kilograms");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                        results.setText("");
                    }
                }
                // IF "radioButton2" WAS CHECKED
                if (klToLb.isChecked()) {
                    if (weightEntered <= 227) {
                        convertedWeight = weightEntered * conversionRate;
                        results.setText(tenth.format(convertedWeight) + " pounds");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Kilograms must be less than 227", Toast.LENGTH_LONG).show();
                        results.setText("");
                    }
                }
            }
        });
    }
}

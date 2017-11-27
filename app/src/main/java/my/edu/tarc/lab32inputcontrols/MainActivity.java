package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium, extraPaymentSmoker,extraPaymentMale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);

        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);


        textViewPremium = (TextView)findViewById(R.id.textViewPremium);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO: calculate basic premium according to age group
        switch (position) {
            case 0:
                basicPremium = 50;
                extraPaymentMale = 0;
                extraPaymentSmoker = 0;
                break;
            case 1:
                basicPremium = 55;
                extraPaymentMale = 0;
                extraPaymentSmoker = 0;
                break;
            case 2:
                basicPremium = 60;
                extraPaymentMale = 50;
                extraPaymentSmoker = 0;
                break;
            case 3:
                basicPremium = 70;
                extraPaymentMale = 100;
                extraPaymentSmoker = 100;
                break;
            case 4:
                basicPremium = 120;
                extraPaymentMale = 100;
                extraPaymentSmoker = 050;
                break;
            case 5:
                basicPremium = 160;
                extraPaymentMale = 50;
                extraPaymentSmoker = 150;
                break;
            case 6:
                basicPremium = 200;
                extraPaymentMale = 0;
                extraPaymentSmoker = 250;
                break;
            case 7:
                basicPremium = 250;
                extraPaymentMale = 0;
                extraPaymentSmoker = 250;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





    public void calculateButton(View view){
        RadioGroup radioGroupGender = (RadioGroup)findViewById((R.id.radioGroupGender));
        int gender = radioGroupGender.getCheckedRadioButtonId();

        double total = 0;
        total += basicPremium;

        if(checkBoxSmoker.isChecked() == true){
            total +=extraPaymentSmoker;
        }

        if(gender == R.id.radioButtonMale){
            total+=extraPaymentMale;
        }

        textViewPremium.setText(String.format("RM %.2f", total));
    }

    public void resetButton(View view){
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(null);
    }
}

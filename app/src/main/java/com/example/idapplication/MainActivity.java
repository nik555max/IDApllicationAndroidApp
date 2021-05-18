package com.example.idapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // declaring the variables
    EditText editTextID;
    Button buttonSubmit;
    TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //extracting the id of all the components
        editTextID = findViewById(R.id.editTextIDNumber);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResults = findViewById(R.id.textViewResult);

        //Making TextView Dissappear
        textViewResults.setVisibility(View.GONE);

        //handling submit event
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = editTextID.getText().toString().trim();
                String dob = idNumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));


                String realGender;
                if (gender < 5){
                    realGender = "Female";
                }else{
                    realGender = "Male";
                }

                int nationality =  Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String realNationality;

                if (nationality == 0){
                    realNationality = "SA Citizen";
                }else{
                    realNationality = "Permanent Resident";
                }

                String text = getString(R.string.dob)+dob+getString(R.string.newLine)+
                        getString(R.string.Gender)+realGender+getString(R.string.newLine)+
                        getString(R.string.Nationality)+realNationality;
                textViewResults.setText(text);

                textViewResults.setVisibility(View.VISIBLE);

            }
        });
    }
}
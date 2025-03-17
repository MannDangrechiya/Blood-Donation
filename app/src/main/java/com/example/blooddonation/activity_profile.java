package com.example.blooddonation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class activity_profile extends AppCompatActivity {

    private EditText editTextName, dateOfBirthEditText;
    private TextView textViewUserName;
    private RadioGroup genderRadioGroup;
    private Spinner bloodGroupSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextName = findViewById(R.id.editTextText);
        textViewUserName = findViewById(R.id.textView11);
        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner);
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);
        saveButton = findViewById(R.id.button2);

        // Date Picker Dialog
        dateOfBirthEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        activity_profile.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateOfBirthEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Save Button Click Listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String dateOfBirth = dateOfBirthEditText.getText().toString();
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedGenderId);
                String gender = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Not Selected";
                String bloodGroup = bloodGroupSpinner.getSelectedItem().toString();

                if (name.isEmpty() || dateOfBirth.isEmpty()) {
                    Toast.makeText(activity_profile.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    String userInfo = "Name: " + name + "\nGender: " + gender + "\nBlood Group: " + bloodGroup + "\nDOB: " + dateOfBirth;
                    Toast.makeText(activity_profile.this, "Data Saved:\n" + userInfo, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


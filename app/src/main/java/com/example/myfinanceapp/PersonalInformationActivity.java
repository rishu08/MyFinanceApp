package com.example.myfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// PersonalInformationActivity.java
public class PersonalInformationActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextRetAge;
    private EditText editTextCurSalary;
    private EditText editTextIncrement;

    private PersonalInfoDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

//        Input Fields for Personal Details
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextCurSalary = findViewById(R.id.editTextCurSalary);
        editTextRetAge = findViewById(R.id.editTextRetAge);
        editTextIncrement = findViewById(R.id.editTextAvgIncrement);

        Button buttonSave = findViewById(R.id.buttonSave);
        Button btnChart = findViewById(R.id.btn_chartActivity);

//        Output view for Personal Details
        TextView textViewResultName = findViewById(R.id.textViewResult_Name);
        TextView textViewResultAge = findViewById(R.id.textViewResult_Age);
        TextView textViewResultCurSalary = findViewById(R.id.textViewResult_Salary);
        TextView textViewResultRetAge = findViewById(R.id.textViewResult_RetAge);
        TextView textViewResultIncrement = findViewById(R.id.textViewResult_AvgIncrement);

        dbHelper = new PersonalInfoDbHelper(this);

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chartactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(chartactivity);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Fetch data from field and display
                String name = editTextName.getText().toString();
                String Age = editTextAge.getText().toString();
                String CurSalary = editTextCurSalary.getText().toString();
                String RetAge = editTextRetAge.getText().toString();
                String Increment = editTextIncrement.getText().toString();

                PersonalInfo personalInfo = new PersonalInfo(name, Age, CurSalary, RetAge , Increment);
                dbHelper.insertPersonalInfo(personalInfo);

                textViewResultName.setText("Personal information saved: " + name);
                textViewResultAge.setText("Personal information saved: " + Age);
                textViewResultCurSalary.setText("Personal information saved: " + CurSalary);
                textViewResultRetAge.setText("Personal information saved: " + RetAge);
                textViewResultIncrement.setText("Personal information saved: " + Increment);

            }
        });

        // Retrieve and display personal information when the activity starts
        PersonalInfo savedPersonalInfo = dbHelper.getPersonalInfo();
        if (savedPersonalInfo != null) {
            textViewResultName.setText("Personal information retrieved: " + savedPersonalInfo.getName());
            textViewResultAge.setText("Personal information retrieved: " + savedPersonalInfo.getAge());
            textViewResultCurSalary.setText("Personal information retrieved: " + savedPersonalInfo.getCurSalary());
            textViewResultRetAge.setText("Personal information retrieved: " + savedPersonalInfo.getRetAge());
            textViewResultIncrement.setText("Personal information retrieved: " + savedPersonalInfo.getAvgIncrement());

        }
    }
}

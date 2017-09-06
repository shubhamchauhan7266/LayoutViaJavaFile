package com.example.user.layoutviajavafile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static android.R.attr.tag;
import static com.example.user.layoutviajavafile.EmployeeListActivity.*;
import static com.example.user.layoutviajavafile.EmployeeListActivity.MODIFIED_DATA_KEY;

public class EmployeeRegistrationActivity extends AppCompatActivity {

    public static ArrayList<Employee> employeeArrayList= new ArrayList<>();;
    private Employee employee;
    private EditText editTextName;
    private EditText editTextGender;
    private int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);

        final Intent intent=getIntent();
        employee=intent.getParcelableExtra(MODIFIED_DATA_KEY);
        tag=intent.getIntExtra(TAG_KEY,-1);
        Button buttonAddMore = (Button) findViewById(R.id.buttonAddMore);
        final Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        editTextGender = (EditText) findViewById(R.id.editTextGender);
        editTextName = (EditText) findViewById(R.id.editTextName);

        if(employee!=null){
            editTextName.setText(employee.getName());
            editTextGender.setText(employee.getGender());
        }

        buttonAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextName.getText().toString().trim().length()==0)
                    editTextName.setError("Please enter name !!");
                else  if (editTextGender.getText().toString().trim().length()==0)
                    editTextGender.setError("Please enter Gender !!");
                else
                {
                    saveEmployeeData();
                    editTextGender.setText("");
                    editTextName.setText("");
                }

            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextName.getText().toString().trim().length()==0)
                    editTextName.setError("Please enter name !!");
                else if (editTextGender.getText().toString().trim().length()==0)
                    editTextGender.setError("Please enter Gender !!");
                else {
                    saveEmployeeData();
                    Intent intent = new Intent(EmployeeRegistrationActivity.this, EmployeeListActivity.class);
                    startActivity(intent);
                }

            }
        });


    }

    void saveEmployeeData() {
        if(employee==null){
            employee = new Employee();
            employee.setName(editTextName.getText().toString());
            employee.setGender(editTextGender.getText().toString());
            employeeArrayList.add(employee);
        }else {
            employee.setName(editTextName.getText().toString());
            employee.setGender(editTextGender.getText().toString());
            employeeArrayList.set(tag,employee);
        }

        employee=null;
    }
}

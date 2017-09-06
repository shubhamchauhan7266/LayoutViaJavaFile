package com.example.user.layoutviajavafile;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import static com.example.user.layoutviajavafile.EmployeeRegistrationActivity.employeeArrayList;

public class EmployeeListActivity extends AppCompatActivity {

    private Employee employee;
    public static final String MODIFIED_DATA_KEY = "Data";
    public static final String TAG_KEY = "Tag";
    private int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout parentLinearLayout = new LinearLayout(EmployeeListActivity.this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        parentLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        parentLinearLayout.setVerticalScrollBarEnabled(true);

        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewParams.setMargins(100, 0, 0, 0);

        for (int i = 0; i < employeeArrayList.size(); i++) {
            employee = employeeArrayList.get(i);

            final LinearLayout listRowLinearLayout = new LinearLayout(EmployeeListActivity.this);
            listRowLinearLayout.setOrientation(LinearLayout.VERTICAL);
            listRowLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            listRowLinearLayout.setTag(i);

            TextView textViewName = new TextView(this);
            textViewName.setGravity(Gravity.CENTER);
            textViewName.setTextColor(Color.BLACK);
            textViewName.setTextSize(25);
            textViewName.setText("Name : " + employee.getName());
            TextView textViewGender = new TextView(this);
            textViewGender.setGravity(Gravity.CENTER);
            textViewGender.setTextColor(Color.BLACK);
            textViewGender.setTextSize(25);
            textViewGender.setText("Gender : " + employee.getGender());

            listRowLinearLayout.addView(textViewName, textViewParams);
            listRowLinearLayout.addView(textViewGender, textViewParams);

            View view = new View(this);
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 5));
            view.setBackgroundColor(Color.BLACK);

            listRowLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tag = (int) listRowLinearLayout.getTag();
                    employee = employeeArrayList.get(tag);
                    Intent intentEditDetails = new Intent(EmployeeListActivity.this, EmployeeRegistrationActivity.class);
                    intentEditDetails.putExtra(MODIFIED_DATA_KEY, employee);
                    intentEditDetails.putExtra(TAG_KEY,tag);
                    startActivity(intentEditDetails);
                }
            });
            parentLinearLayout.addView(listRowLinearLayout);
            parentLinearLayout.addView(view);
        }

        setContentView(parentLinearLayout);

    }

}

package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InfosActivity extends AppCompatActivity {

    /*private TextView name;
    private TextView firstName;
    private TextView dateBirth;
    private TextView townBirth;
    private TextView deptBirth;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        Intent intent = this.getIntent();

        if (intent != null) {
            String receivedName = "";
            String receivedFirstName = "";
            String receivedBirthDate = "";
            String receivedTownBirth = "";
            String receivedDeptBirth = "";
            String receivedPhoneNumber = "";

            /*if (intent.hasExtra("name")) {
                receivedName = intent.getStringExtra("name");
            }

            if (intent.hasExtra("firstName")) {
                receivedFirstName = intent.getStringExtra("firstName");
            }

            if (intent.hasExtra("birthDate")) {
                receivedBirthDate = intent.getStringExtra("birthDate");
            }

            if (intent.hasExtra("deptOfBirth")) {
                receivedTownBirth = intent.getStringExtra("deptOfBirth");
            }

            if (intent.hasExtra("name")) {
                receivedDeptBirth = intent.getStringExtra("name");
            }

            if (intent.hasExtra("phoneNumber")) {
                receivedPhoneNumber = intent.getStringExtra("phoneNumber");
            }*/

            InfosForParcelable infos = intent.getParcelableExtra("Infos");

            if(infos != null){
                receivedName = infos.getName();
                receivedFirstName = infos.getFirstName();
                receivedBirthDate = infos.getDateBirth();
                receivedDeptBirth = infos.getDeptBirth();
                receivedTownBirth = infos.getTownBirth();
                receivedPhoneNumber = infos.getPhoneNumber();
            }

        TextView name = findViewById(R.id.name_display);
        TextView firstName = findViewById(R.id.first_name_display);
        TextView dateBirth = findViewById(R.id.date_display);
        TextView townBirth = findViewById(R.id.ville_display);
        TextView deptBirth = findViewById(R.id.dept_display);
        TextView phoneNumber = findViewById(R.id.phone_number_display);

        name.setText(receivedName);
        firstName.setText(receivedFirstName);
        dateBirth.setText(receivedBirthDate);
        townBirth.setText(receivedTownBirth);
        deptBirth.setText(receivedDeptBirth);
        phoneNumber.setText(receivedPhoneNumber);
    }
    }
}

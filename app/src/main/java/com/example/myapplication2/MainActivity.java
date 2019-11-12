package com.example.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.name) EditText name;
    @BindView(R.id.firstName) EditText firstName;
    @BindView(R.id.birthDate) EditText birthDate;
    @BindView(R.id.townOfBirth) EditText townOfBirth;
    @BindView(R.id.deptSpinner) Spinner departments;
    @BindView(R.id.validateButton) Button buttonParcelable;
    @BindView(R.id.validateButtonRecyclerView) Button buttonRecyclerView;
    @BindView(R.id.phoneNumber) EditText phoneNumber;
    @BindView(R.id.validateButtonFullList) Button buttonFullList;

    String selectedDepartment = "";

    Boolean activateName =false;
    Boolean activateFirstName =false;
    Boolean activateBirthDate =false;
    Boolean activateTownOfBirth =false;

    public void activateButton(){
        if(activateName && activateFirstName && activateBirthDate && activateTownOfBirth){
            buttonParcelable.setEnabled(true);
            buttonRecyclerView.setEnabled(true);
            buttonFullList.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activateButton();

        final List<Info> listOfInfos = new ArrayList<>();
        final List<User> listOfUsers = new ArrayList<>();

        User toto = new User("Durand", "Toto", "10/10/10", "Trifouillis", "0555555555", "Oise");
        User titi = new User("Dupond", "Titi", "9/9/9", "Pommé/Loire", "0444444444", "Oise");
        User tutu = new User("Martin", "Tutu", "8/8/8", "Pèt-Zouille-les-Oies", "0333333333", "Oise");

        listOfUsers.add(toto);
        listOfUsers.add(titi);
        listOfUsers.add(tutu);

        buttonParcelable.setEnabled(false);
        buttonRecyclerView.setEnabled(false);
        buttonFullList.setEnabled(false);

        name.requestFocus();

        buttonFullList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameRetrieved = name.getText().toString();
                String firstNameRetrieved = firstName.getText().toString();
                String birthDateRetrieved = birthDate.getText().toString();
                String townOfBirthRetrieved = townOfBirth.getText().toString();
                String phoneNumberRetrieved = phoneNumber.getText().toString();
                String departmentRetrieved = departments.getSelectedItem().toString();

                User nonameUser = new User(nameRetrieved, firstNameRetrieved, birthDateRetrieved, townOfBirthRetrieved, phoneNumberRetrieved, departmentRetrieved);
                listOfUsers.add(nonameUser);

                Intent intent = new Intent(MainActivity.this, RecyclerActivityUser.class);
                UsersForRecyclerView user = new UsersForRecyclerView(listOfUsers);
                intent.putExtra("Users", user);
                startActivityForResult(intent,0);

                name.setText("");
                firstName.setText("");
                birthDate.setText("");
                townOfBirth.setText("");
                phoneNumber.setVisibility(View.INVISIBLE);
                departments.setSelection(0);

                buttonParcelable.setEnabled(false);
                buttonRecyclerView.setEnabled(false);
                buttonFullList.setEnabled(false);
            }
        });

        buttonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameRetrieved = name.getText().toString();
                String firstNameRetrieved = firstName.getText().toString();
                String birthDateRetrieved = birthDate.getText().toString();
                String townOfBirthRetrieved = townOfBirth.getText().toString();
                String phoneNumberRetrieved = phoneNumber.getText().toString();
                String departmentRetrieved = departments.getSelectedItem().toString();

                afficher(v);

                listOfInfos.add(new Info("Your name is ", nameRetrieved));
                listOfInfos.add(new Info("Your first name is ", firstNameRetrieved));
                listOfInfos.add(new Info("You were born on the ", birthDateRetrieved));
                listOfInfos.add(new Info("Your town of birth is ", townOfBirthRetrieved));
                listOfInfos.add(new Info("Your department is ", departmentRetrieved));
                listOfInfos.add(new Info("Your phone number is ", phoneNumberRetrieved));

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                InfosForRecyclerView infos = new InfosForRecyclerView(listOfInfos);
                intent.putExtra("Infos", infos);
                startActivity(intent);
            }
        });

        buttonParcelable.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nameRetrieved = name.getText().toString();
                String firstNameRetrieved = firstName.getText().toString();
                String birthDateRetrieved = birthDate.getText().toString();
                String townOfBirthRetrieved = townOfBirth.getText().toString();
                String phoneNumberRetrieved = phoneNumber.getText().toString();
                String departmentRetrieved = departments.getSelectedItem().toString();

                afficher(v);

                name.setText("");
                firstName.setText("");
                birthDate.setText("");
                townOfBirth.setText("");
                activateName =false;
                activateFirstName =false;
                activateBirthDate =false;
                activateTownOfBirth =false;
                buttonParcelable.setEnabled(false);

                Intent intent = new Intent(MainActivity.this, InfosActivity.class);

                /*intent.putExtra("name", nameRetrieved);
                intent.putExtra("firstName", firstNameRetrieved);
                intent.putExtra("birthDate", birthDateRetrieved);
                intent.putExtra("townOfBirth", townOfBirthRetrieved);
                intent.putExtra("deptOfBirth", departmentRetrieved);
                intent.putExtra("phoneNumber", phoneNumberRetrieved);*/

                InfosForParcelable infos = new InfosForParcelable(nameRetrieved, firstNameRetrieved, birthDateRetrieved, townOfBirthRetrieved, phoneNumberRetrieved, departmentRetrieved);
                intent.putExtra("Infos", infos);

                startActivity(intent);
            }
        });

        departments.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedDepartment=departments.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() != 0){
                    activateName=true;
                };
                activateButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() != 0){
                    activateFirstName=true;
                };
                activateButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        birthDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() != 0){
                    activateBirthDate=true;
                };
                activateButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        townOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() != 0){
                    activateTownOfBirth=true;
                };
                activateButton();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void afficher(View v) {

        String nameRetrieved = name.getText().toString();
        String firstNameRetrieved = firstName.getText().toString();
        String birthDateRetrieved = birthDate.getText().toString();
        String townOfBirthRetrieved = townOfBirth.getText().toString();
        String phoneNumberRetrieved = phoneNumber.getText().toString();
        String departmentRetrieved = departments.getSelectedItem().toString();

        String fullInfos = "Vous vous appelez " + firstNameRetrieved + " " + nameRetrieved + "\n"
                + "Vous êtes né le " + birthDateRetrieved + " à " + townOfBirthRetrieved + "(Département = " + departmentRetrieved + ")"
                + "\nVotre numéro de téléphone est le : " + phoneNumberRetrieved;
        Toast.makeText(getApplicationContext(), fullInfos, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Adds a phone number field into the GUI
     */
    /*public void addPhoneField(){
        EditText phoneNumber = new EditText(this);
        phoneNumber.setHint("Add a phone number");
        // Gérer avec un layout manager du parent puis ajouter des contraintes de layouts.
        // Sinon, mettre en ce composant en invisible dans le layout et l'afficher avec show()
        ViewGroup vg = (ViewGroup) findViewById(R.id.content_layout);
        vg.addView(phoneNumber);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();
        // noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            case R.id.reset_button :
                name.setText("");
                name.requestFocus();
                firstName.setText("");
                birthDate.setText("");
                townOfBirth.setText("");
                phoneNumber.setText("");
                phoneNumber.setVisibility(View.INVISIBLE);
                departments.setSelection(0);
                buttonParcelable.setEnabled(false);
                buttonFullList.setEnabled(false);
                buttonRecyclerView.setEnabled(false);
                break;

            case R.id.wiki_button :
                String deptToFind = "http://fr.wikipedia.org/wiki/" + selectedDepartment;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deptToFind));
                startActivity(intent);
                break;

            case R.id.add_tph_button :
                phoneNumber.setVisibility(View.VISIBLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}

package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.User;
import th.ac.cmu.camt.sodiumconqueror.utils.NoDefaultSpinner;

public class HealInfomationActivity extends AppCompatActivity implements View.OnClickListener {

    DbHelper dbHelper;
    User user;

    Toolbar toolbar;
    Spinner spinner;
    String[] gender;
    Button button;

    EditText edtName, edtAge, edtWeight, edtHeight, edtDisease;
    NoDefaultSpinner ndsGender;

    boolean[]editTextValidateArray = new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heal_infomation);
        initInstances();
        setUserHealthInfo();
        setEditTextValidateArray();

    }

    private void setEditTextValidateArray() {

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == start){
                    editTextValidateArray[0] = false;
                }else {
                    editTextValidateArray[0] = true;
                }

                setButtonVisibility();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == start){
                    editTextValidateArray[1] = false;
                }else {
                    editTextValidateArray[1] = true;
                }

                setButtonVisibility();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTextValidateArray[2] = true;
                setButtonVisibility();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editTextValidateArray[2] = false;
                setButtonVisibility();
            }
        });

        edtWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == start){
                    editTextValidateArray[3] = false;
                }else {
                    editTextValidateArray[3] = true;
                }

                setButtonVisibility();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == start){
                    editTextValidateArray[4] = false;
                }else {
                    editTextValidateArray[4] = true;
                }

                setButtonVisibility();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private boolean isEditTextValidated(){

        boolean allIndexTrue = false;

        for(int i = 0 ;i < editTextValidateArray.length ; i++){
            if(editTextValidateArray[i] == true){
                allIndexTrue = true;
            }else {
                allIndexTrue = false;
            }
        }

        if(allIndexTrue == true){
            return true;
        }else {
            return false;
        }
    }

    private void initInstances() {

        dbHelper = new DbHelper(this);
        user = dbHelper.getUser();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Heal_name));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner = (Spinner) findViewById(R.id.Spinner_Gender);
        gender = getResources().getStringArray(R.array.genger_list);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, gender);
        spinner.setPrompt(getString(R.string.Gender));
        spinner.setAdapter(dataAdapter);

        button = (Button) findViewById(R.id.btn_submit_heal_info);
        button.setOnClickListener(this);
        button.setVisibility(View.INVISIBLE);

        edtName = (EditText) findViewById(R.id.EditTextName);
        edtAge = (EditText) findViewById(R.id.EditTextAge);
        edtWeight = (EditText) findViewById(R.id.EditTextWeight);
        edtHeight = (EditText) findViewById(R.id.EditTextHeight);
        edtDisease = (EditText) findViewById(R.id.EditTextDisease);

    }
    private void setUserHealthInfo() {

        if (user.isValid()) {

            edtName.setText(user.getName());
            edtAge.setText(Integer.toString(user.getAge()));

            spinner.setSelection(user.getGender());

            edtWeight.setText(Double.toString(user.getWeight()));
            edtHeight.setText(Double.toString(user.getHeight()));

            if (user.getDisease() != null) {
                edtDisease.setText(user.getDisease());
            }
        }

    }

    private void setButtonVisibility(){
        if(isEditTextValidated()){
            button.setVisibility(View.VISIBLE);
        }else {
            button.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == button) {

            final String EMPTY_STRING = "";

            String name = edtName.getText().toString();
            String age = edtAge.getText().toString();
            String weight = edtWeight.getText().toString();
            String height = edtHeight.getText().toString();
            String disease = edtDisease.getText().toString();

            User user = new User();
            user.setName(name);

            if (!age.equals(EMPTY_STRING)) {
                user.setAge(Integer.parseInt(age));
            }

            if (spinner.getSelectedItem() != null) {
                int gender = spinner.getSelectedItemPosition();
                user.setGender(gender);
            }

            if (!edtWeight.getText().toString().equals(EMPTY_STRING)) {
                user.setWeight(Double.parseDouble(weight));
            }

            if (!edtHeight.getText().toString().equals(EMPTY_STRING)) {
                user.setHeight(Double.parseDouble(height));
            }

            user.setDisease(disease);

            if (dbHelper.isUserExist()) {
                dbHelper.updateUser(user);
            } else {
                dbHelper.insertUser(user);
            }


            final String PREFS_NAME = "MyPrefsFile";
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            settings.edit().putBoolean("my_first_time", false).commit();
            Intent intent = new Intent(HealInfomationActivity.this, MainActivity.class);
            startActivity(intent);
            finish();


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

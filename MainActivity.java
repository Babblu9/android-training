package com.example.registrationform;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText edtName,edtEmail,edtMobile;
    RadioGroup Gender;
    CheckBox cbJava, cbAndroid;
    Spinner spCity;
    Button btnSubmit;
    TextView txtOutput;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            return insets;



        });
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtMobile = findViewById(R.id.edtMobile);

        Gender = findViewById(R.id.Gender);

        cbJava =findViewById(R.id.cbJava);
        cbAndroid = findViewById(R.id.cbAndroid);

        spCity = findViewById(R.id.spCity);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtOutput = findViewById(R.id.txtOutput);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(
                MainActivity.this,
                R.array.cities,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCity.setAdapter(adapter);

        btnSubmit.setOnClickListener(view -> submitForm());


    }
    public  void  submitForm (){
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String mobile = edtEmail.getText().toString().trim();

        int selectedGenderId = Gender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();


        String skills = "";
        if(cbJava.isChecked()) skills += "Java";
        if(cbAndroid.isChecked())skills += "Android";

        String city = spCity.getSelectedItem().toString();

        String finalData =
                "Name  " + name  + "\n" +
                        "Email   " + email + "\n"+
                        "Mobile  " + mobile +"\n" +
                        "Gender  " + gender +"\n" +
                        "Skills  " + skills +"\n" +
                        "City    " + city ;

        txtOutput.setText(finalData);

    }
}
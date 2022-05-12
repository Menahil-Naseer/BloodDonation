package com.example.blooddonation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText t1,t2,t3;
    Spinner bG;
    String[] bg={"A+","A-","B+","B-","AB+","AB-","other"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bG=(Spinner)findViewById(R.id.spinner);
        t1=(EditText)findViewById(R.id.editTextTextPersonName);
        t2=(EditText)findViewById(R.id.editTextTextPersonName2);
        t3=(EditText)findViewById(R.id.editTextTextPersonName3);
        bG.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter as=new ArrayAdapter(this,android.R.layout.simple_spinner_item,bg);
        as.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bG.setAdapter(as);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),bg[i],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void submit(View view) {
        HashMap<String, Object> m = new HashMap<String , Object>();
        m. put ("Name" , t1.getText ().toString());
        m.put ("City" ,t2.getText ().toString());
        m.put ("Contact" ,t3.getText ().toString());
        m.put ("blood group",bG.getSelectedItem().toString());
        FirebaseDatabase.getInstance().getReference().child("User").push().setValue(m);
    }
}
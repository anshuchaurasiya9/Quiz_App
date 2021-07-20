package com.example.softonicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class OTP_Auth extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText t1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p__auth);

        t1= findViewById(R.id.t1);
        ccp= findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(t1);
        b1= findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OTP_Auth.this,Manage_OTP.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }
}
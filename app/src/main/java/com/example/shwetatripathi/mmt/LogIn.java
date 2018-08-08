package com.example.shwetatripathi.mmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    Button bsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        bsignin=findViewById(R.id.email_sign_in_button);
        bsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent =new Intent(LogIn.this,SignUp.class);
                startActivity(homeIntent);
                finish();
            }
        });


    }
}

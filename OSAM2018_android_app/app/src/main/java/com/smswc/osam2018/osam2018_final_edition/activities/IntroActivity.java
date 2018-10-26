package com.smswc.osam2018.osam2018_final_edition.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smswc.osam2018.osam2018_final_edition.R;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initialize();
        setOnClickListener();
    }

    void initialize() {
        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_signup);
    }

    void setOnClickListener() {
        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
                break;
            case R.id.btn_signup:
                startActivity(new Intent(IntroActivity.this, SignupActivity.class));
                break;
        }
    }
}

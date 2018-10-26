package com.smswc.osam2018.osam2018_final_edition.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.lib.Requester;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class LoginActivity extends AppCompatActivity {
    private EditText edtId, edtPw;
    private Button btnLogin;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
        setOnClickListener();
    }

    void initialize() {
        edtId = findViewById(R.id.edt_id);
        edtPw = findViewById(R.id.edt_pw);
        btnLogin = findViewById(R.id.btn_login);
        sp = getPreferences(Context.MODE_PRIVATE);
    }

    void setOnClickListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String params = "id=" + edtId.getText().toString() + "&pw=" + edtPw.getText().toString();
                try {
                    JsonElement element = Requester.sendRequest("post", "/auth/login", params);

                    boolean isSuccess = element.getAsJsonObject().get("isSuccess").getAsBoolean();
                    String message = element.getAsJsonObject().get("message").getAsString();

                    if(isSuccess) {
                        SharedPreferences.Editor editor = sp.edit();
                        String token = element.getAsJsonObject().get("token").getAsString();
                        editor.putString("token", token);
                        editor.commit();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

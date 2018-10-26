package com.smswc.osam2018.osam2018_final_edition.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.lib.Requester;

import java.util.concurrent.ExecutionException;

public class SignupActivity extends AppCompatActivity {

    private EditText edtKeycode, edtId, edtPw, edtPwRe, edtNickName;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initialize();
        setOnClickListener();
    }

    void initialize() {
        edtKeycode = findViewById(R.id.edt_keycode);
        edtId = findViewById(R.id.edt_id);
        edtPw = findViewById(R.id.edt_pw);
        edtPwRe = findViewById(R.id.edt_pw_re);
        edtNickName = findViewById(R.id.edt_nickname);
        btnSignup = findViewById(R.id.btn_signup);
    }

    void setOnClickListener() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String params = "keycode=" + edtKeycode.getText().toString() +
                        "&id=" + edtId.getText().toString() +
                        "&pw=" + edtPw.getText().toString() +
                        "&pw_re=" + edtPwRe.getText().toString() +
                        "&nickname=" + edtNickName.getText().toString();

                try {
                    JsonElement jsonElement = Requester.sendRequest("post", "/auth/signup", params);
                    boolean isSuccess = jsonElement.getAsJsonObject().get("isSuccess").getAsBoolean();
                    String message = jsonElement.getAsJsonObject().get("message").getAsString();

                    if(isSuccess) {
                        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException e) {
                    Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

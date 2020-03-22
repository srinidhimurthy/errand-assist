package com.corona.errandassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button loginLink = findViewById(R.id.loginButtonLink);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(loginScreen);
            }
        });

        Button signupLink = findViewById(R.id.signupButtonLink);
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpScreen = new Intent(HomeActivity.this, SignupActivity.class);
                startActivity(signUpScreen);
            }
        });
    }
}

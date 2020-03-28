package com.corona.errandassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.corona.errandassist.CompleteSignUpTextWatcher.CompleteSignupTextWatcher;

public class CompleteSignUpActivity extends AppCompatActivity {

    private EditText userPassword;
    private EditText userConfirmPassword;
    private Button completeSignUpButton;
    private CompleteSignupTextWatcher completeSignUpTextWatcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_signup);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        getActivityFormObjects();
        addTextWatchersForInputFields();
    }

    private void getActivityFormObjects() {
        userPassword = findViewById(R.id.passwordField);
        userConfirmPassword = findViewById(R.id.confirmPasswordField);
        completeSignUpButton = findViewById(R.id.complete_sign_up);
    }

    private void addTextWatchersForInputFields() {
        completeSignUpTextWatcher = new CompleteSignupTextWatcher(userPassword, userConfirmPassword, completeSignUpButton);
        userPassword.addTextChangedListener(completeSignUpTextWatcher);
        userConfirmPassword.addTextChangedListener(completeSignUpTextWatcher);
    }

}

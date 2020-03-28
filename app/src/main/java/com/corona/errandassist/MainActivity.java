package com.corona.errandassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.corona.errandassist.signupEventListeners.SignupTextWatcher;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.corona.errandassist.MESSAGE";
    private EditText userFName;
    private EditText userLName;
    private EditText userEmail;
    private EditText userPhoneNumber;
    private Button signUpButton;
    private SignupTextWatcher signUpTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityFormObjects();

        addTextWatchersForInputFields();
    }

    private void getActivityFormObjects() {
        userFName = findViewById(R.id.fNameField);
        userLName = findViewById(R.id.lNameField);
        userEmail = findViewById(R.id.emailField);
        userPhoneNumber = findViewById(R.id.phoneField);
        signUpButton = findViewById(R.id.signupButton);
    }

    private void addTextWatchersForInputFields() {
        signUpTextWatcher = new SignupTextWatcher(userFName, userLName, userEmail, userPhoneNumber, signUpButton);
        userFName.addTextChangedListener(signUpTextWatcher);
        userLName.addTextChangedListener(signUpTextWatcher);
        userEmail.addTextChangedListener(signUpTextWatcher);
        userPhoneNumber.addTextChangedListener(signUpTextWatcher);
    }

    public void onSignUpClicked(View view) {
        openCompleteSignupActivity();
    }



    private void openCompleteSignupActivity() {
        Intent intent = new Intent(this, CompleteSignUpActivity.class);
        EditText editText = (EditText) findViewById(R.id.fNameField);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

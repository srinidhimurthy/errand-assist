package com.corona.errandassist.signupEventListeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class SignupTextWatcher implements TextWatcher {

    private EditText userFName;
    private EditText userLName;
    private EditText userEmail;
    private EditText userPhoneNumber;
    private Button signUpButton;

    public SignupTextWatcher(EditText userFName, EditText userLName, EditText userEmail, EditText userPhoneNumber, Button signUpButton){
        this.userFName = userFName;
        this.userLName = userLName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.signUpButton = signUpButton;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String fName = userFName.getText().toString();
        String lName = userLName.getText().toString();
        String emailID = userEmail.getText().toString();
        String phoneNumber = userPhoneNumber.getText().toString();

        boolean enableSignupButton = !(fName.isEmpty() || lName.isEmpty() || emailID.isEmpty() || phoneNumber.isEmpty() || !validatePhoneNumberField(phoneNumber));

        signUpButton.setEnabled(enableSignupButton);
    }

    private boolean validatePhoneNumberField(String phoneNumber) {
        if(phoneNumber.length() !=10 ){
            userPhoneNumber.setError("Phone number should be 10 digits");
            return false;
        }
        else{
            userPhoneNumber.setError(null);
            return true;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

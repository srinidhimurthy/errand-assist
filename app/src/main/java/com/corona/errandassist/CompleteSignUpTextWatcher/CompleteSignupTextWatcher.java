package com.corona.errandassist.CompleteSignUpTextWatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompleteSignupTextWatcher implements TextWatcher {

    private EditText userPassword;
    private EditText userConfirmPassword;
    private Button completeSignUpButton;
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,16})";

    public CompleteSignupTextWatcher(EditText userPassword, EditText userConfirmPassword, Button completeSignUpButton){
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;;
        this.completeSignUpButton = completeSignUpButton;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        System.out.println("In onTextChanged");
        String usrPassword = userPassword.getText().toString();
        String usrConfirmPassword = userConfirmPassword.getText().toString();

        if(!usrPassword.isEmpty() && !validatePassword(usrPassword)){
            userPassword.setError("Password must be 8-16 characters - at least 1 uppercase, 1 number, [@#$%!]");
        }
        else{
            userPassword.setError(null);
        }

        if(!usrPassword.isEmpty() && !usrConfirmPassword.isEmpty() && !matchPasswords(usrPassword, usrConfirmPassword)){
            userConfirmPassword.setError("Passwords don't match");
        }
        else{
            userConfirmPassword.setError(null);
        }

        boolean enableCompleteSignupButton = !(usrPassword.isEmpty() || !validatePassword(usrPassword)
                || usrConfirmPassword.isEmpty() || !matchPasswords(usrPassword, usrConfirmPassword));

        completeSignUpButton.setEnabled(enableCompleteSignupButton);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private boolean validatePassword(String usrPassword){
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(usrPassword);
        return matcher.matches();
    }

    private boolean matchPasswords(String usrPassword, String usrConfirmPassword){
        return usrPassword.contentEquals(usrConfirmPassword);
    }
}

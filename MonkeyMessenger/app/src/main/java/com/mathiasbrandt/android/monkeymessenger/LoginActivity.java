package com.mathiasbrandt.android.monkeymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {
    public static final String TAG = LoginActivity.class.getName();
    public static final String USER_NAME_KEY = "user_name_key";

    EditText inpName;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inpName = (EditText) findViewById(R.id.inpName);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        if(inpName.getText().toString().isEmpty()) {
            btnLogin.setEnabled(false);
        }

        inpName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Boolean handled = false;

                if(!v.getText().toString().isEmpty()) {
                    login();
                    handled = true;
                }

                Log.d(TAG, "handled: " + handled);
                return handled;
            }
        });

        inpName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    btnLogin.setEnabled(false);
                } else {
                    btnLogin.setEnabled(true);
                }
            }
        });
    }

    private void login() {
        btnLogin.setEnabled(false);

        ParseAnonymousUtils.logIn(new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "Login failed: " + e.toString());
                } else {
                    Intent i = new Intent(LoginActivity.this, FriendsActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    public void btnLoginOnClick(View v) {
        login();
    }
}

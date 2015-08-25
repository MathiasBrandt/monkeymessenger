package com.mathiasbrandt.android.monkeymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FriendsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        TextView txtName = (TextView) findViewById(R.id.txtUserName);
        txtName.setText(getIntent().getStringExtra(LoginActivity.USER_NAME_KEY));
    }

    public void btnGoOnOnClick(View v) {
        Intent i = new Intent(this, ChatActivity.class);
        startActivity(i);
    }
}

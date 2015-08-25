package com.mathiasbrandt.android.monkeymessenger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ChatActivity extends Activity {
    public static final String TAG = ChatActivity.class.getName();

    private EditText inpMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        inpMessage = (EditText) findViewById(R.id.inpMessage);
    }

    private void sendMessage() {
        sendMessage(inpMessage.getText().toString());
    }

    private void sendMessage(String msg) {
        Log.d(TAG, "Send message: " + msg);

        ParseObject message = new ParseObject("Message");
        message.put("USER_KEY", ParseUser.getCurrentUser().getObjectId());
        message.put("MESSAGE_KEY", msg);
        message.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null) {
                    Log.d(TAG, "error: " + e.toString());
                } else {
                    Log.d(TAG, "save done");
                    Toast.makeText(ChatActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                }
            }
        });

        inpMessage.setText("");
    }

    public void btnSendMessageOnClick(View v) {
        sendMessage();
    }
}

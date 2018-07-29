package com.localshopper.team.localshopper.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.localshopper.team.localshopper.R;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText feedbackMessageEdtTxt;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedbackMessageEdtTxt = findViewById(R.id.feedback_nsg_edtxt_act_feed);
        submitButton = findViewById(R.id.submit_feedback_btn_act_feed);
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit_feedback_btn_act_feed) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "helloshop@gmail.com", null));
//            TODO: change app name
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback of shopper app");
            emailIntent.putExtra(Intent.EXTRA_TEXT, feedbackMessageEdtTxt.getText().toString());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }
}

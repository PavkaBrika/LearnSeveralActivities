package com.example.learnseveralactivities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView textView = (TextView) findViewById(R.id.textview_about_content);

        String user = "Жывотное";
        String gift = "дырку от бублика";

        user = getIntent().getStringExtra("username");
        gift = getIntent().getExtras().getString("description");

        textView.setText(user + ", вам передали " + gift);
    }
}

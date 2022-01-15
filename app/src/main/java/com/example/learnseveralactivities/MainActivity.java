package com.example.learnseveralactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText user = (EditText) findViewById(R.id.edttxt1);
                EditText descr = (EditText) findViewById(R.id.edttxt2);
                EditText name = (EditText) findViewById(R.id.edttxt3);

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);

                intent.putExtra("username", user.getText().toString());
                intent.putExtra("description", descr.getText().toString());
                intent.putExtra("name",name.getText().toString());

                startActivity(intent);
            }
        });

    }
}
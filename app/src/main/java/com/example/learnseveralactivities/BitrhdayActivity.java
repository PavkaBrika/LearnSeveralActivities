package com.example.learnseveralactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BitrhdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitrhday);

        Button btnClose = (Button) findViewById(R.id.buttonClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        EditText edttxtName = (EditText) findViewById(R.id.editTextName);
        EditText edttxtCost = (EditText) findViewById(R.id.editTextCost);

        Button btnNext = (Button) findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent data = new Intent();
                data.putExtra(MainActivity.ITEM_KEY, edttxtName.getText().toString());
                data.putExtra(MainActivity.COST_KEY, Float.parseFloat(edttxtCost.getText().toString()));
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
package com.example.learnseveralactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String ITEM_KEY = "ITEM";
    public static final String COST_KEY = "COST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = (Button) findViewById(R.id.btn);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                EditText user = (EditText) findViewById(R.id.edttxt1);
//                EditText descr = (EditText) findViewById(R.id.edttxt2);
//                EditText name = (EditText) findViewById(R.id.edttxt3);
//
//                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
//
//                intent.putExtra("username", user.getText().toString());
//                intent.putExtra("description", descr.getText().toString());
//                intent.putExtra("name",name.getText().toString());
//
//                startActivity(intent);
//            }
//        });
//
//        Button aboutProgramm = (Button) findViewById(R.id.btn);
//        aboutProgramm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(MainActivity.this, BitrhdayActivity.class);
//                startActivity(intent2);
//            }
//        });

        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                TextView itemView = findViewById(R.id.TextViewName);
                TextView priceView = (TextView) findViewById(R.id.TextViewCost);
                if(result.getResultCode() == RESULT_OK){
                    Intent intent = result.getData();
                    String accessMessage = intent.getStringExtra(ITEM_KEY);
                   // float costkey = 10;
                    float costkey = intent.getFloatExtra(COST_KEY, 0);
                    itemView.setText(accessMessage);
                    priceView.setText(Float.toString(costkey));
                }
                else{
                    itemView.setText("Ошибка доступа");
                    priceView.setText("Error");
                }
            }
        });


        Button btn = (Button) findViewById(R.id.btnGo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BitrhdayActivity.class);

                startForResult.launch(intent);
            }
        });

    }
}
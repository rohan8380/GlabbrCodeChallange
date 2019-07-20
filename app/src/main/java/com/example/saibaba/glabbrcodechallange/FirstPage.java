package com.example.saibaba.glabbrcodechallange;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class FirstPage extends AppCompatActivity {

    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(FirstPage.this,VerifyNumber.class));
            }
        });
    }

}

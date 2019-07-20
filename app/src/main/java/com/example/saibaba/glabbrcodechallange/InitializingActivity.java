package com.example.saibaba.glabbrcodechallange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class InitializingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initializing);

        String s = "Success";
        SharedPreferences sp = getSharedPreferences("RegSuccess",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();

        ed.putString("Success",s);
        ed.commit();


        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                    startActivity(new Intent(InitializingActivity.this,ProfileInfo.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }

            }
        };
        t.start();
    }
}

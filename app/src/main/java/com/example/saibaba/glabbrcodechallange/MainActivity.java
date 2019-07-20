package com.example.saibaba.glabbrcodechallange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread()
        {
            public void run()
            {
                try {
                    Thread.sleep(1);

                    SharedPreferences sp = getSharedPreferences("RegSuccess",MODE_PRIVATE);
                    String Success = sp.getString("Success","No");

                    if(Success.equals("No"))
                    {
                        finish();
                        startActivity(new Intent(MainActivity.this,FirstPage.class));
                    }

                    else
                    {
                        finish();
                        startActivity(new Intent(MainActivity.this,HomePage.class));
                    }
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

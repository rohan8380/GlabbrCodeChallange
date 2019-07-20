package com.example.saibaba.glabbrcodechallange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class VerifyOtp extends AppCompatActivity {

    TextView txtNumber,txtNo,txtWrong;
    EditText txtOtp;
    String otp,otp2;
    ListView listView;
    String n;

    String[] option = {"Resend SMS","Call Me"};
    int[] icon = {R.mipmap.msg,R.mipmap.cal};

    int flag = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_otp);

        txtNumber = findViewById(R.id.txtNumber);
        txtNo = findViewById(R.id.txtNo);
        txtWrong = findViewById(R.id.txtWrong);
        txtOtp = findViewById(R.id.txtOtp);

        listView = findViewById(R.id.listView);
        MyClass mc = new MyClass();
        listView.setAdapter(mc);


        //get data from sp and set it to txtview

        SharedPreferences sp2 = getSharedPreferences("MyData",MODE_PRIVATE);

        String c = sp2.getString("CCode","No");
         n = sp2.getString("Number","No");

        txtNumber.setText("Verify "+c+" "+n);
        txtNo.setText(c + " " + n+".");
        
        Bundle b = getIntent().getExtras();
         otp = b.getString("OTP");


        // action erform during typing
        txtOtp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(flag==0)
                {
                    if(txtOtp.getText().toString().equals(otp))
                    {
                        Toast.makeText(VerifyOtp.this, "OTP Verified", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(VerifyOtp.this,InitializingActivity.class));
                    }
                    if (txtOtp.length() == 6 && !txtOtp.getText().toString().equals(otp))
                    {
                        Toast.makeText(VerifyOtp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    if(txtOtp.getText().toString().equals(otp2))
                    {
                        Toast.makeText(VerifyOtp.this, "OTP Verified", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(VerifyOtp.this,InitializingActivity.class));
                    }
                    if (txtOtp.length() == 6 && !txtOtp.getText().toString().equals(otp2))
                    {
                        Toast.makeText(VerifyOtp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
                if(i==0)
                {
                    flag = 1;
                    Random r = new Random();
                     otp2 = String.valueOf((100000+r.nextInt(899999)));

                    Toast.makeText(VerifyOtp.this, "OTP : "+otp2, Toast.LENGTH_SHORT).show();

                    /*txtOtp.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(txtOtp.getText().toString().equals(otp2))
                            {
                                Toast.makeText(VerifyOtp.this, "Welcome New User", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(VerifyOtp.this,InitializingActivity.class));

                            }


                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });*/
                }
            }
        });


    }
    public void wrong(View v)
    {
        finish();
        startActivity(new Intent(VerifyOtp.this,VerifyNumber.class));
        
    }

    class MyClass extends BaseAdapter
    {

        @Override
        public int getCount() {
            return option.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.call_msg_otp,null);
            ImageView img = view.findViewById(R.id.imgIcon);
            TextView txtOption = view.findViewById(R.id.txtOption);

           img.setImageResource(icon[i]);
           txtOption.setText(option[i]);

            return view;
        }
    }
}

package com.example.saibaba.glabbrcodechallange;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class VerifyNumber extends AppCompatActivity {

    View vi;
    Button btnNext;
    EditText txtNumber,txtCountryCode;
    Spinner spnCountry;
    String country[] = {"Select Country","Afganistan","Antartika","Argentina","Australia","Bangladesh","Belgium","Bhutan","Brazil","Canada","Chile","China","Colombia","Egypt","Finland","France","Germany","Greece","Hong-Kong","Iceland","India","Indonesia","Iran","Iraq","Israel","Italy","Japan","Myanmar","Namibia","Nepal","New Zealand","Singapore","Shri Lanka","Swedan","United Kingdom"," United State"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_number);

        btnNext = findViewById(R.id.btnNext);
        txtNumber = findViewById(R.id.txtNumber);
        spnCountry = findViewById(R.id.spnCountry);
        txtCountryCode = findViewById(R.id.txtCountryCode);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_items,R.id.txtSpnItem,country);
        spnCountry.setAdapter(adapter);

        spnCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String s = adapterView.getSelectedItem().toString();
                Toast.makeText(VerifyNumber.this, "You Selected : "+s, Toast.LENGTH_SHORT).show();

                if(i==0)
                {
                    txtCountryCode.setText("");

                }
                else if(i==1)
                {
                    txtCountryCode.setText("+93");
                }
                else if(i==2)
                {
                    txtCountryCode.setText("+672");
                }
                else if(i==3)
                {
                    txtCountryCode.setText("+54");
                }
                else if(i==4)
                {
                    txtCountryCode.setText("+61");
                }
                else if(i==5)
                {
                    txtCountryCode.setText("+880");
                }
                else if(i==6)
                {
                    txtCountryCode.setText("+32");
                }
                else if(i==7)
                {
                    txtCountryCode.setText("+975");
                }
                else if(i==8)
                {
                    txtCountryCode.setText("+55");
                }
                else if(i==9)
                {
                    txtCountryCode.setText("+1");
                }
                else if(i==10)
                {
                    txtCountryCode.setText("+56");
                }
                else if(i==11)
                {
                    txtCountryCode.setText("+86");
                }
                else if(i==12)
                {
                    txtCountryCode.setText("+57");
                }
                else if(i==13)
                {
                    txtCountryCode.setText("+20");
                }
                else if(i==14)
                {
                    txtCountryCode.setText("+358");
                }
                else if(i==15)
                {
                    txtCountryCode.setText("+33");
                }
                else if(i==16)
                {
                    txtCountryCode.setText("+49");
                }
                else if(i==17)
                {
                    txtCountryCode.setText("+30");
                }
                else if(i==18)
                {
                    txtCountryCode.setText("+852");
                }
                else if(i==19)
                {
                    txtCountryCode.setText("+354");
                }
                else if(i==20)
                {
                    txtCountryCode.setText("+91");
                }
                else if(i==21)
                {
                    txtCountryCode.setText("+62");
                }
                else if(i==22)
                {
                    txtCountryCode.setText("+98");
                }
                else if(i==23)
                {
                    txtCountryCode.setText("+964");
                }
                else if(i==24)
                {
                    txtCountryCode.setText("+972");
                }
                else if(i==25)
                {
                    txtCountryCode.setText("+39");
                }
                else if(i==26)
                {
                    txtCountryCode.setText("+81");

                }
                else if(i==27)
                {
                    txtCountryCode.setText("+95");
                }
                else if(i==28)
                {
                    txtCountryCode.setText("+264");
                }
                else if(i==29)
                {
                    txtCountryCode.setText("+977");
                }
                else if(i==30)
                {
                    txtCountryCode.setText("+64");
                }
                else if(i==31)
                {
                    txtCountryCode.setText("+65");
                }
                else if(i==32)
                {
                    txtCountryCode.setText("+94");
                }
                else if(i==33)
                {
                    txtCountryCode.setText("+46");
                }
                else if(i==34)
                {
                    txtCountryCode.setText("+44");
                }
                else if(i==35)
                {
                    txtCountryCode.setText("+1");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
    public void next(View v)
    {
        SharedPreferences sp = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("Number",txtNumber.getText().toString().trim());
        ed.putString("CCode",txtCountryCode.getText().toString().trim());
        ed.commit();


        if(txtNumber.getText().toString().equals(null) || txtNumber.getText().length()<10)
        {
            AlertDialog.Builder dia = new AlertDialog.Builder(VerifyNumber.this);
            dia.setMessage("Plese enter your phone number.");
            dia.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dia.setCancelable(false);
            dia.show();

        }
        else
        {
            LayoutInflater li = LayoutInflater.from(VerifyNumber.this);

            vi = li.inflate(R.layout.edit_number,null);


            TextView txtMobNo = vi.findViewById(R.id.txtMobNo);
            SharedPreferences sp1 = getSharedPreferences("MyData",MODE_PRIVATE);

            String s = sp1.getString("Number","No");
            String c = sp1.getString("CCode","No");

            txtMobNo.setText(c +" "+ s);

            AlertDialog.Builder dlg = new AlertDialog.Builder(VerifyNumber.this);
            dlg.setView(vi);




            dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   TextView txtMobNo = vi.findViewById(R.id.txtMobNo);
                    txtMobNo.setText(txtNumber.getText().toString().trim());

                    Random r = new Random();
                    String otp = String.valueOf((100000+r.nextInt(899999)));
                    Toast.makeText(VerifyNumber.this, "OTP is : "+otp, Toast.LENGTH_SHORT).show();
                   //go to next activity
                    finish();
                    Intent intnt = new Intent(VerifyNumber.this,VerifyOtp.class);
                    intnt.putExtra("OTP",otp);
                    startActivity(intnt);
                   // startActivity(new Intent(getApplicationContext(),VerifyOtp.class));

                }
            });

            dlg.setNegativeButton("EDIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dlg.setCancelable(false);
            dlg.show();

        }

    }

}





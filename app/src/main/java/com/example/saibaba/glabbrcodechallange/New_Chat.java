package com.example.saibaba.glabbrcodechallange;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


public class New_Chat extends AppCompatActivity {

    TextView txtUName,txtOnlineStatus;

    String UName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_chat);

        txtUName = findViewById(R.id.txtUName);
        txtOnlineStatus = findViewById(R.id.txtOnlineStatus);

        Bundle B  = getIntent().getExtras();
        UName = B.getString("Name");

        txtUName.setText(UName);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

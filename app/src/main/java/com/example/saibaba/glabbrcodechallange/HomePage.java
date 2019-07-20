package com.example.saibaba.glabbrcodechallange;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


public class HomePage extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    TabsAccess tabsAccess;

    //contact Fragment



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = findViewById(R.id.appBarLayout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabsAccess = new TabsAccess(getSupportFragmentManager());
        viewPager.setAdapter(tabsAccess);

        tabLayout.setupWithViewPager(viewPager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId())
        {
            case R.id.itmgroup:
                Toast.makeText(this, "New Group", Toast.LENGTH_SHORT).show();
                break;

            case R.id.searchh:
                SearchView searchView;
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.saibaba.glabbrcodechallange;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class ProfileInfo extends AppCompatActivity {

    ImageView imgCam;
    EditText txtName;
    Bitmap bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_info);

        imgCam = findViewById(R.id.imgCam);
        txtName = findViewById(R.id.txtName);


    }

    public void option(View v)
    {
        PopupMenu popupMenu = new PopupMenu(ProfileInfo.this,imgCam);
        popupMenu.getMenuInflater().inflate(R.menu.mymenu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.itmCamera:
                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i,101);
                        break;

                    case R.id.itmGallary:

                        Intent i2 = new Intent(Intent.ACTION_PICK);
                        i2.setType("image/*");  // all types of images
                        startActivityForResult(i2,102);
                        //Toast.makeText(ProfileInfo.this, "Gallary", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101 && resultCode== Activity.RESULT_OK)
        {
            bmp = (Bitmap) data.getExtras().get("data");
            imgCam.setImageBitmap(bmp);
        }
        if(requestCode==102 && resultCode==Activity.RESULT_OK)
        {
            Uri selImg = data.getData();

            try
            {
                InputStream inputStream = getContentResolver().openInputStream(selImg);
                bmp = BitmapFactory.decodeStream(inputStream);
                imgCam.setImageBitmap(bmp);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void next(View v)
    {
        finish();
        startActivity(new Intent(ProfileInfo.this,HomePage.class));
    }


    }

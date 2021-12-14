package com.rsudalihsan.ibs.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rsudalihsan.ibs.R;

public class PusatBantuanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pusat_bantuan);

        TextView website =findViewById(R.id.weblink);
        website.setMovementMethod(LinkMovementMethod.getInstance());

        LinearLayout facebook = findViewById(R.id.btnFbInfo);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http//facebook.com/_u//rsudalihsan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.facebook.android");
                try {
                    Toast.makeText(PusatBantuanActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/rsudalihsan/")));
                }
            }
        });


        LinearLayout twitter = findViewById(R.id.btnTwitterInfo);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http//twitter.com/_u//rsudalihsan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.twitter.android");
                try {
                    Toast.makeText(PusatBantuanActivity.this, "twitter", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/rsudalihsan/")));
                }
            }
        });

        LinearLayout instagram = findViewById(R.id.btnInstaInfo);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http//instagram.com/_u//rsudalihsan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");
                try {
                    Toast.makeText(PusatBantuanActivity.this, "instagram", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/rsudalihsan/")));
                }
            }
        });

        LinearLayout googleMaps = findViewById(R.id.btnLokasi);
        googleMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://goo.gl/maps/wBgAYdYBPv1qW8MN9");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android");
                try {
                    Toast.makeText(PusatBantuanActivity.this, "maps", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/wBgAYdYBPv1qW8MN9")));
                }
            }
        });

        ImageView imageMaps = findViewById(R.id.imglokasi);
        imageMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://goo.gl/maps/wBgAYdYBPv1qW8MN9");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android");
                try {
                    Toast.makeText(PusatBantuanActivity.this, "maps", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/wBgAYdYBPv1qW8MN9")));
                }
            }
        });
    }
    }

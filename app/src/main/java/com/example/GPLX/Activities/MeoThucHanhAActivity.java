package com.example.GPLX.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.GPLX.R;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MeoThucHanhAActivity extends AppCompatActivity {
    TextView tv_kinhNghiemThiA;
    androidx.appcompat.widget.Toolbar toolbar;
    int dem = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanha);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tv_kinhNghiemThiA = findViewById(R.id.tv_kinhNghiemThiA);
        tv_kinhNghiemThiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeoThucHanhAActivity.this,KinhNghiemThiAActivity.class);
                startActivity(intent);
                MainActivity.dem9++;
                if (MainActivity.dem9==3 || MainActivity.checkTime){
                    MainActivity.dem9 = 0;
                    MainActivity.checkTime = false;
                }
            }
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);
    }
}

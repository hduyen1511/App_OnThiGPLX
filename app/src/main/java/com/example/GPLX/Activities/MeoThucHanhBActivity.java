package com.example.GPLX.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.GPLX.R;

//import com.google.android.gms.ads.InterstitialAd;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MeoThucHanhBActivity extends AppCompatActivity {
    TextView tv_kinhNghiemThiB;
    Toolbar toolbar;
    int dem = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanhb);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tv_kinhNghiemThiB = findViewById(R.id.tv_kinhNghiemThiB);
        tv_kinhNghiemThiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeoThucHanhBActivity.this,KinhNghiemThiBActivity.class);
                startActivity(intent);
                MainActivity.dem10++;
                if (MainActivity.dem10==3 || MainActivity.checkTime){
                    MainActivity.dem10 = 0;
                    MainActivity.checkTime = false;
                }
            }
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);
    }
}

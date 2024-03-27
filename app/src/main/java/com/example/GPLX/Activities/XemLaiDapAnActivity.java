package com.example.GPLX.Activities;

import static com.example.GPLX.Activities.ThiSatHachActivity.SIZE;
import static com.example.GPLX.Activities.ThiSatHachActivity.checkDungSai;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.example.GPLX.Adapter.AdapterRecyclerViewLichSuBaiThi;
import com.example.GPLX.Adapter.AdapterRecyclerViewXemDapAn;
import com.example.GPLX.DAO.CauHoiDAO;
import com.example.GPLX.Object.CauHoi;
import com.example.GPLX.R;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class XemLaiDapAnActivity extends AppCompatActivity {
    RecyclerView rcv_xemDapAn;
    CauHoiDAO cauHoiDAO;
    public static List<CauHoi> list;
    List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
    AdapterRecyclerViewXemDapAn adapterRecyclerViewXemDapAn;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemlaidapan);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_xemDapAn = findViewById(R.id.rcv_xemDapAn);
        cauHoiDAO = new CauHoiDAO(this);
        listCauHoi = cauHoiDAO.getListCauHoi();
        list = new ArrayList<>();
        if (getIntent().getCharExtra("from",' ')=='l') {
            list = AdapterRecyclerViewLichSuBaiThi.getListCauHoi();
            adapterRecyclerViewXemDapAn = new AdapterRecyclerViewXemDapAn(this,list,checkDungSai,'l');
        }
        else {
            for (int i=0;i<SIZE;i++){
                this.list.add(ThiSatHachActivity.list.get(i));
            }
            adapterRecyclerViewXemDapAn = new AdapterRecyclerViewXemDapAn(this,list,checkDungSai,'t');
        }
        rcv_xemDapAn.setAdapter(adapterRecyclerViewXemDapAn);
        rcv_xemDapAn.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        OverScrollDecoratorHelper.setUpOverScroll(rcv_xemDapAn, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        RecyclerViewHeader header = findViewById(R.id.header);
        header.attachTo(rcv_xemDapAn);
    }
}

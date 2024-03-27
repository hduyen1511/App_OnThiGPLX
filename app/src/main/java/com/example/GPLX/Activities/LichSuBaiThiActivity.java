package com.example.GPLX.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.example.GPLX.Adapter.AdapterRecyclerViewLichSuBaiThi;
import com.example.GPLX.MyItemDecoration;
import com.example.GPLX.Object.DeThi;
import com.example.GPLX.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LichSuBaiThiActivity extends AppCompatActivity {
    RecyclerView rcv_lichSuBaiThi;
    AdapterRecyclerViewLichSuBaiThi adapterRecyclerViewLichSuBaiThi;
    List<DeThi> listDeThi;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsubaithi);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_lichSuBaiThi = findViewById(R.id.rcv_lichSuBaiThi);
        listDeThi = docFile("lichsu.txt");
        adapterRecyclerViewLichSuBaiThi = new AdapterRecyclerViewLichSuBaiThi(this,listDeThi);
        rcv_lichSuBaiThi.setLayoutManager(new GridLayoutManager(this,4));
        rcv_lichSuBaiThi.addItemDecoration(new MyItemDecoration(this, R.dimen.item_offset));
        rcv_lichSuBaiThi.setAdapter(adapterRecyclerViewLichSuBaiThi);
        Log.d("SIZE",listDeThi.size()+"");
    }
    public List<DeThi> docFile(String fileName){
        List<DeThi> listDeThi = new ArrayList<>();
        try {
            File file = getFileStreamPath(fileName);
            if (file==null||!file.exists()){
                file = new File(fileName);
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listDeThi = (List<DeThi>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listDeThi;
    }
}

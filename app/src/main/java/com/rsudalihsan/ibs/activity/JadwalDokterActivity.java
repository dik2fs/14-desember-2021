package com.rsudalihsan.ibs.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rsudalihsan.ibs.R;
import com.rsudalihsan.ibs.adapter.JadwalDokterAdapter;
import com.rsudalihsan.ibs.model.JadwalDokterItem;

import java.util.ArrayList;

public class JadwalDokterActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_dokter);

        ArrayList<JadwalDokterItem> jadwaldokterList = new ArrayList<>();
        jadwaldokterList.add(new JadwalDokterItem(R.drawable.ic_dokterumum, "Dokter Umum", "10 Dokter"));
        jadwaldokterList.add(new JadwalDokterItem(R.drawable.ic_obgyn, "Obgyn", "7 Dokter"));
        jadwaldokterList.add(new JadwalDokterItem(R.drawable.ic_penyakitanak, "Penyakit Anak", "5 Dokter"));

        mRecycleView = findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new JadwalDokterAdapter(jadwaldokterList);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

    }
}
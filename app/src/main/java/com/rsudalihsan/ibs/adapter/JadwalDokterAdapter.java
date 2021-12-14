package com.rsudalihsan.ibs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsudalihsan.ibs.R;
import com.rsudalihsan.ibs.model.JadwalDokterItem;

import java.util.ArrayList;

public class JadwalDokterAdapter extends RecyclerView.Adapter<JadwalDokterAdapter.JadwalDokterViewHolder> {

    private ArrayList<JadwalDokterItem> mJawalDokterList;
    public static class JadwalDokterViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public JadwalDokterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_item);
            mTextView1 = itemView.findViewById(R.id.tv_line1);
            mTextView2 = itemView.findViewById(R.id.tv_line2);
        }
    }

    public JadwalDokterAdapter(ArrayList<JadwalDokterItem> jadwaldokterList) {
        mJawalDokterList = jadwaldokterList;
    }

    @NonNull
    @Override
    public JadwalDokterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_dokter_item, parent, false);
        JadwalDokterViewHolder jdvh = new JadwalDokterViewHolder(v);
        return jdvh;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalDokterViewHolder holder, int position) {
        JadwalDokterItem currentItem = mJawalDokterList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mJawalDokterList.size();
    }
}

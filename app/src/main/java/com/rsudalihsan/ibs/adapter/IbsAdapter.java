package com.rsudalihsan.ibs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rsudalihsan.ibs.R;
import com.rsudalihsan.ibs.model.IbsDataItem;

import java.util.List;

public class IbsAdapter extends RecyclerView.Adapter<IbsAdapter.ViewHolder> {

    private List<IbsDataItem> mItemList;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomor_urut;
        TextView nama_pasien;
        TextView nomor_medrek;
        TextView operator;
        TextView keterangan;

        public ViewHolder(View v) {
            super(v);
            nomor_urut = v.findViewById(R.id.nomor_urut);
            nama_pasien = v.findViewById(R.id.nama_pasien);
            nomor_medrek = v.findViewById(R.id.nomor_medrek);
            operator = v.findViewById(R.id.operator);
            keterangan = v.findViewById(R.id.keterangan);
        }
    }

    public IbsAdapter(List<IbsDataItem> mItemList, Context context) {
        this.mItemList = mItemList;
        this.context = context;
    }

    @Override
    public IbsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ibs, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        IbsDataItem item = mItemList.get(position);
        holder.nomor_urut.setText(item.getNomorUrut());
        holder.nama_pasien.setText(item.getNamaPasien());
        holder.nomor_medrek.setText(item.getNomorMedrek());
        holder.operator.setText(item.getOperator());
        holder.keterangan.setText(item.getKeterangan());

        holder.itemView.setOnClickListener(v -> {
            //
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
package com.frisca.uas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.frisca.uas.R;
import com.frisca.uas.model.DataDiriModel;

import java.util.ArrayList;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.MyViewHolder> {

    Context context;
    ArrayList<DataDiriModel> listData;

    public DataDiriAdapter(Context context, ArrayList<DataDiriModel> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_diri, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.nama.setText(listData.get(position).getNama());
        holder.nim.setText(listData.get(position).getNim());
        holder.alamat.setText(listData.get(position).getAlamat());
        holder.nohp.setText(listData.get(position).getNohp());
        holder.jurusan.setText(listData.get(position).getJurusan());
        holder.kelas.setText(listData.get(position).getKelas());

        String kunci = listData.get(position).getKey();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama, nim, alamat, nohp, jurusan, kelas;

        public MyViewHolder(@Nullable View view) {
            super(view);

            nama = view.findViewById(R.id.namaread);
            nim = view.findViewById(R.id.nimread);
            alamat = view.findViewById(R.id.alamatread);
            nohp = view.findViewById(R.id.nohpread);
            jurusan = view.findViewById(R.id.jurusanread);
            kelas = view.findViewById(R.id.kelasread);
        }
    }
}

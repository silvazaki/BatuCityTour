package com.silva.pariwisata.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.silva.pariwisata.R;
import com.silva.pariwisata.model.kategori.Kategori;

import java.util.List;


/**
 * Created by Silva on 10/02/2018.
 */

public class ListKategoriAdapter extends RecyclerView.Adapter<ListKategoriAdapter.MyViewHolder>{

    private View itemView;
    private Context context;
    private List<Kategori> kategoriList;

    public ListKategoriAdapter(Context context, List<Kategori> kategoriList) {
        this.context = context;
        this.kategoriList = kategoriList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_grid_kategori, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Kategori kategori = kategoriList.get(position);
        holder.textView.setText(kategori.getNama_kategori());
        Picasso.with(context).load(kategori.getGambar_kategori()).placeholder(R.drawable.placeholder).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView  imageView;
        protected TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambar_kategori);
            textView = itemView.findViewById(R.id.nama_kategori);
        }
    }
}

package com.silva.pariwisata.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.pariwisata.R;
import com.silva.pariwisata.loopj.Url;
import com.silva.pariwisata.model.kategori.Kategori;
import com.silva.pariwisata.model.komentar.Komentar;
import com.silva.pariwisata.view.activity.KategoriTempatActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Silva on 10/02/2018.
 */

public class ListKomentarAdapter extends RecyclerView.Adapter<ListKomentarAdapter.MyViewHolder> {

    private View itemView;
    private List<Komentar> komentarList;


    public ListKomentarAdapter( List<Komentar> dataKomentar) {
        komentarList = dataKomentar;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_komentar, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Komentar komentar = komentarList.get(position);
        holder.tv_isi.setText(komentar.getUsername());
        holder.tv_user.setText(komentar.getKomentar());
    }

    @Override
    public int getItemCount() {
        return komentarList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_user, tv_isi;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_isi = itemView.findViewById(R.id.username);
            tv_user = itemView.findViewById(R.id.isi);
        }
    }
}

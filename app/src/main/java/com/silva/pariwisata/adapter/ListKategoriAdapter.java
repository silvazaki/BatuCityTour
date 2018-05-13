package com.silva.pariwisata.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.pariwisata.R;
import com.silva.pariwisata.loopj.Url;
import com.silva.pariwisata.model.kategori.Kategori;
import com.silva.pariwisata.view.activity.KategoriTempatActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Silva on 10/02/2018.
 */

public class ListKategoriAdapter extends RecyclerView.Adapter<ListKategoriAdapter.MyViewHolder> {

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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Kategori kategori = kategoriList.get(position);
        holder.textView.setText(kategori.getNama_kategori());
        Picasso.with(context).load(Url.BASE_URL + kategori.getGambar_kategori()).placeholder(R.drawable.placeholder).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, KategoriTempatActivity.class);
                intent.putExtra("id_kategori", kategori.getId_kategori());
                intent.putExtra("gambar_wisata", Url.BASE_URL + kategori.getGambar_kategori());
                intent.putExtra("title", kategori.getNama_kategori());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                    String transitionName = "image";
                    View transitionView = view.findViewById(R.id.gambar_kategori);
                    ViewCompat.setTransitionName(transitionView, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context, transitionView, transitionName);
                    context.startActivity(intent, options.toBundle());
                } else {
                    intent.putExtra("gambar_wisata", Url.BASE_URL + kategori.getGambar_kategori());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.gambar_kategori);
            textView = itemView.findViewById(R.id.nama_kategori);
        }
    }
}

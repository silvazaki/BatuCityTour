package com.silva.pariwisata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.silva.pariwisata.R;
import com.silva.pariwisata.adapter.ListKategoriTempatAdapter;
import com.silva.pariwisata.model.Hasil;
import com.silva.pariwisata.model.database.LocalData;
import com.silva.pariwisata.model.semua.Getsemuakategori;
import com.silva.pariwisata.model.semua.Semua;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class KategoriTempatActivity extends AppCompatActivity {

    protected RecyclerView list;
    ListKategoriTempatAdapter adapter;
    String TAG = "detkategori";
    List<Semua> data = new ArrayList<>();
    private String idKategori, title;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void init() {
        idKategori = String.valueOf(getIntent().getStringExtra("id_kategori"));
        title = String.valueOf(getIntent().getStringExtra("title"));
        String gambar = getIntent().getStringExtra("gambar_wisata");
        ImageView imageView = findViewById(R.id.imageCategory);
        list = findViewById(R.id.recycler_view);
        adapter = new ListKategoriTempatAdapter(this, data);
        supportPostponeEnterTransition();
        Picasso.with(this)
                .load(gambar)
                .fit()
                .noFade()
                .centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });
    }

    public void getData() {
        new Getsemuakategori().get(this, idKategori, new Hasil() {
            @Override
            public void sukses() {
                Log.e(TAG, "sukses: ");
                data.clear();
                data.addAll(LocalData.getSemuaKategori());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void gagal() {
                Log.d(TAG, "gagal: ");
            }
        });
    }

    public void getSemuaListTempat() {
//        if (LocalData.getSemuaKategori().isEmpty()) {
            getData();
//        } else {
//            Log.d(TAG, "getSemuaListTempat: ");
//            data.addAll(LocalData.getSemuaKategori());
//            adapter.notifyDataSetChanged();
//        }
    }

    private void setSemuaListTempat() {
        list.setItemAnimator(new DefaultItemAnimator());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_tempat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();
        getSupportActionBar().setTitle(title);

        getSemuaListTempat();
        setSemuaListTempat();
    }
}

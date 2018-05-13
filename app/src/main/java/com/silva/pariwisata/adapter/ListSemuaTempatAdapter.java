package com.silva.pariwisata.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
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
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.model.semua.Semua;
import com.silva.pariwisata.view.activity.DetailTempatActivity;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;


/**
 * Created by Silva on 10/02/2018.
 */

public class ListSemuaTempatAdapter extends RecyclerView.Adapter<ListSemuaTempatAdapter.MyViewHolder> {

    private View itemView;
    private Context context;
    private List<Semua> semuaList;
    private PrefManager prefManager;

    public ListSemuaTempatAdapter(Context context, List<Semua> kategoriList) {
        this.context = context;
        this.semuaList = kategoriList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_grid_tempat, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Semua semua = semuaList.get(position);
        holder.txtNama.setText(semua.getNama_wisata());
        final String jarak = String.valueOf(
                getDistance(
                        Double.parseDouble(prefManager.getPrefSring("latitude")),
                        Double.parseDouble(prefManager.getPrefSring("longitude")),
                        Double.parseDouble(semua.getLatitude()),
                        Double.parseDouble(semua.getLongitude())));
        holder.txtJarak.setText(jarak + " km");
        Picasso.with(context).load(Url.BASE_URL + semua.getGambar()).placeholder(R.drawable.placeholder).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailTempatActivity.class);
                intent.putExtra("nama_wisata", semua.getNama_wisata());
                intent.putExtra("kategori_wisata", semua.getNama_kategori());
                intent.putExtra("detail_wisata", semua.getDetail_wisata());
                intent.putExtra("alamat_wisata", semua.getAlamat());
                intent.putExtra("jadwal_wisata", semua.getJadwal_buka());
                intent.putExtra("harga_wisata", semua.getHarga_tiket());
                intent.putExtra("telepon_wisata", semua.getNo_telepon());
                intent.putExtra("jenis_harga", semua.getJenis_kategori());
                intent.putExtra("latitude", semua.getLatitude());
                intent.putExtra("longitude", semua.getLongitude());
                intent.putExtra("jarak_wisata", jarak);
                intent.putExtra("gambar_wisata", Url.BASE_URL + semua.getGambar());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context,
                                    holder.imageView,
                                    ViewCompat.getTransitionName(holder.imageView));
                    context.startActivity(intent, options.toBundle());
                } else {
                    intent.putExtra("gambar_wisata", Url.BASE_URL + semua.getGambar());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return semuaList.size();
    }

    public String getDistance(double lat1, double lon1, double lat2, double lon2) {
        Location loc1 = new Location("");
        loc1.setLatitude(lat1);
        loc1.setLongitude(lon1);

        Location loc2 = new Location("");
        loc2.setLatitude(lat2);
        loc2.setLongitude(lon2);
        Double d = 0.0;
        d = Double.valueOf(loc1.distanceTo(loc2) / 1000);
        DecimalFormat df = new DecimalFormat("#.###");
        String dx = df.format(d);
        return dx;
//        float distance = loc1.distanceTo(loc2);
//        return String.format(Locale.getDefault(), "%.0f km", distance / 1000);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView txtNama, txtJarak;
        protected CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            prefManager = new PrefManager(context);
            cardView = itemView.findViewById(R.id.cvListSemua);
            imageView = itemView.findViewById(R.id.imgSemua);
            txtNama = itemView.findViewById(R.id.txtNamaTempat);
            txtJarak = itemView.findViewById(R.id.txtJarak);
        }
    }
}

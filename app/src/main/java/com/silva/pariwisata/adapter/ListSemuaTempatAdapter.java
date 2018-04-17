package com.silva.pariwisata.adapter;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.pariwisata.R;
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.model.semua.Semua;
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Semua semua = semuaList.get(position);
        holder.txtNama.setText(semua.getNama_wisata());
        holder.txtJarak.setText(String.valueOf(
                getDistance(
                        Double.parseDouble(prefManager.getPrefSring("latitude")),
                        Double.parseDouble(prefManager.getPrefSring("longitude")),
                        Double.parseDouble(semua.getLatitude()),
                        Double.parseDouble(semua.getLatitude()))) + " km");
        Picasso.with(context).load(semua.getGambar()).placeholder(R.drawable.placeholder).into(holder.imageView);

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
        d = Double.valueOf(loc1.distanceTo(loc2) / 100000);
        d /= 10;
        DecimalFormat df = new DecimalFormat("#.###");
        String dx = df.format(d);
        return dx;
//        float distance = loc1.distanceTo(loc2);
//        return String.format(Locale.getDefault(), "%.0f km", distance / 1000);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView txtNama, txtJarak;

        public MyViewHolder(View itemView) {
            super(itemView);
            prefManager = new PrefManager(context);
            imageView = itemView.findViewById(R.id.imgSemua);
            txtNama = itemView.findViewById(R.id.txtNamaTempat);
            txtJarak = itemView.findViewById(R.id.txtJarak);
        }
    }
}

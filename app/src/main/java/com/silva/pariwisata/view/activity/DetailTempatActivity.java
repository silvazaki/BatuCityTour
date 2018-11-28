package com.silva.pariwisata.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Route;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.silva.pariwisata.R;
import com.silva.pariwisata.adapter.ListKomentarAdapter;
import com.silva.pariwisata.model.InterfaceKomentar;
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.model.komentar.Getkomentar;
import com.silva.pariwisata.model.komentar.Komentar;
import com.silva.pariwisata.service.TambahKomentarService;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DetailTempatActivity extends AppCompatActivity  implements OnMapReadyCallback , DirectionCallback {

    private ImageView imageView;
    private TextView txtNama, txtKategori, txtDetail, txtAlamat, txtJadwal, txtHarga, txtTelepon, txtJarak, txtTiket, txtKomentar;
    private String latitude, longitude;
    private Button btnRequestDirection;
    private GoogleMap googleMap;
    private String serverKey = "AIzaSyDjnj_E_lx80CyDIfoglUC4Nzdy5bwMMeE";
    private LatLng origin;
    private LatLng destination;
    private PrefManager prefManager;
    private List<Komentar> dataKomentar = new ArrayList<>();
    private RecyclerView list;
    private ListKomentarAdapter adapterKomentar;
    private RecyclerView.LayoutManager layoutManager;
    private String id;
    String TAG = "map2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
        prefManager = new PrefManager(this);

        id = getIntent().getStringExtra("id_wisata");
        String nama = getIntent().getStringExtra("nama_wisata");
        String kategori = getIntent().getStringExtra("kategori_wisata");
        String detail = getIntent().getStringExtra("detail_wisata");
        String alamat = getIntent().getStringExtra("alamat_wisata");
        String jadwal = getIntent().getStringExtra("jadwal_wisata");
        String harga = getIntent().getStringExtra("harga_wisata");
        String telepon = getIntent().getStringExtra("telepon_wisata");
        String jarak = getIntent().getStringExtra("jarak_wisata");
        String gambar = getIntent().getStringExtra("gambar_wisata");
        String tiket = getIntent().getStringExtra("jenis_harga");
        latitude = getIntent().getStringExtra("latitude");
        longitude = getIntent().getStringExtra("longitude");


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imageView = findViewById(R.id.image);
        txtNama = findViewById(R.id.txtNama);
        txtDetail = findViewById(R.id.txtDetail);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtHarga = findViewById(R.id.txtHarga);
        txtJadwal = findViewById(R.id.txtJadwal);
        txtJarak = findViewById(R.id.txtJarak);
        txtKategori = findViewById(R.id.txtKategori);
        txtTelepon = findViewById(R.id.txtTelepon);
        txtTiket = findViewById(R.id.txtKategoriHarga);
        txtKomentar = findViewById(R.id.keterangan_komentar);
        list = findViewById(R.id.rv_main_doa_member);

        getData();

        adapterKomentar = new ListKomentarAdapter(dataKomentar);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapterKomentar);


        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        btnRequestDirection = findViewById(R.id.btn_request_direction);

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
        txtTelepon.setText(telepon);
        txtKategori.setText(kategori);
        txtJarak.setText(jarak+" Km");
        txtJadwal.setText(jadwal);
        txtHarga.setText(harga);
        txtAlamat.setText(alamat);
        txtDetail.setText(detail);
        txtNama.setText(nama);
        txtTiket.setText(tiket);

        origin = new LatLng(Double.parseDouble(prefManager.getPrefSring("latitude")),
                Double.parseDouble(prefManager.getPrefSring("longitude")));
        destination = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

        btnRequestDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestDirection();
            }
        });



    }
    public void showOnMap(View view) {
//        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("http://maps.google.com/maps?daddr=" + latitude+ "," + longitude));
//        startActivity(intent);
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("latlong", latitude+","+longitude);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
        adapterKomentar = new ListKomentarAdapter(dataKomentar);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapterKomentar);
    }

    public void requestDirection() {
        Snackbar.make(btnRequestDirection, "Direction Requesting...", Snackbar.LENGTH_SHORT).show();
        GoogleDirection.withServerKey(serverKey)
                .from(origin)
                .to(destination)
                .transportMode(TransportMode.TRANSIT)
                .execute(this);
    }
    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
        Snackbar.make(btnRequestDirection, "Success with status : " + direction.getStatus(), Snackbar.LENGTH_SHORT).show();
        if (direction.isOK()) {
            Route route = direction.getRouteList().get(0);
            googleMap.addMarker(new MarkerOptions().position(origin).title("Lokasi Anda"));
            googleMap.addMarker(new MarkerOptions().position(destination).title(txtNama.getText().toString()));

            ArrayList<LatLng> directionPositionList = route.getLegList().get(0).getDirectionPoint();
            googleMap.addPolyline(DirectionConverter.createPolyline(this, directionPositionList, 5, Color.RED));
            setCameraWithCoordinationBounds(route);

        } else {
            Snackbar.make(btnRequestDirection, direction.getStatus(), Snackbar.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDirectionFailure(Throwable t) {
        Snackbar.make(btnRequestDirection, "Koneksi terputus", Snackbar.LENGTH_SHORT).show();
    }
    private void setCameraWithCoordinationBounds(Route route) {
        LatLng southwest = route.getBound().getSouthwestCoordination().getCoordination();
        LatLng northeast = route.getBound().getNortheastCoordination().getCoordination();
        LatLngBounds bounds = new LatLngBounds(southwest, northeast);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void getData(){
        new Getkomentar().get(this, id, new InterfaceKomentar() {
            @Override
            public void sukses(List<Komentar> komentarList) {
                dataKomentar.clear();
                dataKomentar.addAll(komentarList);
                adapterKomentar.notifyDataSetChanged();
                if (dataKomentar==null)
                    txtKomentar.setVisibility(View.VISIBLE);
            }

            @Override
            public void gagal() {

            }
        });
    }

    public void tambahKomentar(View view) {
        if (prefManager.getPrefSring("user_id")!=null) {
            Intent i = new Intent(getApplicationContext(), KirimKomentarActivity.class);
            i.putExtra("id_wisata", id);
            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }
    }
}

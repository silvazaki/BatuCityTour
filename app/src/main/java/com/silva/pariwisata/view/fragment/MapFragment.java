package com.silva.pariwisata.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.silva.pariwisata.R;
import com.silva.pariwisata.model.Hasil;
import com.silva.pariwisata.model.database.LocalData;
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.model.semua.Getsemua;
import com.silva.pariwisata.model.semua.Semua;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private View view;
    private PrefManager prefManager;
    private Button btnRequestDirection;
    private GoogleMap googleMap;
    private String serverKey = "AIzaSyDjnj_E_lx80CyDIfoglUC4Nzdy5bwMMeE";
    private LatLng origin;
    private LatLng destination;
    String TAG = "map2";
    List<Semua> data = new ArrayList<>();

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);

        prefManager = new PrefManager(getContext());
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        getSemuaListTempat();



        return view;
    }

    public void getData() {
        new Getsemua().get(getContext(), new Hasil() {
            @Override
            public void sukses() {
                Log.e(TAG, "sukses: ");
                data.clear();
                data.addAll(LocalData.getSemuaList());
                for (int i = 0; i < data.size(); i++) {
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(
                            Double.parseDouble(data.get(i).getLatitude()),
                            Double.parseDouble(data.get(i).getLongitude())
                    )).title(data.get(i).getNama_wisata()));
                    Log.d(TAG, "onMapReady: " + data.get(i).getNama_wisata());
                }
            }

            @Override
            public void gagal() {
                Log.d(TAG, "gagal: ");
            }
        });
    }

    public void getSemuaListTempat() {
        if (LocalData.getSemuaList().isEmpty()) {
            getData();
        } else {
            Log.d(TAG, "getSemuaListTempat: ");
            data.addAll(LocalData.getSemuaList());
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        for (int i = 0; i < data.size(); i++) {
            googleMap.addMarker(new MarkerOptions().position(new LatLng(
                    Double.parseDouble(data.get(i).getLatitude()),
                    Double.parseDouble(data.get(i).getLongitude())
            )).title(data.get(i).getNama_wisata()));
            Log.d(TAG, "onMapReady: " + data.get(i).getNama_wisata());
        }
//        origin = new LatLng(Double.parseDouble(prefManager.getPrefSring("latitude")),
//                Double.parseDouble(prefManager.getPrefSring("longitude")));
        destination = new LatLng(-7.871101, 112.526748);

        LatLng coordinate = destination; //Store these lat lng values somewhere. These should be constant.
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                coordinate, 12);
        googleMap.animateCamera(location);
    }
}

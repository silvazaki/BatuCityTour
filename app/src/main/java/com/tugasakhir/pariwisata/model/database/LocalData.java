package com.tugasakhir.pariwisata.model.database;

import com.tugasakhir.pariwisata.model.kategori.Kategori;
import com.tugasakhir.pariwisata.model.semua.Semua;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Silva on 15/02/2018.
 */

public class LocalData {

    public static List<Kategori> kategoriList = new ArrayList<>();
    public static List<Kategori> getKategoriList() {
        return kategoriList;
    }

    public static List<Semua> semuaList = new ArrayList<>();

    public static List<Semua> getSemuaList() {
        return semuaList;
    }

    public static void setSemuaList(List<Semua> semuaList) {
        LocalData.semuaList = semuaList;
    }
}

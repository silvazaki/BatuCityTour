package com.silva.pariwisata.model.database;

import com.silva.pariwisata.model.kategori.Kategori;
import com.silva.pariwisata.model.semua.Semua;

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

    public static List<Semua> semuaKategori = new ArrayList<>();

    public static List<Semua> getSemuaKategori() {
        return semuaKategori;
    }
}

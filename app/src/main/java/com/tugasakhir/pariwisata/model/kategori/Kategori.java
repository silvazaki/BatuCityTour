package com.tugasakhir.pariwisata.model.kategori;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Silva on 15/02/2018.
 */

public class Kategori {
    @SerializedName("id_kategori")
    @Expose
    private String id_kategori;
    @SerializedName("nama_kategori")
    @Expose
    private String nama_kategori;
    @SerializedName("gambar")
    @Expose
    private String gambar_kategori;

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getGambar_kategori() {
        return gambar_kategori;
    }

    public void setGambar_kategori(String gambar_kategori) {
        this.gambar_kategori = gambar_kategori;
    }
}

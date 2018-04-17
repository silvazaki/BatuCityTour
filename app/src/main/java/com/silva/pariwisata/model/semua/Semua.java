package com.silva.pariwisata.model.semua;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Silva on 15/02/2018.
 */

public class Semua {
    @SerializedName("id_wisata")
    @Expose
    private String id_wisata;
    @SerializedName("detail_wisata")
    @Expose
    private String detail_wisata;
    @SerializedName("id_kategori")
    @Expose
    private String id_kategori;
    @SerializedName("nama_wisata")
    @Expose
    private String nama_wisata;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("no_telepon")
    @Expose
    private String no_telepon;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("jadwal_buka")
    @Expose
    private String jadwal_buka;
    @SerializedName("harga_tiket")
    @Expose
    private String harga_tiket;

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getDetail_wisata() {
        return detail_wisata;
    }

    public void setDetail_wisata(String detail_wisata) {
        this.detail_wisata = detail_wisata;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJadwal_buka() {
        return jadwal_buka;
    }

    public void setJadwal_buka(String jadwal_buka) {
        this.jadwal_buka = jadwal_buka;
    }

    public String getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(String harga_tiket) {
        this.harga_tiket = harga_tiket;
    }
}

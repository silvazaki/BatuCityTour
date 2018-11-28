package com.silva.pariwisata.model.komentar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 11/27/2018.
 */

public class Komentar {
    @SerializedName("id_komentar")
    @Expose
    private String id_komentar;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("id_wisata")
    @Expose
    private String id_wisata;
    @SerializedName("komentar")
    @Expose
    private String komentar;

    public String getId_komentar() {
        return id_komentar;
    }

    public void setId_komentar(String id_komentar) {
        this.id_komentar = id_komentar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}

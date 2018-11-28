package com.silva.pariwisata.model;

import com.silva.pariwisata.model.komentar.Komentar;

import java.util.List;

/**
 * Created by User on 11/28/2018.
 */

public interface InterfaceKomentar {
    void sukses(List<Komentar> komentarList);
    void gagal();
}

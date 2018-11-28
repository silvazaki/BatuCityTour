package com.silva.pariwisata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.leo.simplearcloader.SimpleArcDialog;
import com.silva.pariwisata.R;
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.service.TambahKomentarService;


public class KirimKomentarActivity extends AppCompatActivity {

    private EditText komentar;
    private String user, id;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_komentar);
        komentar = findViewById(R.id.isi_sounding_doa);
        prefManager = new PrefManager(this);
        id = getIntent().getStringExtra("id_wisata");
        user = String.valueOf(prefManager.getPrefSring("user_id"));
    }

    public void KirimKomentar(View view) {
        SimpleArcDialog dialog = new SimpleArcDialog(KirimKomentarActivity.this);
        dialog.setTitle("Sedang mengirim...");
        String isi1 = komentar.getText().toString();
        new TambahKomentarService(this, dialog).execute(user,id, isi1);
    }
}

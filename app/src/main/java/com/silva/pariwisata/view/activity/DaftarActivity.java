package com.silva.pariwisata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.silva.pariwisata.R;
import com.silva.pariwisata.service.DaftarService;

/**
 * Created by Risky-PC on 28/11/2017.
 */

public class DaftarActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText user,pass,nama;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        user = (EditText) findViewById(R.id.txt_user);
        pass = (EditText) findViewById(R.id.txt_password);
//
        textView = findViewById(R.id.kembali);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaftarActivity.super.onBackPressed();
            }
        });

    }

    public void daftar(View view){
        String user1=user.getText().toString();
        String pass1=pass.getText().toString();

        int level=radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(level);
        String level1=radioButton.getText().toString();
//        Toast.makeText(this, "Proses Simpan..." , Toast.LENGTH_SHORT).show();
        new DaftarService(this).execute(user1, pass1);
    }


}

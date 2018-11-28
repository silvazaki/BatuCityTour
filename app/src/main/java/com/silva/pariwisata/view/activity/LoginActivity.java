package com.silva.pariwisata.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.leo.simplearcloader.SimpleArcDialog;
import com.silva.pariwisata.R;
import com.silva.pariwisata.service.LoginService;

/**
 * Created by Sil
 */


public class LoginActivity extends AppCompatActivity {
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user= findViewById(R.id.txt_user);
        pass= findViewById(R.id.txt_password);
    }
    public void masuk(View view){
        String user1=user.getText().toString();
        String pass1=pass.getText().toString();
        SimpleArcDialog dialog = new SimpleArcDialog(this);
        dialog.show();
        new LoginService(this).execute(user1,pass1);
    }

    public void Daftar(View view) {
        startActivity(new Intent(getApplicationContext(), DaftarActivity.class));
        finish();
    }
}

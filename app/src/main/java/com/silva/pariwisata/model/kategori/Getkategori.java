package com.silva.pariwisata.model.kategori;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leo.simplearcloader.SimpleArcDialog;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.silva.pariwisata.loopj.Request;
import com.silva.pariwisata.loopj.Url;
import com.silva.pariwisata.model.Hasil;
import com.silva.pariwisata.model.database.LocalData;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Silva on 15/02/2018.
 */

public class Getkategori {
    public void get(final Context context, final Hasil hasil) {
        final SimpleArcDialog dialog = new SimpleArcDialog(context);
        dialog.setTitle("loading...");
        dialog.show();
        Request.get(Url.KATEGORI, null, new AsyncHttpResponseHandler() {
            @Override
            public void onFinish() {
                super.onFinish();
                dialog.dismiss();
                hasil.sukses();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("hasil", "onSuccess: " + new String(responseBody));
                try {
                    Gson gson = new Gson();
                    JSONObject object = new JSONObject(new String(responseBody));
                    JSONObject kategoriList = object.getJSONObject("item");
                    for (int i = 0; i < kategoriList.length(); i++) {
                        LocalData.getKategoriList().add(gson.fromJson(kategoriList.getJSONObject(String.valueOf(i)).toString(), Kategori.class));
                    }
                    hasil.sukses();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                hasil.gagal();
                Toast.makeText(context, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

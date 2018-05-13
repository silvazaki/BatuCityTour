package com.silva.pariwisata.model.semua;

import android.content.Context;
import android.util.Log;

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

public class Getsemuakategori {
    public void get(Context context, String kategori, final Hasil hasil) {
        final SimpleArcDialog dialog = new SimpleArcDialog(context);
        dialog.setTitle("loading...");
        dialog.show();
        Request.get(Url.KATEGORI2+kategori, null, new AsyncHttpResponseHandler() {
            @Override
            public void onFinish() {
                super.onFinish();
                dialog.dismiss();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("hasil", "onSuccess: " + new String(responseBody));
                LocalData.getSemuaKategori().clear();
                try {
                    Gson gson = new Gson();
                    JSONObject object = new JSONObject(new String(responseBody));
                    JSONObject semuaList = object.getJSONObject("item");
                    for (int i = 0; i < semuaList.length(); i++) {
                        LocalData.getSemuaKategori().add(gson.fromJson(semuaList.getJSONObject(String.valueOf(i)).toString(), Semua.class));
                        Log.d("detkat", "onSuccess: "+"tes");
                    }
                    hasil.sukses();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                hasil.gagal();
            }
        });
    }
}

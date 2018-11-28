package com.silva.pariwisata.model.komentar;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leo.simplearcloader.SimpleArcDialog;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.silva.pariwisata.loopj.Request;
import com.silva.pariwisata.loopj.Url;
import com.silva.pariwisata.model.Hasil;
import com.silva.pariwisata.model.InterfaceKomentar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by User on 11/27/2018.
 */

public class Getkomentar {
    List<Komentar> list= new ArrayList<>();
    public void get(final Context context, String param, final InterfaceKomentar hasil) {
        final SimpleArcDialog dialog = new SimpleArcDialog(context);
        dialog.setTitle("loading...");
        dialog.show();
        RequestParams params = new RequestParams();
        params.put("id_wisata", param);
        Request.get(Url.KOMENTAR, params, new AsyncHttpResponseHandler() {
            @Override
            public void onFinish() {
                super.onFinish();
                dialog.dismiss();
                hasil.sukses(list);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("hasil", "onSuccess: " + new String(responseBody));
                try {
                    Gson gson = new Gson();
                    JSONObject object = new JSONObject(new String(responseBody));
                    JSONObject komentarList = object.getJSONObject("item");
                    for (int i = 0; i < komentarList.length(); i++) {
                        list.add(gson.fromJson(komentarList.getJSONObject(String.valueOf(i)).toString(), Komentar.class));
                    }
                    hasil.sukses(list);
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

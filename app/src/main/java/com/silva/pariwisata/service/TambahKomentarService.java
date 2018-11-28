package com.silva.pariwisata.service;

/**
 * Created by ASUS on 10/10/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.leo.simplearcloader.SimpleArcDialog;
import com.silva.pariwisata.loopj.Url;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TambahKomentarService extends AsyncTask<String, Void, String> {
    private Context context;
    private SimpleArcDialog dialog;
    public TambahKomentarService(Context context, SimpleArcDialog dialog){
        this.context = context;
        this.dialog = dialog;
    }

    protected void onPreExecute(){

    }
    @Override
    protected String doInBackground (String... arg0){
        String user = arg0[0];
        String id = arg0[1];
        String isi = arg0[2];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try{

            data = "?id_wisata=" + URLEncoder.encode(id, "UTF-8");
            data += "&id_user=" + URLEncoder.encode(user, "UTF-8");
            data += "&komentar=" + URLEncoder.encode(isi, "UTF-8");

            link = Url.BASE_URL + "tambah_komentar.php" + data;
            Log.d("linkk",link);
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        }catch (Exception e){
            return new String("Exception:" +e.getMessage());
        }
    }
    protected void onPostExecute(String resut){
        String jsonStr = resut;
        Log.d("ressul",resut);
//        Toast.makeText(context, "exe "+resut, Toast.LENGTH_SHORT).show();
        if (jsonStr != null){
            try {
                JSONObject jsonobj =new JSONObject(jsonStr);
                String query_result = jsonobj.getString("query_result");
                if (query_result.equals("SUCCESS")){
                    dialog.dismiss();
                    Toast.makeText(context, "Data Terkirim", Toast.LENGTH_SHORT).show();
                    ((Activity)context).finish();
                }else if (query_result.equals("FAILURE")){
                    dialog.dismiss();
                    Toast.makeText(context, "Proses Gagal", Toast.LENGTH_SHORT).show();
                }else {
                    dialog.dismiss();
                    Toast.makeText(context, query_result, Toast.LENGTH_SHORT).show();
                }
            }catch (JSONException e){
                e.printStackTrace();
                dialog.dismiss();
                Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show();
            }
        }else {
            dialog.dismiss();
            Toast.makeText(context, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
        }
    }

}


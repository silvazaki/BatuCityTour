package com.silva.pariwisata.service;

/**
 * Created by ASUS on 10/10/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.silva.pariwisata.loopj.Url;
import com.silva.pariwisata.model.database.PrefManager;
import com.silva.pariwisata.view.activity.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginService extends AsyncTask<String, Void, String> {
    private Context context;

    public LoginService(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String user = arg0[0];
        String pass = arg0[1];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?username=" + URLEncoder.encode(user, "UTF-8");
            data += "&pass=" + URLEncoder.encode(pass, "UTF-8");


            link = Url.BASE_URL + "login.php" + data;
            Log.d("linkk", link);
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception:" + e.getMessage());
        }
    }

    protected void onPostExecute(String resut) {
        String jsonStr = resut;
        Log.d("ressul", resut);
//        Toast.makeText(context, "exe "+resut, Toast.LENGTH_SHORT).show();
        if (jsonStr != null) {
            try {
                JSONObject jsonobj = new JSONObject(jsonStr);
                String query_result = jsonobj.getString("query_result");
                Log.d("ressul", "onPostExecute: "+query_result);
                if (query_result.equals("KOSONG")) {
                    Toast.makeText(context, "User/Password Salah", Toast.LENGTH_SHORT).show();
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Proses Gagal", Toast.LENGTH_SHORT).show();
                    Log.d("loginHasil", "onPostExecute: "+query_result);
                } else {
                    Toast.makeText(context, "Selamat Datang " + query_result, Toast.LENGTH_SHORT).show();
                    PrefManager prefManager = new PrefManager(context);
                    prefManager.setPrefSring("user_id",String.valueOf(query_result));
                    Log.d("hasil", "onPostExecute: "+prefManager.getPrefSring("user_id"));
                    ((Activity) context).finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, " " + e, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, "Tidak Dapat JSON Data", Toast.LENGTH_SHORT).show();
        }
    }

}


package com.tugasakhir.pariwisata.model.database;

/**
 * Created by silva on 3/12/17.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setPrefSring(String variable, String value){
        editor.putString(variable, value);
        editor.commit();
    }

    public String getPrefSring(String variable) {
        return pref.getString(variable, null);
    }

    public Boolean getPrefBoolean(String variable) {
        return pref.getBoolean(variable, true);
    }

    public void setPrefBoolean(String variable, Boolean mute){
        editor.putBoolean(variable, mute);
        editor.commit();
    }

}

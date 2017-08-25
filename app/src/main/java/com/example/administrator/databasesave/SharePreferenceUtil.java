package com.example.administrator.databasesave;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/08/11
 *   desc     :
 *   version  :   V 1.0.5
 */
public class SharePreferenceUtil {

    public Context context;

    public SharePreferenceUtil(Context context) {
        this.context = context;
    }

    public  void putString(String name, String key, String value){
        SharedPreferences preferences = context.getSharedPreferences(name,context.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String getStringFromSharePreferwithDefault(String name,String key,String value_default){
        SharedPreferences preferences = context.getSharedPreferences(name,context.MODE_WORLD_WRITEABLE);
       return   preferences.getString(key,value_default);
    }

    public String getStringFromSharePrefer(String name,String key){
        SharedPreferences preferences = context.getSharedPreferences(name,context.MODE_WORLD_WRITEABLE);
        return   preferences.getString(key,null);
    }


}

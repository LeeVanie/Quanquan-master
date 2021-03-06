package com.lee.ttest.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lee.ttest.base.BaseActivity;


public class SharedPreferencesUtils {
	public static void saveString(Context mActivity, String key,
                                  String value) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		sp.edit().putString(key, value).commit();
	}

	public static String getString(Context mActivity, String key,
                                   String defValue) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		return sp.getString(key, defValue);
	}

	public static void setBoolean(BaseActivity mActivity, String key,
                                  boolean value) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public static boolean isFirst(BaseActivity mActivity) {
		return getBoolean(mActivity, "isfirst", true);
	}

	public static boolean getBoolean(Context mActivity, String key,
                                     boolean defValue) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		return sp.getBoolean(key, defValue);
	}

	public static void saveHeight(BaseActivity mActivity, int height) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putInt("height", height);
		edit.commit();
	}

	public static int getHeight(BaseActivity mActivity) {
		SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig",
				Context.MODE_PRIVATE);
		return sp.getInt("height", 0);
	}
    
    public static void deletedDatas(Context mActivity, String key){
        SharedPreferences sp = mActivity.getSharedPreferences("sgappconfig", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }
}

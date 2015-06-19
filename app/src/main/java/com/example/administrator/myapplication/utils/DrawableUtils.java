package com.example.administrator.myapplication.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.example.administrator.myapplication.R;

import java.util.Locale;


public class DrawableUtils {

	/**
	 * 根据名称找到资源文件的ResId,如果找不到返回应用Launcher图标<br/>
	 * 
	 * @param context
	 * @param name
	 * @return Resid
	 */
	public static int getDrawableResidByName(Context context, String name) {
		ApplicationInfo appInfo = context.getApplicationInfo();
		int resID = context.getResources().getIdentifier(
				name.toLowerCase(Locale.getDefault()), "drawable",
				appInfo.packageName);
		if (resID == 0) {
			return R.drawable.ic_launcher;
		}
		return resID;
	}

	public static Drawable getDrawableResidByID(Context context, int name) {
		Drawable drawable = context.getResources().getDrawable(name);
		return drawable;
	}
}

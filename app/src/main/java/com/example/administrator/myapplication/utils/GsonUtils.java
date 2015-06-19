package com.example.administrator.myapplication.utils;

import com.google.gson.Gson;

public class GsonUtils {
	public static Gson INSTANCE = new Gson();

	public static Gson getGsonTool() { // 对获取实例的方法进行同步
		if (INSTANCE == null) {
			synchronized (GsonUtils.class) {
				if (INSTANCE == null)
					INSTANCE = new Gson();
			}
		}
		return INSTANCE;
	}

}

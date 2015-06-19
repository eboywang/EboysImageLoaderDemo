package com.example.administrator.myapplication.ables;

import org.json.JSONObject;

public interface Jsonable<T> {
	String toJson();

	T toModel(String json);

	T toModel(JSONObject jsonObject);

}

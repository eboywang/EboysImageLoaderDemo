package com.example.administrator.myapplication.model;

import com.example.administrator.myapplication.ables.Jsonable;
import com.example.administrator.myapplication.utils.GsonUtils;

import java.lang.reflect.Type;

import org.json.JSONObject;


/**
 * 该类是用来统一封装原生具有Json能力的工具类
 * 
 * @author Administrator
 *
 * @param <T>
 */

public class BaseJsonableBean<T> extends BaseBean implements Jsonable<T> {

	@Override
	public String toJson() {

		return GsonUtils.getGsonTool().toJson(this);
	}

	@Override
	public T toModel(String json) {
		Type type = (Class<T>) getClass();
		return GsonUtils.getGsonTool().fromJson(json, type);
	}

	@Override
	public T toModel(JSONObject jsonObject) {
		Type type = (Class<T>) getClass();
		return GsonUtils.getGsonTool().fromJson(jsonObject.toString(), type);
	}

}

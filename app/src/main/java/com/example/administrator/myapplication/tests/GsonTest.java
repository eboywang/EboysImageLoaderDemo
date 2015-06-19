package com.example.administrator.myapplication.tests;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;



import android.test.AndroidTestCase;
import android.util.Log;

import com.example.administrator.myapplication.model.Clazz;

/**
 * 该测试类以Clazz类为例，对 Jsonable 工具类进行测试 测试通过
 * 
 * @author Administrator
 *
 */
public class GsonTest extends AndroidTestCase {

	private static final String TAG = "GsonTest";

	static String clazzJson = "{\"className\":\"信管一班\",\"students\":[\"student No:102110\",\"student No:102111\",\"student No:102112\",\"student No:102113\",\"student No:102114\",\"student No:102115\",\"student No:102116\",\"student No:102117\",\"student No:102118\",\"student No:102119\"],\"_id\":10239}";

	public void testJsonableModel() {
		Clazz clazz = new Clazz();
		clazz.setClassName("信管一班");
		clazz.set_id(10239L);
		clazz.setStudents(getStudents(10));
		Log.d(TAG, clazz.toJson());
	}

	public void testToModel() throws JSONException {
		Clazz clazz = new Clazz();
		JSONObject jsonObject = new JSONObject(clazzJson);
		clazz = clazz.toModel(jsonObject);
		Log.d(TAG, clazz.toString());
		clazz = clazz.toModel(clazzJson);
		Log.d(TAG, clazz.toString());

	}

	ArrayList<String> getStudents(int size) {
		ArrayList<String> students = new ArrayList<String>();
		if (size <= 0) {
			return students;
		}
		for (int i = 0; i < size; i++) {
			students.add("student No:10211" + i);
		}

		return students;
	}
}

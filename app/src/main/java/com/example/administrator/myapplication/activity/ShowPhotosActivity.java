package com.example.administrator.myapplication.activity;



import android.graphics.drawable.BitmapDrawable;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ShowPhotosActivity extends GenericShowPhotosActivity {

	@Override
	public Integer getDefaultDrawable() {
		// TODO Auto-generated method stub
		return R.drawable.ic_launcher;
	}

	@Override
	public BitmapDrawable getDefaultBitmap() {

		return null;
	}

	@Override
	public int[] getImgIds() {

		int[] imgIds = new int[] { R.drawable.item01, R.drawable.item02,
				R.drawable.item03, R.drawable.item04, R.drawable.item05,
				R.drawable.item06, R.drawable.item07, R.drawable.item08,
				R.drawable.item09, R.drawable.item10, R.drawable.item11,
				R.drawable.item12 };
		return imgIds;

	}

}

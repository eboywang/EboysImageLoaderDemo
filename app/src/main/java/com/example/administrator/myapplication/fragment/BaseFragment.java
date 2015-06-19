package com.example.administrator.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment implements OnClickListener {

	public static final String TAG = "BaseFargment";
	protected Context mContext;

	public BaseFragment() {
	}

	public BaseFragment(Context context) {
		this.mContext = context;
	}

	public interface DataLoadListener {
		void onDataLoadFinish();
	}

	/**
	 * 初始化界面布局
	 */
	public abstract void initViews(View v);

	protected abstract View initFragmentView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.mContext = getActivity();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mContext = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initFragmentView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initViews(view);
	}

	public void showActivity(Class<? extends FragmentActivity> clazz,
			Bundle extras) {
		Intent intent = new Intent(mContext, clazz);
		if (extras != null)
			intent.putExtras(extras);
		startActivity(intent);
	}

	protected void showToast(String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}
}

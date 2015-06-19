package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.callbacks.DataLoadListener;


public abstract class BaseBottomFragment extends BaseFragment implements
        DataLoadListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public BaseBottomFragment() {
		super();
	}

	protected View initFragmentView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {

		View view = null;
		if (this instanceof PersonalFragment) {
			// mApp.setContactsListener(this);
			view = inflater.inflate(R.layout.fragment1, container, false);
		} else if (this instanceof PersonalFragment2) {
			view = inflater.inflate(R.layout.fragment2, container, false);
		}
		// mApp.setCallLogListener(this);
		// } else if (this instanceof PersonageFragment) {
		// view = inflater.inflate(R.layout.activity_perosonage, container,
		// false);
		// }
		return view;
	}

	@Override
	public void onClick(View v) {

	}

}

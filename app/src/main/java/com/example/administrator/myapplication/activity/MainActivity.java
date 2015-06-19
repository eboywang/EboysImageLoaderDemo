package com.example.administrator.myapplication.activity;



import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class MainActivity extends FragmentActivity implements OnClickListener {
	FragmentManager fragmentManager;
	TextView textView;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// EventBus.
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();

		// fragmentManager.beginTransaction()
		// .replace(R.id.mfragment, new PersonalFragment()).commit();

//		initView();
	}

	boolean flag = false;
//
//	private void initView() {
//		// TODO Auto-generated method stub
//
//		button1 = (Button) findViewById(R.id.button1);
//		button1.setOnClickListener((OnClickListener) this);
//		textView = (TextView) findViewById(R.id.tv);
//
//		/**
//		 * 尝试切换fragment
//		 */
//		textView.setOnClickListener(this);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//
//	@Override
	public void onClick(View v) {

    }
//		switch (v.getId()) {
//		case R.id.tv:
//			if (flag) {
//				fragmentManager.beginTransaction()
//						.replace(R.id.mfragment, new PersonalFragment())
//						.commit();
//				flag = false;
//			} else {
//				fragmentManager.beginTransaction()
//						.replace(R.id.mfragment, new PersonalFragment2())
//						.commit();
//				flag = true;
//			}
//			break;
//		case R.id.button1:
//
//			Intent intent = new Intent();
//			// intent.putExtra("position", 0);
//			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			intent.setClass(getApplication(), ShowPhotosActivity.class);
//			startActivity(intent);
//
//			break;
//
//		default:
//			break;
//		}
//	}

}

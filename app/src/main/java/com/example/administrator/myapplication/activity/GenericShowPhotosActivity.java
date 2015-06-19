package com.example.administrator.myapplication.activity;


import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

import com.example.administrator.myapplication.R;

public abstract class GenericShowPhotosActivity extends Activity implements
		ViewFactory, OnTouchListener {
	/**
	 * ImagaSwitcher 的引用
	 */
	private ImageSwitcher mImageSwitcher;

	/**
	 * 当前选中的图片id序号
	 */
	private int currentPosition;
	/**
	 * 按下点的X坐标
	 */
	private float downX;
	/**
	 * 装载点点的容器
	 */
	private LinearLayout linearLayout;
	/**
	 * 点点数组
	 */
	private ImageView[] tips;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_photo);

		// 实例化ImageSwitcher
		mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		// 设置Factory
		mImageSwitcher.setFactory(this);
		if (getImgIds() != null && getImgIds().length > 0) {
			// 设置OnTouchListener，我们通过Touch事件来切换图片
			mImageSwitcher.setOnTouchListener(this);

			linearLayout = (LinearLayout) findViewById(R.id.viewGroup);
			tips = new ImageView[getImgIds().length];
			for (int i = 0; i < getImgIds().length; i++) {
				ImageView mImageView = new ImageView(this);
				tips[i] = mImageView;
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT));
				layoutParams.rightMargin = 3;
				layoutParams.leftMargin = 3;

				mImageView
						.setBackgroundResource(R.drawable.page_indicator_unfocused);
				linearLayout.addView(mImageView, layoutParams);
			}

			// 这个我是从上一个界面传过来的，上一个界面是一个GridView
			currentPosition = getIntent().getIntExtra("position", 0);
			mImageSwitcher.setImageResource(getImgIds()[currentPosition]);

			setImageBackground(currentPosition);
		} else {
			setDefaultBackground();

			Toast.makeText(this, "没有可以暂时的图片哦...", Toast.LENGTH_SHORT).show();
		}

	}

	@SuppressWarnings("deprecation")
	private void setDefaultBackground() {
		if (getDefaultBitmap() != null) {
			mImageSwitcher.setBackgroundDrawable(getDefaultBitmap());
		} else {
			mImageSwitcher.setBackgroundResource(getDefaultDrawable());
		}

	}

	/**
	 * 抛出方法共外界设置展示的本地图片
	 */
	public abstract int[] getImgIds();

	/**
	 * 抛出方法共外界设置默认图片
	 * 
	 * @return
	 */
	public abstract Integer getDefaultDrawable();

	/**
	 * 抛出方法共外界设置默认图片
	 * 
	 * @return
	 */
	public abstract BitmapDrawable getDefaultBitmap();


	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	@Override
	public View makeView() {
		final ImageView i = new ImageView(this);
		i.setBackgroundColor(0xffCCCCCC);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return i;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			// 手指按下的X坐标
			downX = event.getX();
			break;
		}
		case MotionEvent.ACTION_UP: {
			float lastX = event.getX();
			// 抬起的时候的X坐标大于按下的时候就显示上一张图片
			if (lastX > downX) {
				if (currentPosition > 0) {
					// 设置动画，这里的动画比较简单，不明白的去网上看看相关内容
					mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
							getApplication(), R.anim.left_in));
					mImageSwitcher.setOutAnimation(AnimationUtils
							.loadAnimation(getApplication(), R.anim.right_out));
					currentPosition--;
					mImageSwitcher.setImageResource(getImgIds()[currentPosition
							% getImgIds().length]);
					setImageBackground(currentPosition);
				} else {
					Toast.makeText(getApplication(), "已经是第一张",
							Toast.LENGTH_SHORT).show();
				}
			}

			if (lastX < downX) {
				if (currentPosition < getImgIds().length - 1) {
					mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
							getApplication(), R.anim.right_in));
					mImageSwitcher.setOutAnimation(AnimationUtils
							.loadAnimation(getApplication(), R.anim.lift_out));
					currentPosition++;
					mImageSwitcher
							.setImageResource(getImgIds()[currentPosition]);
					setImageBackground(currentPosition);
				} else {
					Toast.makeText(getApplication(), "到了最后一张",
							Toast.LENGTH_SHORT).show();
				}
			}
		}

			break;
		}

		return true;
	}

}

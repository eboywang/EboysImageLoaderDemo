package com.example.administrator.myapplication;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.Adapter.GalleryAdapter;
import com.example.administrator.myapplication.Event.NetWorkStatsChangeEvent;
import com.example.administrator.myapplication.activity.BaseActivity;
import com.example.administrator.myapplication.activity.ShowPhotosActivity;
import com.example.administrator.myapplication.db.ImageCRUD;
import com.example.administrator.myapplication.db.ImageInfo;
import com.example.administrator.myapplication.db.MainDB;
import com.example.administrator.myapplication.utils.EventUtils;
import com.hbb.event.EventBus;
import com.hbb.wang.lib.PhoneInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends BaseActivity {

    private static final String TAG ="MainActivity" ;
    private TextView textView;
    private Gallery gallery;
    private ArrayList<ImageInfo> imgUrls;
    ImageCRUD infoCrud;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 注册为EventBus的订阅者
         */
       EventBus.getDefault().register(this, Thread.MAX_PRIORITY);
        PhoneInfo info = new PhoneInfo(this);

        Log.d(TAG, "devices id: " + info.getDeviceId());
        Log.d(TAG,"getPhoneModule: "+info.getPhoneModule());
        Log.d(TAG,"getSerialNumber: "+info.getSerialNumber());
        Log.d(TAG,"getPhoneNumber: "+info.getPhoneNumber());
        Log.d(TAG,"getMacAddress: "+info.getMacAddress());
        Log.d(TAG,"getCpuInfo: "+info.getCpuInfo());
        Log.d(TAG,"getTotalMemory: "+info.getTotalMemory());
        NetWorkStatsChangeEvent netWorkStatsChangeEvent=new NetWorkStatsChangeEvent();
        netWorkStatsChangeEvent.setNetWorkInfo("当前网络状态：WIFI");
        EventUtils.postEvent(netWorkStatsChangeEvent);

        CountDownTimer timer=new CountDownTimer(5000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
              List<ImageInfo> infos= infoCrud.getAll();
                for(ImageInfo info:infos){
                    Log.d(TAG,"MainActivity--"+info.getUrl()+","+info.getCreate_at());
                }
            }
        };
                timer.start();

    }

    @Override
    protected void initDatas() {
        imgUrls=new ArrayList<>();
        ImageInfo imageInfo1=new ImageInfo();
        imageInfo1.setTitle("美女范冰冰——1");
        imageInfo1.setUrl("http://n1.itc.cn/img8/wb/smccloud/recom/2015/06/18/143459692478660239.JPEG");

        imgUrls.add(imageInfo1);
        ImageInfo imageInfo2=new ImageInfo();
        imageInfo2.setTitle("美女范冰冰——2");
        imageInfo2.setUrl("http://image.tianjimedia.com/uploadImages/2015/169/11/F19665FF7M13_680x500.jpg");
        imgUrls.add(imageInfo2);

        ImageInfo imageInfo3=new ImageInfo();
        imageInfo3.setTitle("美女范冰冰——3");
        imageInfo3.setUrl("http://upload.ct.youth.cn/2015/0617/1434515738492.jpg");
        imgUrls.add(imageInfo3);

        ImageInfo imageInfo4=new ImageInfo();
        imageInfo4.setTitle("美女范冰冰——4");
        imageInfo4.setUrl("http://image.cnwest.com/attachement/jpg/site1/20110908/001372d899ef0fd261ff0b.jpg");
        imgUrls.add(imageInfo4);

        ImageInfo imageInfo5=new ImageInfo();
        imageInfo5.setTitle("美女范冰冰——5");
        imageInfo5.setUrl("http://gb.cri.cn/mmsource/images/2011/12/02/52/12628364424854817784.jpg");
        imgUrls.add(imageInfo5);

        ImageInfo imageInfo6=new ImageInfo();
        imageInfo6.setTitle("美女范冰冰——6");
        imageInfo6.setUrl("http://iphone.images.paojiao.cn/iphone/paper/20117/11/95770376/paojiao_cd7b4022.jpg");
        imgUrls.add(imageInfo6);

        ImageInfo imageInfo7=new ImageInfo();
        imageInfo7.setTitle("美女范冰冰——7");
        imageInfo7.setUrl("http://a4.att.hudong.com/86/42/300000876508131216423466864_950.jpg");
        imgUrls.add(imageInfo7);


        ImageInfo imageInfo8=new ImageInfo();
        imageInfo8.setTitle("美女范冰冰——8");
        imageInfo8.setUrl("http://img2.imgtn.bdimg.com/it/u=5330622,2392902926&fm=21&gp=0.jpg");
        imgUrls.add(imageInfo8);


        ImageInfo imageInfo9=new ImageInfo();
        imageInfo9.setTitle("美女范冰冰——9");
        imageInfo9.setUrl("http://pic3.nipic.com/20090629/1951702_070402007_2.jpg");
        imgUrls.add(imageInfo9);

        ImageInfo imageInfo10=new ImageInfo();
        imageInfo10.setTitle("美女范冰冰——10");
        imageInfo10.setUrl("http://pic.baike.soso.com/p/20121209/20121209135205-1649968700.jpg");
        imgUrls.add(imageInfo10);


        ImageInfo imageInfo11=new ImageInfo();
        imageInfo11.setTitle("美女范冰冰——11");
        imageInfo11.setUrl("http://gb.cri.cn/mmsource/images/2011/12/02/0/7018444229850163352.jpg");
        imgUrls.add(imageInfo11);


        ImageInfo imageInfo12=new ImageInfo();
        imageInfo12.setTitle("美女范冰冰——12");
        imageInfo12.setUrl("http://att2.citysbs.com/hangzhou/image1/2010/05/19-08/20100519_3ea67ca956031d53dfe16IlpFyeIDlOG.jpg");
        imgUrls.add(imageInfo12);

        ImageInfo imageInfo13=new ImageInfo();
        imageInfo13.setTitle("美女范冰冰——13");
        imageInfo13.setUrl("http://www.ecoo.com.cn/uploads/allimg/c130817/13LH2033H0-5LP2.jpg");
        imgUrls.add(imageInfo13);

        ImageInfo imageInfo14=new ImageInfo();
        imageInfo14.setTitle("美女范冰冰——14");
        imageInfo14.setUrl("http://www.ecoo.com.cn/uploads/allimg/c130817/13LH2031460-55X55.jpg");
        imgUrls.add(imageInfo14);


        ImageInfo imageInfo15=new ImageInfo();
        imageInfo15.setTitle("美女范冰冰——15");
        imageInfo15.setUrl("http://a.hiphotos.baidu.com/zhidao/pic/item/94cad1c8a786c917ef634e94cb3d70cf3bc7573e.jpg");
        imgUrls.add(imageInfo15);

        for(ImageInfo info:imgUrls){
             infoCrud=new ImageCRUD(this);
            infoCrud.addImage(info);
            int id=info.getId();
            Log.d(TAG,"info.id is "+id);
        }

    }


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
    @Override
    protected void initViews() {
        textView= (TextView) findViewById(R.id.textView);
        gallery= (Gallery) findViewById(R.id.gallery );
        galleryAdapter=new GalleryAdapter(getApplicationContext(),imgUrls);
        gallery.setAdapter(galleryAdapter);
    }

    @Override
    protected void initListeners() {
        textView.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onEvent(NetWorkStatsChangeEvent netWorkStatsChangeEvent){
       Log.d(TAG, netWorkStatsChangeEvent.getNetWorkInfo() + ", now is" + SystemClock.uptimeMillis());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.textView:
                Intent intent = new Intent();
                intent.putExtra("position", 0);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		    	intent.setClass(getApplication(), ShowPhotosActivity.class);
		    	startActivity(intent);
                break;
            default:
                break;
        }

    }
}

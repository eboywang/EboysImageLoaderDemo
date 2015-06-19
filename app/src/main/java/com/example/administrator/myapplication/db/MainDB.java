package com.example.administrator.myapplication.db;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.util.List;


/**
 * Created by Administrator on 2015/6/18.
 */
public class MainDB extends Activity{

    private ImageCRUD imgCRUD = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgCRUD = new ImageCRUD(this);
        ImageInfo imgInfo = new ImageInfo();
        // 增加记录
        imgInfo.setTitle("图片名字");
        imgInfo.setCreate_at(String.valueOf(System.currentTimeMillis()));
        imgInfo.setUrl("图片的url");
        for (int i = 0; i < 5; i++) {
            imgInfo.setTitle("图片名字" + i);
            imgCRUD.addImage(imgInfo);
        }

        // 删除记录
        // imgCRUD.delById(2);

        // 查询所有记录
        List<ImageInfo> imgs = imgCRUD.getAll();
        for (ImageInfo img : imgs) {
            System.out.println(img.toString());
        }

//        修改
//        imgCRUD.updateById(3);
    }
}

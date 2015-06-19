package com.example.administrator.myapplication.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2015/6/18.
 */
public class ImageCRUD {

    private Context context;
    private ImageHelper helper = null;
    private Dao<ImageInfo, Integer> imgDao = null;

    public ImageCRUD(Context context) {
        this.context = context;
        try {
            helper = new ImageHelper(context);
            imgDao = helper.getImgDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加记录
     *
     * @param imgInfo
     */
    public void addImage(ImageInfo imgInfo) {
        try {
            imgDao.create(imgInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除记录
     *
     * @param id
     */
    public void delById(int id) {
        try {
            imgDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询记录
     *
     * @return
     */
    public List<ImageInfo> getAll() {
        try {
            List<ImageInfo> list = imgDao.queryForAll();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改
     *
     * @param info
     */
    public void updateById(ImageInfo info) {
        ImageInfo imgInfo = null;
        try {
            imgInfo = imgDao.queryForId(info.getId());
            if(imgInfo!=null){
                imgDao.update(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

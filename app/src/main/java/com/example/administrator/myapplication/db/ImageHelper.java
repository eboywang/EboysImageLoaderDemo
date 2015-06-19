package com.example.administrator.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2015/6/18.
 */
public class ImageHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "images";
    private static final int DB_VERSION = 1;
    private Dao<ImageInfo, Integer> imgDao = null;

    public ImageHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ImageInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, ImageInfo.class, true);
            this.onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<ImageInfo, Integer> getImgDao() throws SQLException {
        if (imgDao == null) {
            imgDao = getDao(ImageInfo.class);
        }
        return imgDao;
    }
}

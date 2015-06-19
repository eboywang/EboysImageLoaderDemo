package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * 文件作用描述
 *
 * @author [王博凯] 2015-06-18 14:42
 * @version 1.0.0
 */

public class MyApplication extends Application {

    private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this.getApplicationContext();
        initImageLoader(context);
    }

    private void initImageLoader(Context context) {
//
//        /**
//        /**
//         * 初始化ImageLoader
//         */
////            File cacheDir = StorageUtils.getOwnCacheDirectory(context,
////                    "hbb/Cache");// 获取到缓存的目录地址
////            Log.e("cacheDir", cacheDir.getPath());
//            // 创建配置ImageLoader(所有的选项都是可选的,只使用那些你真的想定制)，这个可以设定在Application里面，设置为全局的配置参数
//            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                    context)
//                    // max width, max height，即保存的每个缓存文件的最大长宽
//                    .memoryCacheExtraOptions(720,1280)
//                            // Can slow ImageLoader, use it carefully (Better don't use it)设置缓存的详细信息，最好不要设置这个
////				 .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
//                            // 线程池内加载的数量
//                    .threadPoolSize(6)
//                            // 线程优先级
//                    .threadPriority(Thread.MAX_PRIORITY)
//				/*
//				 * When you display an image in a small ImageView
//				 *  and later you try to display this image (from identical URI) in a larger ImageView
//				 *  so decoded image of bigger size will be cached in memory as a previous decoded image of smaller size.
//				 *  So the default behavior is to allow to cache multiple sizes of one image in memory.
//				 *  You can deny it by calling this method:
//				 *  so when some image will be cached in memory then previous cached size of this image (if it exists)
//				 *   will be removed from memory cache before.
//				 */
////				.denyCacheImageMultipleSizesInMemory()
//
//                            // You can pass your own memory cache implementation你可以通过自己的内存缓存实现
//                            // .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
//                            // .memoryCacheSize(2 * 1024 * 1024)
//                            //硬盘缓存50MB
//                    .discCacheSize(50 * 1024 * 1024)
//                            //将保存的时候的URI名称用MD5
////                    .discCacheFileNameGenerator(new Md5FileNameGenerator())
////                            // 加密
////                    .discCacheFileNameGenerator(new HashCodeFileNameGenerator())//将保存的时候的URI名称用HASHCODE加密
//                    .tasksProcessingOrder(QueueProcessingType.LIFO)
//                    .discCacheFileCount(100) //缓存的File数量
////                    .discCache(new UnlimitedDiscCache(cacheDir))// 自定义缓存路径
//                            // .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
//                            // .imageDownloader(new BaseImageDownloader(context, 5 * 1000,
//                            // 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
//                    .writeDebugLogs() // Remove for release app
//                    .build();
//            // Initialize ImageLoader with configuration.
//            ImageLoader.getInstance().init(config);// 全局初始化此配置

//
//        File cacheDir =StorageUtils.getOwnCacheDirectory(this, "imageloader/Cache");
//        ImageLoaderConfiguration config  = new ImageLoaderConfiguration
//                .Builder(this)
//                .memoryCacheExtraOptions(720, 1280) // maxwidth, max height，即保存的每个缓存文件的最大长宽
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .denyCacheImageMultipleSizesInMemory()
////                .memoryCache(new UsingFreqLimitedMemoryCache(2* 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
//                .memoryCacheSize(2 * 1024 * 1024)
//                .discCacheSize(50 * 1024 * 1024)
////                .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .discCacheFileCount(100) //缓存的文件数量
//                .discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径
//                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
//                .imageDownloader(new BaseImageDownloader(this,5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
//                .writeDebugLogs() // Remove for releaseapp
//                .build();//开始构建
//        ImageLoader.getInstance().init(config);

        /**
         * ImageLoader全局参数设置
         */
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCacheSize((int) Runtime.getRuntime().maxMemory() / 8)
                .discCacheSize(20 * 1024 * 1024)
                .threadPoolSize(Runtime.getRuntime().availableProcessors() * 2)
                .build();
        ImageLoader.getInstance().init(config);
    }


}

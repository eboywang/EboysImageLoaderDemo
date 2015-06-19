package com.example.administrator.myapplication.Adapter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.db.ImageCRUD;
import com.example.administrator.myapplication.db.ImageInfo;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 文件作用描述
 *
 * @author [你的名字（中文全称）] 2015-06-18 16:48
 * @version 1.0.0
 */

public class GalleryAdapter extends BaseAdapter{

    private List<ImageInfo> imgUrls;
    private Context context;
    public GalleryAdapter(Context context,List<ImageInfo> imgUrls){
        this.imgUrls=imgUrls;
        this.context=context;
    }

    @Override
    public int getCount() {
        return this.imgUrls==null?0:this.imgUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder=null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.item_gallery,null);
            holder.iv= (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageInfo info=imgUrls.get(position);
        String url=info.getUrl();
        ImageCRUD crud=new ImageCRUD(context);
        info.setCreate_at(SystemClock.currentThreadTimeMillis()+"--");
        crud.updateById(info);

        ImageLoader.getInstance().displayImage(url,holder.iv);
        return convertView;
    }
    class ViewHolder{
        ImageView iv;

    }
}

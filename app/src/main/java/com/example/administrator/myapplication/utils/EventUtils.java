package com.example.administrator.myapplication.utils;

import com.example.administrator.myapplication.Event.IEvent;
import com.hbb.event.EventBus;

/**
 * 文件作用描述
 *
 * @author [王博凯] 2015-06-17 17:11
 * @version 1.0.0
 */

public class EventUtils {

    public static void  postEvent( IEvent event){
        EventBus.getDefault().post(event);
    }

    public static void postStickyEvent(IEvent event){
        EventBus.getDefault().postSticky(event);
    }
}

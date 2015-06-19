package com.example.administrator.myapplication.Event;

/**
 * 文件作用描述
 *
 * @author [王博凯] 2015-06-17 17:09
 * @version 1.0.0
 */

public class NetWorkStatsChangeEvent implements IEvent {
    private String netWorkInfo;

    public String getNetWorkInfo() {
        return netWorkInfo;
    }

    public void setNetWorkInfo(String netWorkInfo) {
        this.netWorkInfo = netWorkInfo;
    }
}

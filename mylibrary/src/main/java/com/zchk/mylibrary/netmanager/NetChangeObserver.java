package com.zchk.mylibrary.netmanager;

/**
 * Created by admin on 2017/8/21.
 */

public interface NetChangeObserver {

    /**
     * 网络连接回调 type为网络类型
     */
    void onNetConnected(NetUtils.NetType type);

    /**
     * 没有网络
     */
    void onNetDisConnect();
}

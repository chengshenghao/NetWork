package com.zchk.network;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.zchk.mylibrary.netmanager.NetStateReceiver;

/**
 * Created by admin on 2017/5/9.
 */

public class ZiChanApplication extends Application {
    public static ZiChanApplication mApplication;
    private LruCache<String,Bitmap> imageLruCache;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        NetStateReceiver.registerNetworkStateReceiver(mApplication);
    }
    @Override
    public void onLowMemory() {
        if (mApplication != null) {
            NetStateReceiver.unRegisterNetworkStateReceiver(mApplication);
        }
        super.onLowMemory();
    }
    public LruCache<String, Bitmap> getImageLruCache() {
        return imageLruCache;
    }

}

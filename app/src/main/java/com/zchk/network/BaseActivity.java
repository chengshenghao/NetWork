package com.zchk.network;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zchk.mylibrary.netmanager.NetChangeObserver;
import com.zchk.mylibrary.netmanager.NetStateReceiver;
import com.zchk.mylibrary.netmanager.NetUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NetChangeObserver mNetChangeObserver = new NetChangeObserver() {
            @Override
            public void onNetConnected(NetUtils.NetType type) {
                onConnected(type);
            }

            @Override
            public void onNetDisConnect() {
                onDisconnected();
            }
        };
        NetStateReceiver.registerObserver(mNetChangeObserver);
    }
    public void onConnected(NetUtils.NetType type){}
    public void onDisconnected(){}
}

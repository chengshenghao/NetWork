package com.zchk.network;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zchk.mylibrary.netmanager.NetChangeObserver;
import com.zchk.mylibrary.netmanager.NetStateReceiver;
import com.zchk.mylibrary.netmanager.NetUtils;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.N;
/*
* 主界面
* */
public class MainActivity extends BaseActivity {

    private View netError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        netError = findViewById(R.id.rl_neterror);
        if(NetUtils.isNetworkConnected(this)){
            netError.setVisibility(View.GONE);
        }else {
            netError.setVisibility(View.VISIBLE);
        }
        netError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
    }
    @Override
    public void onConnected(NetUtils.NetType type) {
        super.onConnected(type);
        netError.setVisibility(View.GONE);
    }

    @Override
    public void onDisconnected() {
        super.onDisconnected();
        netError.setVisibility(View.VISIBLE);
    }

}

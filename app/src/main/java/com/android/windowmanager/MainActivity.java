package com.android.windowmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.windowmanager.util.WindowMnagerNoinstanceUtil;
import com.android.windowmanager.util.WindowMnagerUtil;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 从Service启动
         */
        findViewById(R.id.bt_servcie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wIntent = new Intent(MainActivity.this, WindowService.class);
                startService(wIntent);
            }
        });

        /**
         * 从Activity启动
         */
        findViewById(R.id.bt_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowMnagerUtil.getWindowInstance(MainActivity.this).createWindow(); //会消失
//                WindowMnagerUtil.getWindowInstance(getApplicationContext()).createWindow(); //不会消失
            }
        });

        /**
         * 不使用单例模式启动
         */
        findViewById(R.id.bt_noapplication).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WindowMnagerNoinstanceUtil.createWindow(MainActivity.this); //会消失
//                WindowMnagerNoinstanceUtil.createWindow(getApplicationContext()); 不会消失
            }
        });

    }


}



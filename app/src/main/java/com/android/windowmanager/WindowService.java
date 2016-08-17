package com.android.windowmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.windowmanager.util.WindowMnagerNoinstanceUtil;
import com.android.windowmanager.util.WindowMnagerUtil;

public class WindowService extends Service {
    public WindowService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        WindowMnagerUtil.getWindowInstance(getApplicationContext()).createWindow(); //这个是在Service中用单例模式工具类
        WindowMnagerNoinstanceUtil.createWindow(this);  //在Service中正常启动

        return super.onStartCommand(intent, flags, startId);
    }
}

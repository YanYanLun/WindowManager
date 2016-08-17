package com.android.windowmanager.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.windowmanager.R;

/**
 * Created by Administrator on 2016/8/17.
 */
public class WindowMnagerNoinstanceUtil {
    /**
     * 创建悬浮窗，添加一张美女图
     */
    public static void createWindow(Context context) {
        final WindowManager mWindowMnager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //只有打电话才会显示在屏幕上方
        wmParams.gravity = Gravity.CENTER;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        final ImageView imageView = new ImageView(context);    //设置添加的图片
        imageView.setImageResource(R.mipmap.girl);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowMnager.removeView(imageView);
            }
        });
        mWindowMnager.addView(imageView, wmParams);
    }
}

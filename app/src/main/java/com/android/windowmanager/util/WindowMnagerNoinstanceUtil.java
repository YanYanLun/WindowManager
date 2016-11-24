package com.android.windowmanager.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.android.windowmanager.R;

/**
 * Created by Administrator on 2016/8/17.
 */
public class WindowMnagerNoinstanceUtil {
    /**
     * 创建悬浮窗，添加一张美女图
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void createWindow(Context context) {
        final WindowManager mWindowMnager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        WindowManager.LayoutParams windowManagerParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 19) {
            windowManagerParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        } else {
            windowManagerParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        }
        windowManagerParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        // 设置Window flag
        windowManagerParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        /*
         * 注意，flag的值可以为： LayoutParams.FLAG_NOT_TOUCH_MODAL 不影响后面的事件
		 * LayoutParams.FLAG_NOT_FOCUSABLE 不可聚焦 LayoutParams.FLAG_NOT_TOUCHABLE
		 * 不可触摸
		 */
        // 调整悬浮窗口至左上角，便于调整坐标
//        windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
////        // 以屏幕左上角为原点，设置x、y初始值
//        windowManagerParams.x = 0;
//        windowManagerParams.y = 0;
        // 设置悬浮窗口长宽数据
        windowManagerParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        windowManagerParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//        windowManagerParams.gravity = Gravity.CENTER;


        //设置布局
//        final FrameLayout fl = new FrameLayout(context);
//        fl.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        fl.setBackgroundResource(android.R.color.transparent);
//        fl.getBackground().setAlpha(100);

        final RelativeLayout rl = new RelativeLayout(context);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rl.getBackground().setAlpha(200);
        rl.setLayoutParams(rlp);
        ImageView imageView = new ImageView(context);    //设置添加的图片
        RelativeLayout.LayoutParams ivParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ivParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        rl.addView(imageView, ivParams);
        imageView.setImageResource(R.mipmap.girl);

//        fl.addView(rl, rlp);

        mWindowMnager.addView(rl, windowManagerParams);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowMnager.removeViewImmediate(rl);
            }
        });
    }
}

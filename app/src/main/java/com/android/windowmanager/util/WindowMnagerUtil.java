package com.android.windowmanager.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.windowmanager.R;

/**
 * Created by Administrator on 2016/8/17.
 * 单例模式工具类
 */
public class WindowMnagerUtil {
    private static WindowMnagerUtil mWindowInstance;
    private Context context;
    private WindowManager mWindowMnager;  //控制悬浮窗添加和删除
    private WindowManager.LayoutParams wmParams; //设置悬浮窗的参数
    private ImageView imageView;//美女图


    public WindowMnagerUtil(Context context) {
        this.context = context;
    }

    public static WindowMnagerUtil getWindowInstance(Context context) {
        if (mWindowInstance == null)
            mWindowInstance = new WindowMnagerUtil(context);
        return mWindowInstance;
    }

    /**
     * 获取WindowManger对象
     *
     * @param context
     * @return
     */
    public WindowManager getWindowMnager(Context context) {
        if (mWindowMnager == null)
            mWindowMnager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return mWindowMnager;
    }

    /**
     * 创建悬浮窗，添加一张美女图
     */
    public void createWindow() {
        final WindowManager windowMnager = getWindowMnager(context);  //得到WindowManager对象
        wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //只有打电话才会显示在屏幕上方
        wmParams.gravity = Gravity.CENTER;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        imageView = new ImageView(context);    //设置添加的图片
        imageView.setImageResource(R.mipmap.girl);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeWindow();
            }
        });
        windowMnager.addView(imageView, wmParams);
    }


    protected void removeWindow() {
        WindowManager windowMnager = getWindowMnager(context);  //得到WindowManager对象
        windowMnager.removeView(imageView);
    }

}

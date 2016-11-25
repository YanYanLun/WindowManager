

package com.android.windowmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
//        setContentView(initView());
    }

    protected View initView() {
        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundResource(android.R.color.background_light);
        TextView textView = new TextView(this);
        textView.setText("你好");
        rl.addView(textView);

        return rl;
    }

}

package com.example.viewpager_banner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //要加载的图片
    private int[] imgIds = {
            R.mipmap.pic1,
            R.mipmap.pic2,
            R.mipmap.pic3,
    };
    private ViewPager viewPager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                //获得当前的位置
                int currentItem = viewPager.getCurrentItem();
                //跳转到指定位置
                viewPager.setCurrentItem(currentItem + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        //设置适配器
        viewPager.setAdapter(new MyAdapter(imgIds, this));

        //定时器 每两秒执行一次
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        }, 0, 2000);
    }
}

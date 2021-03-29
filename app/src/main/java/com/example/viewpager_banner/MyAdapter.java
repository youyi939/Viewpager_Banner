package com.example.viewpager_banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyAdapter extends PagerAdapter {

    private int[] imagesResource;
    private Context context;

    public MyAdapter(int[] imagesResource, Context context) {
        this.imagesResource = imagesResource;
        this.context = context;
    }

    //获取ViewPager显示数据个数
    @Override
    public int getCount() {
        if (imagesResource == null || imagesResource.length <= 0) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    //判断view和obj是否为同一个view
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //当前项离开屏幕时执行的方法
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    //实例化数据集合中的每一个数据
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //获得布局
        View view =  LayoutInflater.from(context).inflate(R.layout.layout, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(imagesResource[position % imagesResource.length]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(container.getContext(),"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;

    }

}

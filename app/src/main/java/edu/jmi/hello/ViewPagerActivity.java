package edu.jmi.hello;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xujun.viewpagertabindicator.TabPagerIndicator;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {


    private ArrayList<ImageView>  imageViewList = new ArrayList<>();
    private int[] images = new int[]{R.drawable.ad01,R.drawable.ad02,R.drawable.ad03,R.drawable.ad04};
    private ViewPager vpImages;
    private MyAdapter myAdapter;
    private String[] titles = new String[]{"第一页","第二页","第三页","第四页"};
    private TabPagerIndicator tpiTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initData();
        initView();
    }

    private void initView() {
        vpImages = (ViewPager) findViewById(R.id.vp_images);
        tpiTitle = (TabPagerIndicator) findViewById(R.id.tpi_title);
        myAdapter = new MyAdapter();
        vpImages.setAdapter(myAdapter);
        //该句代码必须在ViewPager设置好了Adapter之后
        tpiTitle.setViewPager(vpImages);
        tpiTitle.setIndicatorMode(TabPagerIndicator.IndicatorMode.MODE_WEIGHT_EXPAND_NOSAME,true);



    }

    private void initData() {
        for (int i=0;i<images.length;i++){
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(images[i]);
            imageViewList.add(iv);
        }
    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        //当一个页面显示时实现初始化组件
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViewList.get(position);
            container.addView(iv);
            return iv;
        }
        //当一个页面销毁时移除组件
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));
        }
    }
}

package com.wosloveslife.libs;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wosloveslife.loopviewpager.adapter.LoopViewPagerAdapter;
import com.wosloveslife.loopviewpager.view.LoopViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 轮播图LoopViewPager的实例类
 * Created by WosLovesLife on 2016/7/13.
 */
public class LoopViewExampleActivity extends AppCompatActivity{
    @BindView(R.id.id_vp_loop_view_pager)
    LoopViewPager mLoopViewPager;
    @BindView(R.id.id_vp_loop_view_pager2)
    LoopViewPager mLoopViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_view_example);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        /* 模拟数据 */
        List<Bitmap> data = DataUtils.getBitmaps(getApplicationContext());

        mLoopViewPager.setAdapter(new MyLoopAdapter(data));
        mLoopViewPager.setDuration(3000);

        mLoopViewPager2.setAdapter(new MyLoopAdapter(data));
        mLoopViewPager2.setDuration(1500);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mLoopViewPager.startLoop();
        mLoopViewPager2.startLoop();
    }

    class MyLoopAdapter extends LoopViewPagerAdapter<Bitmap> {

        public MyLoopAdapter(List<Bitmap> data) {
            super(data);
        }

        @Override
        protected View onCreateView(ViewGroup container, int position) {
            final ImageView imageView = new ImageView(container.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageBitmap(mData.get(position));
            return imageView;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        mLoopViewPager.stopLoop();
        mLoopViewPager2.stopLoop();
    }
}

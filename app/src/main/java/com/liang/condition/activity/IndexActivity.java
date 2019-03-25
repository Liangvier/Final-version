package com.liang.condition.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.liang.condition.R;
import com.liang.condition.fragment.AirConditionerFragment;
import com.liang.condition.fragment.TelevisionFragment;
import com.liang.condition.fragment.TvBoxFragment;
import com.liang.condition.fragmentadapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;


public class IndexActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private List<Fragment> fragmentList;
    private ViewPager pager;
    private PagerTabStrip pagerTabStrip;
    private List<String> stringList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        inItUI();
    }

    //初始化UI
    private void inItUI() {
        //标题
        stringList = new ArrayList<>();
        stringList.add("AIRcontrol");
        stringList.add("TVcontrol");
        stringList.add("MORE");
        //数据源
        fragmentList = new ArrayList<>();
        fragmentList.add(new AirConditionerFragment());
        fragmentList.add(new TelevisionFragment());
        fragmentList.add(new TvBoxFragment());
        //标题样式
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.Pt_tab);
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        pagerTabStrip.setTextColor(Color.RED);
        //分割线
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.GREEN);
        //viewPager实例化
        pager = (ViewPager) findViewById(R.id.vp_SideSlip);
        FragmentAdapter myfragmentadapter1 = new FragmentAdapter(getSupportFragmentManager(), fragmentList, stringList);
        pager.setAdapter(myfragmentadapter1);
        pager.setOnPageChangeListener(this);

    }


    /**
     * 滑动页面的监听
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "this is" + position + "page", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

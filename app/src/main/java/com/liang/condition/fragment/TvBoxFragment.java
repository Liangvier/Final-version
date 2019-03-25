package com.liang.condition.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liang.condition.R;



public class TvBoxFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_box, container, false);
       /* //加载视图
        InUi();
        //点击事件
        Event();
        //图片活动链接
        getImageUrl();

        configImageLoader();
        initialize();*/
        return view;
    }
}

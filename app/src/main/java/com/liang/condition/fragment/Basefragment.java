package com.liang.condition.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;


public class Basefragment extends Fragment {
    private Toast mToast = null;
    /**
     * 展示Toast
     *
     * @return
     */
    protected void showToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    protected void showToast(int text) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

}

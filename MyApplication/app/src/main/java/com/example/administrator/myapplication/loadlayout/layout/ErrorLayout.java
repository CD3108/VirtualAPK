package com.example.administrator.myapplication.loadlayout.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.loadlayout.CallBack;


/**
 * @author wangqi
 * @since 2018/4/27 10:40
 */

public class ErrorLayout extends CallBack {

    public ErrorLayout(Context context) {
        super(context);
    }

    @Override
    protected View onCreateView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.loading_error, null, false);
    }
}

package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myapplication.loadlayout.WQLoad;
import com.example.administrator.myapplication.loadlayout.annoation.ErrorClick;
import com.example.administrator.myapplication.loadlayout.layout.EmptyLayout;
import com.example.administrator.myapplication.loadlayout.layout.ErrorLayout;
import com.example.administrator.myapplication.loadlayout.layout.LoadingLayout;
import com.example.administrator.myapplication.vp_fragment.TabActivity;

public class MainActivity extends AppCompatActivity {

    WQLoad wqLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wqLoad = new WQLoad.Builder(this)
                .addLoadingCallBack(new LoadingLayout(this))
                .addEmptyView(new EmptyLayout(this))
                .addErrorView(new ErrorLayout(this))
                .build();
        wqLoad.init(this);

        wqLoad.showLoadingView();


        findViewById(R.id.main_content).postDelayed(new Runnable() {
            @Override
            public void run() {
                wqLoad.showErrorView();
            }
        }, 2000);
    }

    @ErrorClick
    public void pullNet() {
        wqLoad.showLoadingView();
        findViewById(R.id.main_content).postDelayed(new Runnable() {
            @Override
            public void run() {
                wqLoad.showContentView();
            }
        }, 2000);
    }


    public void click(View view) {
        startActivity(new Intent(this, TabActivity.class));
    }

}

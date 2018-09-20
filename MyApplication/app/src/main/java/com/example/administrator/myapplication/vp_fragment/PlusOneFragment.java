package com.example.administrator.myapplication.vp_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.WQLoadingLayout;
import com.example.administrator.myapplication.loadlayout.WQLoad;
import com.example.administrator.myapplication.loadlayout.annoation.ErrorClick;

public class PlusOneFragment extends BaseFragment{


    WQLoad wqLoad;
    TextView plusOneButton;

    public PlusOneFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_plus_one;
    }

    public static PlusOneFragment newInstance(String param1, String param2) {
        PlusOneFragment fragment = new PlusOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void lazyLoad() {
        plusOneButton = mView.findViewById(R.id.plus_one_button);
        plusOneButton.setText("123");//getActivity().getIntent().getExtras().getInt("index")
        wqLoad = new WQLoad.Builder(getActivity())
                .addLoadingCallBack(new WQLoadingLayout(getActivity()))
                .build();

        wqLoad.init(this, mView);
        wqLoad.showLoadingView();

        mView.findViewById(R.id.plus_one_button).postDelayed(new Runnable() {
            @Override
            public void run() {
                wqLoad.showErrorView();
            }
        }, 2000);
    }


    @ErrorClick
    public void pullNet() {
        wqLoad.showLoadingView();
        mView.findViewById(R.id.plus_one_button).postDelayed(new Runnable() {
            @Override
            public void run() {
                wqLoad.showContentView();
                plusOneButton.setVisibility(View.VISIBLE);
            }
        }, 2000);
    }

}

package cn.nzy.virualapkplugindemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.baidu.mapapi.SDKInitializer;

import cn.nzy.virualapkplugindemo.service.LocationService;

/**
 * on 2017/10/19.
 * 类的描述:
 */

public class MyPluginAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plugin);
        ImageView homeIcon2 = (ImageView) findViewById(R.id.image);
        homeIcon2.setImageDrawable(getResources().getDrawable(R.mipmap.environment));
        Button intentButton = (Button) findViewById(R.id.intentButton);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();//NextActivity.class  //"cn.nzy.virualapkplugindemo.NextActivity"
                intent.setClass(MyPluginAcitivity.this, NextActivity.class);
                intent.putExtra("time","2018-9-12" );
                startActivity(intent);
            }
        });


    }
}

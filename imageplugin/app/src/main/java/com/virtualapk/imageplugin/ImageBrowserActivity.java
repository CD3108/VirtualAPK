package com.virtualapk.imageplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by zhuhongyu on 17/7/5.
 */

public class ImageBrowserActivity extends Activity {

    public static final String IMG1_URL = "http://imgtu.5011.net/uploads/content/20170207/3424401486455282.jpg";
    public static final String IMG2_URL = "http://wenwen.soso.com/p/20091231/20091231130529-1963909295.jpg";
    public static final String IMG3_URL = "http://img.17k.com/images/bookcover/2012/608/3/121692.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_main);

        ImageView homeIcon1 = (ImageView) findViewById(R.id.image1);
        ImageView homeIcon2 = (ImageView) findViewById(R.id.image2);
        ImageView homeIcon3 = (ImageView) findViewById(R.id.image3);
        Toast.makeText(this,"此页面为插件化页面",Toast.LENGTH_LONG).show();;
        Picasso.with(this).load(IMG1_URL).into(homeIcon1);
        //Picasso.with(this).load(IMG2_URL).into(homeIcon2);
        Picasso.with(this).load(IMG3_URL).into(homeIcon3);
        homeIcon2.setImageDrawable(getResources().getDrawable(R.mipmap.environment));
    }
}

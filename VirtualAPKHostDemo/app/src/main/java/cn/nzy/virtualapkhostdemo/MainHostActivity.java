package cn.nzy.virtualapkhostdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;

public class MainHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_main);
    }

    public void testA(View view) {
        if (PluginManager.getInstance(this).getLoadedPlugin("cn.nzy.virualapkplugindemo") == null) {
            Toast.makeText(this, "pluginA  not loaded", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.setClassName("cn.nzy.virualapkplugindemo", "cn.nzy.virualapkplugindemo.MyPluginAcitivity");
            startActivity(intent);
        }
    }
    public void testB(View view) {
        if (PluginManager.getInstance(this).getLoadedPlugin("com.virtualapk.imageplugin") == null) {
            Toast.makeText(this, "pluginB  not loaded", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.setClassName("com.virtualapk.imageplugin", "com.virtualapk.imageplugin.ImageBrowserActivity");
            startActivity(intent);
        }
    }

    public void jump(View view) {
        Intent intent = new Intent();//NextActivity.class  //"cn.nzy.virualapkplugindemo.NextActivity"
        intent.setClass(MainHostActivity.this, LocationActivity.class);
        intent.putExtra("time","2018-9-12" );
        startActivity(intent);
    }

    public void jumpB(View view) {
        Intent intent = new Intent();//NextActivity.class  //"cn.nzy.virualapkplugindemo.NextActivity"
        intent.setClassName("com.yonyou.statemachine", "com.yonyou.statemachine.MainActivity");
        intent.putExtra("time","2018-9-12" );
        startActivity(intent);
    }
    public void jumpC(View view) {
        Intent intent = new Intent();//NextActivity.class  //"cn.nzy.virualapkplugindemo.NextActivity"
        intent.setClassName("com.example.administrator.myapplication", "com.example.administrator.myapplication.MainActivity");
        intent.putExtra("time","2018-9-12" );
        startActivity(intent);
    }

}

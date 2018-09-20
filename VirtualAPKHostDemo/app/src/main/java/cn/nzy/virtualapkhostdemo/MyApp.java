package cn.nzy.virtualapkhostdemo;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.didi.virtualapk.PluginManager;

import java.io.File;

import cn.nzy.virtualapkhostdemo.serviceHost.LocationServiceHost;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * on 2017/10/18.
 * 类的描述:
 */

public class MyApp extends Application {

   private String TAG = this.getClass().getSimpleName();
    public LocationServiceHost locationService;
    public Vibrator mVibrator;


    @Override
    protected void attachBaseContext(Context context)  {
        super.attachBaseContext(context);
        PluginManager.getInstance(context).init();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("TTTTTTTTTTTTTTTTTTTTTTT","ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");


        locationService = new LocationServiceHost(getApplicationContext());
        Log.e("TTTTTTTTTTTTTTTTTTTTTTT","ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        Log.e("TTTTTTTTTTTTTTTTTTTTTTT","ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        Log.e("HOST",getApplicationContext().toString());
        Log.e("HOST",getApplicationContext().getPackageResourcePath());
        Log.e("HOST",getApplicationContext().getPackageName());
        Log.e("HOST",getApplicationContext().getPackageCodePath());
        //SDKInitializer.initialize(getApplicationContext());




        PluginManager pluginManager = PluginManager.getInstance(this);
        //此处是当查看插件apk是否存在,如果存在就去加载(比如修改线上的bug,把插件apk下载到sdcard的根目录下取名为Demo.apk)
        File apk = new File(getExternalStorageDirectory()+"/Download/", "Demo.apk");
        if (apk.exists()) {
            try {
                Log.i(TAG,"准备加载A...");
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG,"加载A...GG了");
            }
        }else{
            Log.i(TAG,getExternalStorageDirectory()+"/Download/"+"不存在"+"Demo.apk");
        }
        //ADD B
        apk = new File(getExternalStorageDirectory()+"/Download/", "DemoB.apk");
        if (apk.exists()) {
            try {
                Log.i(TAG,"准备加载B...");
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG,"加载B...GG了");
            }
        }else{
            Log.i(TAG,getExternalStorageDirectory()+"/Download/"+"不存在"+"DemoC.apk");
        }
        //ADD C
        apk = new File(getExternalStorageDirectory()+"/Download/", "DemoC.apk");
        if (apk.exists()) {
            try {
                Log.i(TAG,"准备加载C...");
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG,"加载C...GG了");
            }
        }else{
            Log.i(TAG,getExternalStorageDirectory()+"/Download/"+"不存在"+"DemoC.apk");
        }

        apk = new File(getExternalStorageDirectory()+"/Download/", "DemoD.apk");
        if (apk.exists()) {
            try {
                Log.i(TAG,"准备加载D...");
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG,"加载D...GG了");
            }
        }else{
            Log.i(TAG,getExternalStorageDirectory()+"/Download/"+"不存在"+"DemoD.apk");
        }
    }

}

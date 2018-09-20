package com.yonyou.statemachine;

import java.lang.ref.WeakReference;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		View.OnClickListener, UpdateUIListener {

	private MyStateMachine machine = null;
	private Handler mHandler = null;
	private final static String TAG = "StateMachine";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellosm_activity_main);

		Button btn = (Button) findViewById(R.id.btn_time_out);
		btn.setOnClickListener(this);
		Button restbtn = (Button) findViewById(R.id.btn_rest);
		restbtn.setOnClickListener(this);
		Button defbtn = (Button) findViewById(R.id.btn_default);
		defbtn.setOnClickListener(this);
		Button playbtn = (Button) findViewById(R.id.btn_tired);
		playbtn.setOnClickListener(this);
		Button workbtn = (Button) findViewById(R.id.btn_wake_up);
		workbtn.setOnClickListener(this);
		machine = new MyStateMachine();
		machine.registerListener(this);
		mHandler = new MyHandler(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
			case R.id.btn_default:
				machine.tired();
				break;
		case R.id.btn_wake_up:
			machine.wakeup();
			break;
		case R.id.btn_time_out:
			machine.timeout();
			break;
		case R.id.btn_tired:
			machine.rest();
			break;
		case R.id.btn_rest:
			Log.d(TAG, "btn_rest " );
			machine.toDefault();
			break;
		}
	}

	private void updateText(String text) {
		TextView tx = (TextView) findViewById(R.id.tv);
		tx.setText(text);
	}

	static class MyHandler extends Handler {
		WeakReference<MainActivity> mActivity = null;

		public MyHandler(MainActivity act) {
			mActivity = new WeakReference<MainActivity>(act);
		}

		@Override
		public void handleMessage(Message msg) {
			MainActivity activity = mActivity.get();
			activity.updateText((String) msg.obj);
		}

	};

	@Override
	public void update(String tip) {
		mHandler.obtainMessage(0, tip).sendToTarget();
	}
}

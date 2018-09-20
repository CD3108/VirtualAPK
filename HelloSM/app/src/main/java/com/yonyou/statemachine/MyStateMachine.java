package com.yonyou.statemachine;

import android.os.Message;
import android.util.Log;

import com.yonyou.statemachine.util.State;
import com.yonyou.statemachine.util.StateMachine;

import java.util.HashMap;

public class MyStateMachine extends StateMachine {

	private final static String TAG = "StateMachine";

	private final static int MSG_WORK = 1;
	private final static int MSG_PLAY = 2;
	private final static int MSG_SLEEP = 3;
	private final static int MSG_DEFAULT = 10;
	private final static int MSG_REST = 4;

	private UpdateUIListener listener = null;


	/** The map of all of the states and InstructionSet Info in the state machine */
	public HashMap<State, StateInstructionSetInfo> mStateInstructionSetInfo =
			new HashMap<State, StateInstructionSetInfo>();
	public MyStateMachine() {
		super(TAG);
		addState(mDefaulteState, null);
		addState(mSleepState, mDefaulteState);
		addState(mWorkState, mDefaulteState);
		addState(mPlayState, mDefaulteState);
		addState(mRestState, mPlayState);
		setInitialState(mRestState);
		start();
		mStateInstructionSetInfo.put(mDefaulteState,
				new StateInstructionSetInfo("root","mDefaulteState"));
		mStateInstructionSetInfo.put(mSleepState,
				new StateInstructionSetInfo("sleep","mSleepState"));
		mStateInstructionSetInfo.put(mWorkState,
				new StateInstructionSetInfo("work","mWorkState"));
		mStateInstructionSetInfo.put(mPlayState,
				new StateInstructionSetInfo("play","mPlayState"));
		mStateInstructionSetInfo.put(mRestState,
				new StateInstructionSetInfo("rest","mRestState"));
	}

	public void registerListener(UpdateUIListener l) {
		this.listener = l;
	}

	private void notifyUI(String text) {
		if (listener != null) {
			listener.update(text);
		}
	}

	public void wakeup() {
		Log.d(TAG, "wakeup getName==" + getName()+
				"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());

		sendMessage(MSG_WORK);
	}

	public void timeout() {
		Log.d(TAG, "timeout getName==" + getName()+
				"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());

		sendMessage(MSG_PLAY);
	}

	public void tired() {
		Log.d(TAG, "tired getName==" + getName()+
				"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());

		sendMessage(MSG_SLEEP);
	}

	public void rest() {
		Log.d(TAG, "rest getName==" + getName()+
				"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());

		sendMessage(MSG_REST);
	}
	public void toDefault() {
		Log.d(TAG, "toDefault getName==" + getName()+
				"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());

		Log.d(TAG, " sendMessage_MSG_DEFAULT " );
		sendMessage(MSG_DEFAULT);
	}

	private State mDefaulteState = new DefaultState();

	class DefaultState extends State {

		@Override
		public void enter() {
			Log.d(TAG, "enter getName==" + getName()
					+ "; logRecCount"+getLogRecCount());
			notifyUI(getName());

		}
		@Override
		public boolean processMessage(Message msg) {
			Log.d(TAG, "DefaultState "+msg.toString());
			Log.d(TAG, "enter getName==" + getName()+
					"; StateInstructionSetInfo"+mStateInstructionSetInfo.get(getCurrentState()).toString());
			switch (msg.what) {
				case MSG_REST:
					transitionTo(mSleepState);
					break;
				default:
					return false;
			}
			return true;
		}
	}

	private State mSleepState = new SleepState();

	class SleepState extends State {
		@Override
		public void enter() {
			Log.d(TAG, "enter getName==" + getName());
			notifyUI(getName());
		}

		@Override
		public boolean processMessage(Message msg) {
			Log.d(TAG, "enter getName==" + getName()+
					"; StateInstructionSetInfo"
					+mStateInstructionSetInfo.get(getCurrentState()).toString());
			switch (msg.what) {
			case MSG_WORK:
				transitionTo(mWorkState);
				break;
			default:
				return false;
			}
			return true;
		}
	}

	private State mWorkState = new WorkState();

	class WorkState extends State {
		@Override
		public void enter() {
			Log.d(TAG, "enter getName==" + getName());
			notifyUI(getName());
		}

		@Override
		public boolean processMessage(Message msg) {
			Log.d(TAG, "enter getName==" + getName()+
					"; StateInstructionSetInfo"
					+mStateInstructionSetInfo.get(getCurrentState()).toString());
			switch (msg.what) {
			case MSG_PLAY:
				transitionTo(mPlayState);
				break;
			default:
				return false;
			}
			return true;
		}
	}

	private State mPlayState = new PlayState();

	class PlayState extends State {
		@Override
		public void enter() {
			Log.d(TAG, "enter getName==" + getName());
			notifyUI(getName());

		}

		@Override
		public boolean processMessage(Message msg) {
			Log.d(TAG, "enter getName==" + getName()+
					"; StateInstructionSetInfo"
					+mStateInstructionSetInfo.get(getCurrentState()).toString());
			switch (msg.what) {
			case MSG_REST:
				transitionTo(mRestState);
				break;
			default:
				return false;
			}
			return true;
		}
	}


	private State mRestState = new RestState();

	class RestState extends State {
		@Override
		public void enter() {
			Log.d(TAG, "enter getName==" + getName());
			notifyUI(getName());
		}

		@Override
		public boolean processMessage(Message msg) {
			Log.d(TAG, "enter getName==" + getName()+
					"; StateInstructionSetInfo"
					+mStateInstructionSetInfo.get(getCurrentState()).toString());
			switch (msg.what) {
				case MSG_DEFAULT:
					transitionTo(mDefaulteState);
					break;
				default:
					return false;
			}
			return true;
		}
	}


}

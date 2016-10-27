package com.somnus.androideventbusdemo.base;

import android.os.Bundle;

import com.somnus.androideventbusdemo.utils.Event;
import com.somnus.androideventbusdemo.utils.EventManager;

import org.greenrobot.eventbus.Subscribe;

public abstract class EventActivity extends BaseActivity {

    @Subscribe
    public void onEvent(Event mEvent){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

    }


    @Override
    public void initViews() {
        // TODO Auto-generated method stub

    }


    @Override
    public void initDatas() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventManager.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventManager.unregister(this);
    }
}

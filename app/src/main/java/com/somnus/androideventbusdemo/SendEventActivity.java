package com.somnus.androideventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.somnus.androideventbusdemo.base.BaseActivity;
import com.somnus.androideventbusdemo.utils.Event;
import com.somnus.androideventbusdemo.utils.EventEnum;
import com.somnus.androideventbusdemo.utils.EventManager;

import java.util.HashMap;

/**
 * @date： 2016/10/26.
 * @FileName: com.somnus.androideventbusdemo.SendEventActivity.java
 * @author: Somnus
 * @Description: 发送消息页面
 */

public class SendEventActivity extends BaseActivity implements View.OnClickListener {

    private Button mSendMsg,btn_click_msg_send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    @Override
    public void initViews() {
        mSendMsg = (Button) findViewById(R.id.btn_click_send);
        mSendMsg.setOnClickListener(this);

        btn_click_msg_send = (Button) findViewById(R.id.btn_click_msg_send);
        btn_click_msg_send.setOnClickListener(this);
    }

    @Override
    public void initDatas() {

    }


    @Override
    public void onClick(View v) {
        Event mEvent = new Event();
        switch (v.getId()) {
            case R.id.btn_click_send:
                Toast.makeText(this, "已发送消息,返回查看", Toast.LENGTH_SHORT).show();
                mEvent.setId(EventEnum.EVENT_TEST_MSG1);
                EventManager.post(mEvent);
                break;
            case R.id.btn_click_msg_send:

                mEvent.setId(EventEnum.EVENT_TEST_MSG2);

                HashMap<EventEnum, Object> map = new HashMap<>();
                map.put(EventEnum.EVENT_TEST_MSG2_KEY, "我是消息体");
                mEvent.setParams(map);
                EventManager.post(mEvent);

                break;
        }
    }
}

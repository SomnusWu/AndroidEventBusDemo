package com.somnus.androideventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.somnus.androideventbusdemo.base.EventActivity;
import com.somnus.androideventbusdemo.utils.Event;
import com.somnus.androideventbusdemo.utils.EventEnum;

import java.util.Map;

/**
 * 接收处理消息页面
 */
public class MainActivity extends EventActivity implements View.OnClickListener {

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    public void initViews() {
        super.initViews();
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_msg.setOnClickListener(this);
    }

    @Override
    public void onEvent(Event mEvent) {
        switch (mEvent.getId()) {
            case EVENT_TEST_MSG1:
                Log.d(this.getClass().getName(), "我收到消息啦");
                tv_msg.setText("我收到消息啦");
                break;
            case EVENT_TEST_MSG2:
                Map event = mEvent.getParams();
                String msg = (String) event.get(EventEnum.EVENT_TEST_MSG2_KEY);
                tv_msg.setText(msg);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SendEventActivity.class));
    }
}

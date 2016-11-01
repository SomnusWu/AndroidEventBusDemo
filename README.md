# AndroidEventBusDemo
Android EventBus 简单封装
![image](https://github.com/SomnusWu/AndroidEventBusDemo/blob/master/ab.gif)


EventManager.Java</br>
```Java
public class EventManager {


    public static void register(Object object) {
        if (!EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().register(object);
        }
    }

    public static void unregister(Object object) {
        if (EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().unregister(object);
        }
    }

    public static void post(Object mEvent) {
        EventBus.getDefault().post(mEvent);
    }

}

```


```Java
//需要接收事件的页面需继承该Activity
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
```


发送
```Java
 Event mEvent = new Event();
 mEvent.setId(EventEnum.EVENT_TEST_MSG1);
 EventManager.post(mEvent);
```


发送
```Java
Event mEvent = new Event();
  mEvent.setId(EventEnum.EVENT_TEST_MSG2);
  HashMap<EventEnum, Object> map = new HashMap<>();
  map.put(EventEnum.EVENT_TEST_MSG2_KEY, "我是消息体");
  mEvent.setParams(map);
  EventManager.post(mEvent);
```


接收
```Java
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
```
 
 
 
 

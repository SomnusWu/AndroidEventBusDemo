package com.somnus.androideventbusdemo.utils;

import org.greenrobot.eventbus.EventBus;

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
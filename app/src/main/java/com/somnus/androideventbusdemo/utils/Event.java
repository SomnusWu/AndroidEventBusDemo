package com.somnus.androideventbusdemo.utils;

import java.util.HashMap;

public class Event {

    public EventEnum getId() {
        return id;
    }

    public void setId(EventEnum id) {
        this.id = id;
    }

    public HashMap<EventEnum, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<EventEnum, Object> params) {
        this.params = params;
    }

    public EventEnum id;
    public HashMap<EventEnum, Object> params = new HashMap<EventEnum, Object>();


}

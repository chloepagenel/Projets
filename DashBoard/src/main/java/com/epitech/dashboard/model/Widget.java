package com.epitech.dashboard.model;

public abstract class Widget {
    protected String widgetConfig;
    protected static long count = 0;
    protected  long id ;
    protected String name;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getWidgetConfig() {
        return widgetConfig;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWidgetConfig(String widgetConfig) {
        this.widgetConfig = widgetConfig;
    }
}

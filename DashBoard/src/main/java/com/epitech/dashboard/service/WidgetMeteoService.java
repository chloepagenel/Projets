package com.epitech.dashboard.service;

import com.epitech.dashboard.model.WidgetMeteo;

public class WidgetMeteoService {
    public WidgetMeteo createWidgetMeteo(String src){
        WidgetMeteo widgetMeteo = new WidgetMeteo();
        widgetMeteo.setSrc(src);

        return widgetMeteo;
    }
}

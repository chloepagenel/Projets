package com.epitech.dashboard.service;

import com.epitech.dashboard.model.WidgetBourse;
import com.epitech.dashboard.model.WidgetConversion;
import org.springframework.stereotype.Service;

@Service
public class CryptoWidgetService {
    public WidgetBourse createBourseWidget(String src){
        WidgetBourse widgetBourse = new WidgetBourse();
        widgetBourse.setSrc(src);

        System.out.println(widgetBourse.getSrc());

        return widgetBourse;
    }

    public WidgetConversion createConversionWidget(String src){
        WidgetConversion widgetConversion = new WidgetConversion();
        widgetConversion.setSrc(src);

        return widgetConversion;
    }
}

package com.epitech.dashboard.model;

public class WidgetMeteo extends Widget {
    private final String part1 = "http://www.showmyweather.com/weather_widget.php?int=1&type=js&country=fr&state=&city=";
    private final String part2 = "&smallicon=1&current=1&forecast=1&background_color=ffffff&color=000000&width=175&padding=10&border_width=1&border_color=000000&font_size=11&font_family=Verdana&showicons=1&measure=&d=2021-12-14%22%3E";
    private String src;

    public WidgetMeteo() {
        name = "météo";
        this.id = count;
        count++;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = this.part1 + src + this.part2;
    }
}

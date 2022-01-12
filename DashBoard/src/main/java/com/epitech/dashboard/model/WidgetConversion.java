package com.epitech.dashboard.model;

public class WidgetConversion extends Widget{
    private final String part1 = "https://freecurrencyrates.com/fr/widget-horizontal-editable?iso=";
    private final String part2 = "&df=1&p=FneoOcbwu&v=fits&source=fcr&width=400&width_title=200&firstrowvalue=1&thm=A6C9E2,FCFDFD,4297D7,5C9CCC,FFFFFF,C5DBEC,FCFDFD,2E6E9E,000000&title=Convertisseur%20de%20devises&tzo=-60";
    private String src;

    public WidgetConversion(){
        this.id = count;
        count++;
        name = "widgetConversion";
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String ... values) {
        String result="";
        for(int i=0;i< values.length;i++){
            result=values[i];
        }
        result = result.replaceAll(",", "-");
        /*System.out.print(result);*/
        this.src = this.part1 + result + this.part2;
    }

}

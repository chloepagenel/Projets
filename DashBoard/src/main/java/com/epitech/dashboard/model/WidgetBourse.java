package com.epitech.dashboard.model;

public class WidgetBourse extends Widget{
    private final String part1 = "https://www.strategie-bourse.com/widget/tableau-cours.php?langue=fr&type_actif=";
    private final String part2 = "&couleur_entete=212121&background=FFF";
    private String src;

    public WidgetBourse(){
        name = "widgetBourse";
        this.id = count;
        count++;
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


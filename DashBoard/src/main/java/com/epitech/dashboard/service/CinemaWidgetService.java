package com.epitech.dashboard.service;

import com.epitech.dashboard.model.CinemaWidget;
import com.omertron.omdbapi.OMDBException;
import com.omertron.omdbapi.OmdbApi;
import com.omertron.omdbapi.model.OmdbVideoFull;
import com.omertron.omdbapi.model.SearchResults;
import com.omertron.omdbapi.tools.OmdbBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Service
public class CinemaWidgetService {
    public CinemaWidget createCinemaWidget(String film, int year){
        CinemaWidget cinemaWidget = new CinemaWidget(new OmdbApi("5c3072e0"));
        String error = null;
        OmdbVideoFull resultFilm = null;
        try {
            resultFilm = cinemaWidget.getOmdbApi().getInfo(new OmdbBuilder().setTitle(film).setYear(year).setTypeMovie().setTomatoesOff().build());

            cinemaWidget.setActors(resultFilm.getActors());
            cinemaWidget.setResume(resultFilm.getPlot());
            cinemaWidget.setAwards(resultFilm.getAwards());
            cinemaWidget.setWriter(resultFilm.getWriter());
            cinemaWidget.setImage(resultFilm.getPoster());
            cinemaWidget.setTitle(resultFilm.getTitle());

        } catch (OMDBException e) {
            cinemaWidget.setError("Film introuvable");

        }
        return cinemaWidget;
    }
    public CinemaWidget createCinemaWidgetList(String film) {
        CinemaWidget cinemaWidget = new CinemaWidget(new OmdbApi("5c3072e0"));
        SearchResults results = null;
        try {
            results = cinemaWidget.getOmdbApi().search(new OmdbBuilder().setSearchTerm(film).setTypeMovie().setTomatoesOff().build());
            String filmsTrouves = results.toString();
            String[] infoFilmTableau = filmsTrouves.split(",");
            ArrayList<String> tableauIntermediaire = new ArrayList<>();

            for (int i = 0; i < infoFilmTableau.length - 1; i++) {
                tableauIntermediaire.add(infoFilmTableau[i]);
            }

            ArrayList<ArrayList<String>> tableauFinal = new ArrayList<>();

            while (tableauIntermediaire.size() > 9) {

                ArrayList<String> petitTableau = new ArrayList<>();

                for (int j = 0; j < 8; j++) {
                    String indexTableau = tableauIntermediaire.get(j);
                    petitTableau.add(indexTableau);
                }

                for (int i = 0; i < 8; i++) {
                    tableauIntermediaire.remove(tableauIntermediaire.get(0));
                }
                tableauFinal.add(petitTableau);

                String bruh = "";
                cinemaWidget.setListImage(new ArrayList<>());
                cinemaWidget.setListTitleYear(new ArrayList<>());
                for (int i = 0; i < tableauFinal.size(); i++) {
                    ArrayList<String> petitArray = tableauFinal.get(i);

                    for (int j = 0; j < petitArray.size(); j++) {
                        if (j == 1) {
//                    image
                            String elementString = petitArray.get(1);
                            int k = elementString.indexOf("=");
                            bruh = elementString.substring(k + 1);
                            cinemaWidget.getListImage().add(bruh);
                        } else if (j == 3) {
//                    title
                            String elementString = petitArray.get(3);
                            int k = elementString.indexOf("=");
                            bruh = elementString.substring(k + 1);
                            cinemaWidget.getListTitleYear().add(bruh);

                        } else if (j == 5) {
//                    year
                            String elementString = petitArray.get(5);
                            int k = elementString.indexOf("=");
                            bruh = elementString.substring(k + 1);
                            cinemaWidget.getListTitleYear().add(bruh);
                        }
                    }
                }
            }
        } catch (OMDBException e) {
            cinemaWidget.setError("Film introuvable");
        }
        return cinemaWidget;
    }
}

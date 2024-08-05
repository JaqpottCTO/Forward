package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShowManager {
    
    private List<Show> shows;

    public ShowManager() {
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public void voteForShow(String showId) {
        for (Show show : shows) {
            if (show.getId().equals(showId)) {
                show.incrementVotes();
                break;
            }
        }
    }

    public Show getTopShow() {
        return shows.stream().max(Comparator.comparing(Show::getVotes)).orElse(null);
    }
}

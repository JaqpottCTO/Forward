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

    public void voteForShow(Show show) {
        show.incrementVotes();
    }

    public Show getTopShow() {
        return shows.stream().max(Comparator.comparing(Show::getVotes)).orElse(null);
    }
}

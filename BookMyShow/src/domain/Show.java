package domain;

import java.time.LocalDateTime;

public class Show {

    private int id;
    private Movie movie;
    private List<ShowSeat> showSeatList;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public Show(int id, Movie movie, List<ShowSeat> showSeatList, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movie = movie;
        this.showSeatList = showSeatList;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

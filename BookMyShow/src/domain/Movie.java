package domain;

public class Movie {
    private int id;
    private String title;
    private long duration;
    private String language;

    public Movie(int id, String title, long duration, String language) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

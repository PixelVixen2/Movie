public class Movie {
    private String title;
    private int duration;
    private String rating;

    public Movie(String title, int duration, String rating) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getRating() {
        return this.rating;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}


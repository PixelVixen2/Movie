import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Show {
    private Movie movie;
    private LocalDateTime showtime;

    public Show(Movie movie, LocalDateTime showtime) {
        this.movie = movie;
        this.showtime = showtime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = this.showtime.format(formatter);
        return this.movie.getTitle() + " at " + formattedDateTime;
    }

    // Getter methods
    public Movie getMovie() {
        return this.movie;
    }

    public LocalDateTime getShowtime() {
        return this.showtime;
    }

    // No setter methods because the movie and showtime are set when the show is created and shouldn't change
}


import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;

public class TicketBooking {
    private ArrayList<Movie> movies;
    private ArrayList<Show> shows;
    private Auditorium auditorium;

    public TicketBooking() {
        this.movies = new ArrayList<Movie>();
        this.shows = new ArrayList<Show>();
        this.auditorium = new Auditorium(100);  // 100 seats
    }

    public void addMovie(String title, int duration, String rating) {
        this.movies.add(new Movie(title, duration, rating));
    }
    public Movie getMovie(String title) {
        for (Movie movie : this.movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    public void createShow(String title, LocalDateTime showtime) {
        Movie movie = getMovie(title);
        if (movie != null) {
            Show show = new Show(movie, showtime);
            this.shows.add(show);
        }
    }


    public ArrayList<Integer> getAvailableSeats() {
        ArrayList<Integer> availableSeats = new ArrayList<Integer>();
        for (Seat seat : this.auditorium.getSeats()) {
            if (!seat.isBooked()) {
                availableSeats.add(seat.getId());
            }
        }
        return availableSeats;
    }

    public boolean bookSeat(Show show, int seatId) {
        if (this.shows.contains(show)) {
            return this.auditorium.bookSeat(seatId);
        }
        return false;
    }

    public ArrayList<Show> getShows() {
        return this.shows;
    }

    // Getters
    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public Auditorium getAuditorium() {
        return this.auditorium;
    }

    // No setters because these properties are initialized when the TicketBooking object is created and should not change.
}




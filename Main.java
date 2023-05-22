import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;



public class Main {
    public static void main(String[] args) {
        // Create a new ticket booking system
        TicketBooking bookingSystem = new TicketBooking();

        // Add a few movies
        bookingSystem.addMovie("Fast X", 141, "PG-13");
        bookingSystem.addMovie("Scream 6", 122, "R");
        bookingSystem.addMovie("Spider-Man: Far From Home", 130, "R");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Set the start time to 10:00 today
        LocalDateTime startTime = now.withHour(10).withMinute(0).withSecond(0).withNano(0);

        // If the current time is after 10:00, set the start time to 10:00 tomorrow
        if (now.isAfter(startTime)) {
            startTime = startTime.plusDays(1);
        }

        // Get the end time (10:00 tomorrow)
        LocalDateTime endTime = startTime.plusDays(1);

        // Create shows starting from the start time and continuing until the end time
        for (Movie movie : bookingSystem.getMovies()) {
            // Reset the current time to the start time for each movie
            LocalDateTime currentTime = startTime;

            while (currentTime.isBefore(endTime)) {
                bookingSystem.createShow(movie.getTitle(), currentTime);
                // Add the duration of the movie plus a fixed transition time (20 minutes here) to the current time
                currentTime = currentTime.plus(movie.getDuration() + 20, ChronoUnit.MINUTES);
            }
        }

        // Create a scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Show a list of movies
        System.out.println("Available movies:");
        ArrayList<Movie> movies = bookingSystem.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + 1 + ". " + movies.get(i).getTitle());
        }

        // Ask the user to choose a movie
        System.out.print("Enter the number of the movie you want to book a ticket for: ");
        int movieIndex = scanner.nextInt() - 1;
        Movie chosenMovie = movies.get(movieIndex);

        // Show a list of shows for the chosen movie
        System.out.println("Shows for " + chosenMovie.getTitle() + ":");
        ArrayList<Show> shows = bookingSystem.getShows();
        ArrayList<Show> chosenMovieShows = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i = 0, j = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            if (show.getMovie().equals(chosenMovie)) {
                String formattedDateTime = show.getShowtime().format(formatter);
                System.out.println(j + 1 + ". " + formattedDateTime);
                chosenMovieShows.add(show);
                j++;
            }
        }

        // Ask the user to choose a show
        System.out.print("Enter the number of the show you want to book a ticket for: ");
        int showIndex = scanner.nextInt() - 1;
        Show chosenShow = chosenMovieShows.get(showIndex);

        // Show available seats
        ArrayList<Integer> availableSeats = bookingSystem.getAvailableSeats();
        System.out.println("Available seats: " + availableSeats);

        // Ask the user to choose a seat
        System.out.print("Enter the number of the seat you want to book: ");
        int seatId = scanner.nextInt();

        // Book the seat
        if (bookingSystem.bookSeat(chosenShow, seatId)) {
            System.out.println("Successfully booked seat " + seatId + " for " + chosenShow.getMovie().getTitle() + " at " + chosenShow.getShowtime() + ".");
        } else {
            System.out.println("Failed to book seat " + seatId + ".");
        }

        // Close the scanner
        scanner.close();
    }
}



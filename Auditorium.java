public class Auditorium {
    private Seat[] seats;

    public Auditorium(int numSeats) {
        this.seats = new Seat[numSeats];
        for (int i = 0; i < numSeats; i++) {
            this.seats[i] = new Seat(i);
        }
    }

    public boolean bookSeat(int seatId) {
        return this.seats[seatId].bookSeat();
    }

    // Getter
    public Seat[] getSeats() {
        return this.seats;
    }

    // No setter for seats because it should not change once the auditorium is created.
}

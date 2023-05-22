public class Seat {
    private int id;
    private boolean isBooked;

    public Seat(int id) {
        this.id = id;
        this.isBooked = false;
    }

    public boolean bookSeat() {
        if (!this.isBooked) {
            this.isBooked = true;
            return true;
        }
        return false;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public boolean isBooked() {
        return this.isBooked;
    }

// No setter for id because it should not change once the seat is created
// No setter for isBooked because it is updated through the bookSeat method.
}


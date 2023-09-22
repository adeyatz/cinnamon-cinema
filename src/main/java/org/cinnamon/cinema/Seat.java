package org.cinnamon.cinema;

public class Seat {
    private String row;
    private int seatNumber;
    private boolean isAllocated = false;
    public Seat(String row, int seatNumber) {
        this.row = row.toUpperCase();
        this.seatNumber = seatNumber;
    }

    public String getPosition() {
        return String.format("%s%d", row,seatNumber);
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void allocate() {
        isAllocated = true;
    }
}

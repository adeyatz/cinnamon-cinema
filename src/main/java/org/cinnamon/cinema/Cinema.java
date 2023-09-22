package org.cinnamon.cinema;

import java.util.Collection;
import java.util.List;

public class Cinema {

    private List <Seat> seats;

    public Cinema(int rowsCount, int seatPerRowCount) {
        SeatPlanner planner = new SeatPlannerZigZag();

        seats = planner.getSeats(rowsCount, seatPerRowCount);
    }

    public List<Seat> requestFreeSeats() {
        return seats.stream().filter(seat -> !seat.isAllocated()).toList();
    }

    public List<Seat>  requestOccupiedSeats() {
        return seats.stream().filter(seat -> seat.isAllocated()).toList();
    }

    public List<Seat> bookSeats(int i) {
        return null;
    }
}

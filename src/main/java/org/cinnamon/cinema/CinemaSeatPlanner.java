package org.cinnamon.cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaSeatPlanner implements SeatPlanner {
    @Override
    public List<Seat> getSeats(int rowCount, int seatCount) {

        if (rowCount == 0 || seatCount == 0)
            throw new IllegalArgumentException("Cannot have 0 rows or seats");

        List <Seat> seats = new ArrayList<Seat>();

        seats.add(new Seat("A", 1));

        return seats;
    }
}

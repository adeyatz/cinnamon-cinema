package org.cinnamon.cinema;

import java.util.List;

public interface SeatPlanner {
    public List<Seat> getSeats (int rowCount, int seatCount);
}

package org.cinnamon.cinema;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaSeatPlannerTest {

    @Test
    void testGetSeats () {
        SeatPlanner planner = new CinemaSeatPlanner();

        List<Seat> seats =  planner.getSeats(1,1);

        assertEquals(seats.size(), 1);
    }
}
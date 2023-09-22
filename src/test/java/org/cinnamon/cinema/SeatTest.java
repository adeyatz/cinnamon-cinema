package org.cinnamon.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test static void testSeatCreation () {
        Seat seat = new Seat("A", 1);

        assertEquals(seat.getPosition(), "A1");
    }

    @Test static void testSeatIsNotAllocated () {
        Seat seat = new Seat("A", 1);

        assertFalse(seat.isAllocated());
    }

}
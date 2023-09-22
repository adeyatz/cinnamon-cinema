package org.cinnamon.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test void testSeatCreation () {
        Seat seat = new Seat("A", 1);

        assertEquals(seat.getPosition(), "A1");
    }

    @Test void testSeatCreationLowerCase () {
        Seat seat = new Seat("aA", 112);

        assertEquals(seat.getPosition(), "AA112");
    }


    @Test void testSeatIsNotAllocated () {
        Seat seat = new Seat("A", 1);

        assertFalse(seat.isAllocated());
    }


    @ Test void testSeatIsAllocated () {
        Seat seat = new Seat ("A", 1);

        seat.allocate();

        assertTrue (seat.isAllocated());
    }

}
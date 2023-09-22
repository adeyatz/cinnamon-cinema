package org.cinnamon.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    private Cinema testCinema;

    @Test
    void testConstructor () {
        testCinema = new Cinema(3,5);

        assertNotNull(testCinema);
    }

    @Test
    void testRequestFreeSeatsOneSeatCinema () {
        testCinema = new Cinema(1, 1);

        List<Seat> seats = testCinema.requestFreeSeats();

        assertEquals(1, seats.size());
        assertFalse(seats.get(0).isAllocated());
    }

    @Test
    void testRequestFreeSeatsTwentySeatCinema () {
        testCinema = new Cinema(2, 10);

        List<Seat> seats = testCinema.requestFreeSeats();

        assertEquals(20, seats.size());
    }

    @Test
    void testRequestOccupiedSeatsTwentySeatCinemaEmpty () {
        testCinema = new Cinema(2, 10);

        List<Seat> seats = testCinema.requestOccupiedSeats();

        assertEquals(0, seats.size());
    }

    @Test
    void testBookSeats () {
        testCinema = new Cinema(2, 1);

        List<Seat> seats = testCinema.bookSeats (2);

        assertEquals(2, seats.size());
        assertEquals("A1", seats.get(0).getPosition());
        assertEquals("B1", seats.get(1).getPosition());
    }

}
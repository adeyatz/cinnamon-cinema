package org.cinnamon.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    @Test
    void testBookSeatsTooMany () {
        testCinema = new Cinema(1, 10);

        List<Seat> seats = testCinema.bookSeats (4);

        assertNull(seats);
    }

    @Test
    void testBookSeatsTooFew () {
        testCinema = new Cinema(1, 10);

        List<Seat> seats = testCinema.bookSeats (0);

        assertNull(seats);
    }



    @Test
    void testBookSeatsTooManyForSeatCount () {
        testCinema = new Cinema(1, 2);

        List<Seat> seats = testCinema.bookSeats (3);

        assertNull(seats);
    }


    @Test
    void testBookSeatsThreeRowsByFive () {
        testCinema = new Cinema(3, 5);

        List<Seat> seats = testCinema.bookSeats (2);

        assertEquals(2, seats.size());
        assertEquals("A1", seats.get(0).getPosition());
        assertEquals("A2", seats.get(1).getPosition());

        seats = testCinema.bookSeats (1);

        assertEquals(1, seats.size());
        assertEquals("A3", seats.get(0).getPosition());

        seats = testCinema.bookSeats (3);

        assertEquals(3, seats.size());
        assertEquals("A4", seats.get(0).getPosition());
        assertEquals("A5", seats.get(1).getPosition());
        assertEquals("B5", seats.get(2).getPosition());

        List<Seat> freeSeats = testCinema.requestFreeSeats();
        assertEquals(9, freeSeats.size());
        assertEquals("B4", freeSeats.get(0).getPosition());

        List<Seat> occupiedSeats = testCinema.requestOccupiedSeats();
        assertEquals(6, occupiedSeats.size());
        assertEquals("A1", occupiedSeats.get(0).getPosition());
        assertEquals("B5", occupiedSeats.get(occupiedSeats.size() - 1).getPosition());

    }


    Supplier <Integer> nextTicketsSize = () -> Math.toIntExact(Math.round(Math.random() * 2) + 1);

    @Test
    void testThreeByFiveUntilFull() {
        testCinema = new Cinema(3, 5);
        List<Seat> seats;

        do {
            int size = nextTicketsSize.get();
            System.out.println("Size:" + size);

            seats = testCinema.bookSeats (size);
            if (seats == null) {
                System.out.println("Failed to get seats");
            } else {
                seats.stream().forEach(seat -> System.out.println(seat.getPosition()));
            }

        } while (seats != null);
    }


}
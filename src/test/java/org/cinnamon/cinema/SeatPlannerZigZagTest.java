package org.cinnamon.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatPlannerZigZagTest {

    private SeatPlanner planner;
    @BeforeEach
    void init (){
        planner = new SeatPlannerZigZag();
    }

    @Test
    void testGetSeats () {
        List<Seat> seats =  planner.getSeats(1,1);

        assertEquals(seats.size(), 1);
        assertEquals("A1", seats.get(0).getPosition());
    }

    @Test
    void testGetSeatsZeroSeatCount () {

        try {
            List<Seat> seats = planner.getSeats(1, 0);
            fail ("Test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    void testGetRowsGreaterThan26 () {

        try {
            List<Seat> seats = planner.getSeats(27, 1);
            fail ("Test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    void testGetSeatsOneRowTenSeats () {

        List <Seat> seats = planner.getSeats(1, 10);

        assertEquals("A1", seats.get (0).getPosition());
        assertEquals("A10", seats.get (9).getPosition());
    }

    @Test
    void testGetSeatsTwoRowsOneSeat () {

        List <Seat> seats = planner.getSeats(2, 1);

        assertEquals(seats.size(),2);
        assertEquals("A1", seats.get (0).getPosition());
        assertEquals("B1", seats.get (1).getPosition());
    }


    @Test
    void testGetSeats26Rows1Seat () {

        List <Seat> seats = planner.getSeats(26, 1);

        assertEquals(seats.size(),26);
        assertEquals("A1", seats.get (0).getPosition());
        assertEquals("Z1", seats.get (25).getPosition());
    }
    @Test
    void testGetSeatsTwoRowsTenSeats () {

        List <Seat> seats = planner.getSeats(2, 10);

        assertEquals(seats.size(),20);
        assertEquals("A1",seats.get (0).getPosition());
        assertEquals("A10", seats.get (9).getPosition());
        assertEquals("B10", seats.get (10).getPosition());
        assertEquals("B1", seats.get (19).getPosition());
    }
    @Test
    void testGetSeatsThreeRowsFiveSeats () {
        List <Seat> seats = planner.getSeats(3, 5);

        assertEquals(seats.size(),15);
        assertEquals("A1", seats.get (0).getPosition());
        assertEquals("A5", seats.get (4).getPosition());
        assertEquals("B5", seats.get (5).getPosition());
        assertEquals("B1", seats.get (9).getPosition());
        assertEquals("C1",seats.get (10).getPosition());
        assertEquals("C5",seats.get (14).getPosition());
    }

}
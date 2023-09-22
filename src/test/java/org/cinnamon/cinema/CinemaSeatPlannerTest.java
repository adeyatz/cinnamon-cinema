package org.cinnamon.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaSeatPlannerTest {

    SeatPlanner planner;
    @BeforeEach
    void init (){
        SeatPlanner planner = new CinemaSeatPlanner();
    }

    @Test
    void testGetSeats () {
        List<Seat> seats =  planner.getSeats(1,1);

        assertEquals(seats.size(), 1);
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
    void testGetSeatsOneRowTenSeats () {

        List <Seat> seats = planner.getSeats(1, 10);

        assertEquals(seats.get (0).getPosition(),"A1");
        assertEquals(seats.get (9).getPosition(),"A10");
    }

    @Test
    void testGetSeatsTwoRowsOneSeat () {

        List <Seat> seats = planner.getSeats(2, 1);

        assertEquals(seats.size(),2);
        assertEquals(seats.get (0).getPosition(),"A1");
        assertEquals(seats.get (2).getPosition(),"B1");
    }

    @Test
    void testGetSeatsTwoRowsTenSeats () {

        List <Seat> seats = planner.getSeats(2, 10);

        assertEquals(seats.size(),20);
        assertEquals(seats.get (0).getPosition(),"A1");
        assertEquals(seats.get (9).getPosition(),"A10");
        assertEquals(seats.get (10).getPosition(),"B10");
        assertEquals(seats.get (19).getPosition(),"B1");
    }
    @Test
    void testGetSeatsThreeRowsFiveSeats () {
        List <Seat> seats = planner.getSeats(3, 5);

        assertEquals(seats.size(),15);
        assertEquals(seats.get (0).getPosition(),"A1");
        assertEquals(seats.get (4).getPosition(),"A5");
        assertEquals(seats.get (5).getPosition(),"B5");
        assertEquals(seats.get (9).getPosition(),"B1");
        assertEquals(seats.get (10).getPosition(),"C1");
        assertEquals(seats.get (14).getPosition(),"C5");
    }

}
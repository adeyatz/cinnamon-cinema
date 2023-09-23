package org.cinnamon.app;

import org.cinnamon.cinema.Cinema;
import org.cinnamon.cinema.Seat;

import java.util.List;
import java.util.function.Supplier;

public class Main {
    static Supplier<Integer> getSeatNumBetweenOneAndThree = () -> Math.toIntExact(Math.round(Math.random() * 2) + 1);
    static final int rows = 3;
    static final int seatsPerRow = 5;

    public static void main(String[] args) {

        System.out.println("Create cinema with " + rows + " rows, " + seatsPerRow + " seats per row");
        Cinema cinnemonCinema = new Cinema(rows,seatsPerRow);

        List <Seat> emptySeats = cinnemonCinema.requestFreeSeats();
        System.out.println("Empty Seats:");
        emptySeats.stream().forEach(seat -> System.out.println(seat.getPosition()));


        while (true) {
            int size = getSeatNumBetweenOneAndThree.get();
            System.out.println("Ticket Request Size:" + size);

            List<Seat> seats = cinnemonCinema.bookSeats (size);
            if (seats == null) {
                System.out.println("Failed to get " + size + " seats");
                break;
            } else {
                seats.stream().forEach(seat -> System.out.println(seat.getPosition()));
            }
        }

        System.out.println("Empty Seats Remaining:");
        cinnemonCinema.requestFreeSeats().stream().forEach(seat -> System.out.println(seat.getPosition()));

    }
}
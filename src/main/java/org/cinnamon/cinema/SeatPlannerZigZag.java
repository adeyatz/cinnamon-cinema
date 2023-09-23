package org.cinnamon.cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SeatPlannerZigZag implements SeatPlanner {

    private Character startRow;

    public SeatPlannerZigZag() {
        this.startRow = 'A';
    }

    @Override
    public List<Seat> getSeats(int rowCount, int seatCount) {
        int inc = 1;

        if (rowCount <= 0 || seatCount <= 0)
            throw new IllegalArgumentException("Cannot have 0 rowCount or seatCount");

        List <Seat> seats = new ArrayList<Seat>();

        // For A1-A5,B1-B5 etc
        IntStream.range(0,rowCount)
                .forEach(i -> getRowStream.apply(i, seatCount)
                        .forEach(seat -> seats.add(new Seat(getRowAsString.apply(i), seat))
                        ));

        return seats;
    }

    Function <Integer, String> getRowAsString = (i) -> String.valueOf((char) (this.startRow + i));

    BiFunction <Integer, Integer, IntStream> getRowStream = (row, seatCount) ->
            row % 2 == 0 ? IntStream.rangeClosed(1, seatCount) :
                    IntStream.iterate(seatCount,i -> i-1).limit(seatCount);
}

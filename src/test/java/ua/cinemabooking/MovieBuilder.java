package ua.cinemabooking;

import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Seans;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by andreb on 11.02.17.
 */
public class MovieBuilder {

    public static Movie createThinMovie(){
        Movie legionMovie = new Movie();
        legionMovie.setName("Legion");
        legionMovie.setDescription("Legion serial on Fox");
        return legionMovie;
    }

    public static Movie createFullMovie(){
        Movie legionMovie = new Movie();
        legionMovie.setName("Legion");
        legionMovie.setDescription("Legion serial on Fox");
        Seans seans = new Seans();
        seans.setMovie(legionMovie);
        LocalDateTime start = LocalDateTime.of(2017, 02, 11, 18, 00);
        seans.setTime(start);
        seans.initiateTickets(new BigDecimal("75.00"));
        legionMovie.getSeanses().add(seans);
        return legionMovie;
    }
}

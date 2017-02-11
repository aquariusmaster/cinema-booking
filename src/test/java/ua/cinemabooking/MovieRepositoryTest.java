package ua.cinemabooking;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Seans;
import ua.cinemabooking.repository.MovieRepository;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by andreb on 11.02.17.
 * Integration Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Ignore
    @Test
    public void saveMovieTest(){

        Movie legionMovie = MovieBuilder.createThinMovie();

        movieRepository.save(legionMovie);
        List<Movie> fetchedMovies =  movieRepository.findAll();
        System.out.println(fetchedMovies);
        assertThat(fetchedMovies,  hasSize(1));

    }

    @Test
    public void saveFullMovieTest(){

        Movie legionMovie = MovieBuilder.createFullMovie();
        movieRepository.save(legionMovie);
        List<Movie> fetchedMovies =  movieRepository.findAll();
        System.out.println(fetchedMovies);
        assertThat(fetchedMovies,  hasSize(1));

    }
}

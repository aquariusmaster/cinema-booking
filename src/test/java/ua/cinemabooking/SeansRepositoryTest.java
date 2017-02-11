package ua.cinemabooking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Seans;
import ua.cinemabooking.repository.MovieRepository;
import ua.cinemabooking.repository.SeansRepository;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by andreb on 11.02.17.
 * Integration Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeansRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    SeansRepository seansRepository;

    @Before
    public void clearDatabase(){
        movieRepository.deleteAll();
        seansRepository.deleteAll();
    }

    @Test
    public void findSeansByMovieTest(){

        Movie legionMovie = MovieBuilder.createFullMovie();
        movieRepository.save(legionMovie);
        List<Movie> fetchedMovies =  movieRepository.findAll();
        System.out.println(fetchedMovies);
        List<Seans> seanses = seansRepository.findByMovie(legionMovie);
        System.out.println(seanses);
        assertThat(seanses, hasSize(1));
        assertThat(seanses, hasItem(legionMovie.getSeanses().get(0)));

    }
}

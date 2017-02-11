package ua.cinemabooking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Seans;
import ua.cinemabooking.model.Place;
import ua.cinemabooking.repository.MovieRepository;
import ua.cinemabooking.repository.SeansRepository;
import ua.cinemabooking.repository.PlaceRepository;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by andreb on 11.02.17.
 * Integration Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    SeansRepository seansRepository;
    @Autowired
    PlaceRepository placeRepository;

    @Before
    public void clearDatabase(){
        movieRepository.deleteAll();
        seansRepository.deleteAll();
        placeRepository.deleteAll();
    }

    @Test
    public void findSeansByMovieTest(){

        Movie legionMovie = MovieBuilder.createFullMovie();
        movieRepository.save(legionMovie);
        Seans seans = seansRepository.findByMovie(legionMovie).get(0);
        List<Place> places = placeRepository.findBySeans(seans);
        assertThat(places,  hasSize(100));

    }
}

package ua.cinemabooking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.repository.MovieRepository;

/**
 * Created by andreb on 11.02.17.
 * Integration Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void saveMovieTest(){

        Movie movie = new Movie();
        movie.setName("Legion");
        movie.setDescription("Legion serial on Fox");

    }
}

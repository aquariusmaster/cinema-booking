package ua.cinemabooking.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.repository.MovieRepository;

import java.util.List;

/**
 * Created by andreb on 11.02.17.
 */
@Controller
public class MovieController {

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/")
    public String getMovies(Model model){

        List<Movie> movies = movieRepository.findAll();
        logger.info("getMovies:" + movies);
        model.addAttribute("movies", movies);
        return "afisha";
    }


}

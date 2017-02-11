package ua.cinemabooking.controllers;

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

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/")
    public String getMovies(Model model){

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "afisha";
    }
}

package ua.cinemabooking.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.cinemabooking.model.Movie;
import org.springframework.data.repository.CrudRepository;
import ua.cinemabooking.model.Seans;

import java.util.List;

/**
 * Created by RATIBOR on 04.02.2017.
 */
public interface MovieRepository extends CrudRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {

    List<Movie> findAll();
    Movie findByName(String name);
}

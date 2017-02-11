package ua.cinemabooking.repository;

import ua.cinemabooking.model.Seans;
import ua.cinemabooking.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RATIBOR on 04.02.2017.
 */
public interface PlaceRepository extends CrudRepository<Place,Long> {
    List<Place> findBySeans(Seans seans);
}

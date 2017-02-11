package ua.cinemabooking.repository;

import ua.cinemabooking.model.Ticket;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by RATIBOR on 04.02.2017.
 */
public interface PlaceRepository extends CrudRepository<Ticket,Long> {

}

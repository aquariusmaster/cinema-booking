package ua.cinemabooking.repository;

import ua.cinemabooking.model.Seans;
import ua.cinemabooking.model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RATIBOR on 04.02.2017.
 */
public interface TicketRepository extends CrudRepository<Ticket,Long> {
    List<Ticket> findBySeans(Seans seans);
}

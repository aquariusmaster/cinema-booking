package ua.cinemabooking.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RATIBOR on 04.02.2017.
 */
@Entity
public class Seans {

    @Id @GeneratedValue
    private Long seansId;
    private LocalDateTime start;
    @ManyToOne
    private Movie movie;
    @Transient
    private final short SEATSCOUNT = 100;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seans")
    private List<Ticket> tickets = new ArrayList<>(SEATSCOUNT);



    public Long getSeansId() {
        return seansId;
    }

    public void setSeansId(Long seansId) {
        this.seansId = seansId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seans seans = (Seans) o;

        if (start != null ? !start.equals(seans.start) : seans.start != null) return false;
        return movie != null ? movie.equals(seans.movie) : seans.movie == null;

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        return result;
    }

    /*
    Method do populate Ticket
     */
    public void initiateTickets(BigDecimal price) {

        //TODO setup rows and seats
        for(int i = 0; i < SEATSCOUNT; i++){

            Ticket ticket = new Ticket();
            ticket.setPrice(price);
            ticket.setSeans(this);
            tickets.add(ticket);
        }
    }

    @Override
    public String toString() {
        return "Seans{" +
                "seansId=" + seansId +
                ", start=" + start +
                ", movie=" + movie.getName() +
                ", tickets=" + tickets +
                '}';
    }
}

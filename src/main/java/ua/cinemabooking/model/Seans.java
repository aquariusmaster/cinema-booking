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
    private LocalDateTime time;
    @ManyToOne
    private Movie movie;
    @Transient
    private final static short SEATSCOUNT = 100;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seans")
    private List<Ticket> tickets = new ArrayList<>(SEATSCOUNT);

    public Long getSeansId() {
        return seansId;
    }

    public void setSeansId(Long seansId) {
        this.seansId = seansId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seans seans = (Seans) o;

        if (time != null ? !time.equals(seans.time) : seans.time != null) return false;
        return movie != null ? movie.equals(seans.movie) : seans.movie == null;

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Seans{" +
                "seansId=" + seansId +
                ", time=" + time +
                ", movie=" + movie.getName() +
                ", tickets=" + tickets +
                '}';
    }
}

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
    private LocalDateTime dateTime;
    @ManyToOne
    private Movie movie;
    @Transient
    private final static short SEATSCOUNT = 100;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seans")
    private List<Place> places = new ArrayList<>(SEATSCOUNT);

    public Long getSeansId() {
        return seansId;
    }

    public void setSeansId(Long seansId) {
        this.seansId = seansId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    /*
    Method do populate Place
     */
    public void initiateTickets(BigDecimal price) {

        //TODO setup rows and seats
        for(int i = 0; i < SEATSCOUNT; i++){

            Place place = new Place();
            place.setPrice(price);
            place.setSeans(this);
            places.add(place);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seans seans = (Seans) o;

        if (dateTime != null ? !dateTime.equals(seans.dateTime) : seans.dateTime != null) return false;
        return movie != null ? movie.equals(seans.movie) : seans.movie == null;

    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Seans{" +
                "seansId=" + seansId +
                ", dateTime=" + dateTime +
                ", movie=" + movie.getName() +
                ", places=" + places +
                '}';
    }
}

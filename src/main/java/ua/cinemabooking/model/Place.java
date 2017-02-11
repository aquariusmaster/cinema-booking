package ua.cinemabooking.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by RATIBOR on 04.02.2017.
 */
@Entity
public class Place {
    @Id @GeneratedValue
    private Long ticketId;
    private Integer row;
    private Integer seat;
    private boolean isAvailable;
    private BigDecimal price;
    @ManyToOne
    private Seans seans;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Place{" +
                "ticketId=" + ticketId +
                ", row=" + row +
                ", seat=" + seat +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}

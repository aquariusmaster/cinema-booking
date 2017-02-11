package ua.cinemabooking.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by RATIBOR on 04.02.2017.
 */
@Entity
public class Ticket {
    @Id @GeneratedValue
    private Long id;
    private Integer row;
    private Integer seat;
    private boolean isBought;
    private BigDecimal price;
    @ManyToOne
    private Seans seans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
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
        return "Ticket{" +
                "id=" + id +
                ", row=" + row +
                ", seat=" + seat +
                ", isBought=" + isBought +
                ", price=" + price +
                '}';
    }
}

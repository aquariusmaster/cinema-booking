package ua.cinemabooking.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RATIBOR on 04.02.2017.
 */
@Entity
public class BillOrder {

    @Id @GeneratedValue
    private Long billOrderId;
    private String email;
    private LocalDateTime dataTime;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Place> places;

    private boolean payed;

    public Long getBillOrderId() {
        return billOrderId;
    }

    public void setBillOrderId(Long billOrderId) {
        this.billOrderId = billOrderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}

package ua.cinemabooking.service;

import ua.cinemabooking.model.BillOrder;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Place;
import ua.cinemabooking.model.Seans;
import ua.cinemabooking.serviceModel.Seats;

import java.util.List;

/**
 * Created by Artem on 04.02.2017.
 */
public interface TiketsService {


    public BillOrder createOrder(String email, List<Place> places);

    public BillOrder afterPay(BillOrder billOrder);

    public List<Movie> movieList();

    public Seats getSeats(Long seansId);

    public  List<Seans> seansList(Long movieId);


}
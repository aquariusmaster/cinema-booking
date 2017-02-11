package ua.cinemabooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cinemabooking.model.BillOrder;
import ua.cinemabooking.model.Movie;
import ua.cinemabooking.model.Place;
import ua.cinemabooking.model.Seans;
import ua.cinemabooking.repository.BillOrderRepository;
import ua.cinemabooking.repository.MovieRepository;
import ua.cinemabooking.repository.SeansRepository;
import ua.cinemabooking.serviceModel.Seats;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 04.02.2017.
 */
@Service
public class TiketsServiceImpl implements  TiketsService {
    @Autowired
    SeansRepository seansRepository;
    @Autowired
    BillOrderRepository billOrderRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public BillOrder createOrder(String email, List<Place> places) {
        BillOrder billOrder = new BillOrder();
        billOrder.setEmail(email);
        billOrder.setPayed(false);
        billOrderRepository.save(billOrder);
        return billOrder;
    }

    @Override
    public BillOrder afterPay(BillOrder billOrder) {
        BillOrder billOrder1;
        billOrder1 = billOrder;
        billOrder1.setPayed(true);
        billOrderRepository.save(billOrder1);
        return billOrder1;
    }

    @Override
    public List<Movie> movieList() {
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        return movieList;
    }

    @Override
    public Seats getSeats(Long seansId) {
        Seans seans = seansRepository.findOne(seansId);
        List<BillOrder> orderList = billOrderRepository.findBySeans(seans);
        List<Boolean> freeseats = new ArrayList<>();
//        for (int x = 0; x <10; x++) {
//            for (int y = 0; y <10 ; y++) {
//                Boolean resalt = true;
//                for (BillOrder order: orderList
//                        ) {
//                    if (order.getPlaces().getRow()==x && order.getPlaces().getSeat()==y && order.isPayed())
//                        resalt = false;
//                }
//                freeseats.add(resalt);
//
//            }
//        }
        Seats seats1= new Seats();
        seats1.setMap(freeseats);
//        seats1.setPrice(seans.getMovie().getPrice());
        seats1.setFilmDate(seans.getDateTime());
        seats1.setFilmName(seans.getMovie().getName());
        return seats1;
    }

    @Override
    public List<Seans> seansList(Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        List<Seans> seansList = seansRepository.findByMovie(movie);
        return seansList;
    }

}

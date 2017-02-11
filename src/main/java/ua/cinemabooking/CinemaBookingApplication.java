package ua.cinemabooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ua.cinemabooking")
public class CinemaBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBookingApplication.class, args);
	}


}

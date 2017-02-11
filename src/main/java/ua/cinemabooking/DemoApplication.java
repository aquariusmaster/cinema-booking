package ua.cinemabooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.cinemabooking.service.Populator;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "ua.cinemabooking")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}

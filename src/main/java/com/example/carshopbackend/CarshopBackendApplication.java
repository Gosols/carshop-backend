package com.example.carshopbackend;

import com.example.carshopbackend.domain.Brand;
import com.example.carshopbackend.domain.BrandRepo;
import com.example.carshopbackend.domain.Car;
import com.example.carshopbackend.domain.CarRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarshopBackendApplication {
    private static final Logger log = LoggerFactory.getLogger(CarshopBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarshopBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner CarshopCLR(CarRepo crepo, BrandRepo brepo) {
        return (args) -> {

            brepo.save(new Brand("Mercedes Benz"));
            brepo.save(new Brand("BMW"));
            brepo.save(new Brand("Ford"));
            brepo.save(new Brand("Audi"));

            crepo.save(new Car(brepo.findByBrandName("Ford"), "Mondeo", 2018, 30000));
            crepo.save(new Car(brepo.findByBrandName("BMW"), "500", 2019, 60000));
            crepo.save(new Car(brepo.findByBrandName("Audi"), "A7", 2020, 100000));



        };
    }
}

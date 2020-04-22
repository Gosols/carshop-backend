package com.example.carshopbackend;

import com.example.carshopbackend.domain.*;
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
    public CommandLineRunner CarshopCLR(CarRepo crepo, BrandRepo brepo, UserRepository urepo) {
        return (args) -> {

            urepo.save(new User("user"
                    ,
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
            urepo.save(new User("admin"
                    ,
                    "$2y$12$VFD6dmaRBB5gnw9Gb7pJ8OBuBRFCvd8f82sVa0va7y5G6wL76Zade", "ADMIN"));

            brepo.save(new Brand("Mercedes Benz"));
            brepo.save(new Brand("BMW"));
            brepo.save(new Brand("Ford"));
            brepo.save(new Brand("Audi"));
            brepo.save(new Brand("Opel"));
            brepo.save(new Brand("Porsche"));
            brepo.save(new Brand("Volkswagen"));


            crepo.save(new Car(brepo.findByBrandName("Ford"), "Mondeo", "Gasoline", 2018, 30000));
            crepo.save(new Car(brepo.findByBrandName("BMW"), "500", "Diesel", 2019, 60000));
            crepo.save(new Car(brepo.findByBrandName("Audi"), "A7", "Diesel", 2020, 100000));
            crepo.save(new Car(brepo.findByBrandName("Audi"), "A8", "Diesel", 2020, 120000));
            crepo.save(new Car(brepo.findByBrandName("Opel"), "Insignia", "Gasoline", 2018, 50000));
            crepo.save(new Car(brepo.findByBrandName("Porsche"), "Panamera", "Diesel", 2020, 200000));


        };
    }
}

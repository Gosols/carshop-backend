package com.example.carshopbackend.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepo extends CrudRepository <Car, Long> {
    Optional<Car> findById(Long Id);
}

package com.example.carshopbackend.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository <Car, Long> {
}

package com.example.carshopbackend.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Long> {
    Brand findByBrandName(String brandName);
}

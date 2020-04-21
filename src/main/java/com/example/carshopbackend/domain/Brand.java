package com.example.carshopbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brandName;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Car> cars;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setBooks(List<Car> cars) {
        this.cars = cars;
    }
}

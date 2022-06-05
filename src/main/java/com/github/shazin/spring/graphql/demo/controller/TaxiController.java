package com.github.shazin.spring.graphql.demo.controller;

import com.github.shazin.spring.graphql.demo.entities.Taxi;
import com.github.shazin.spring.graphql.demo.repo.TaxiRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TaxiController {

    private final TaxiRepository taxiRepository;

    public TaxiController(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    @SchemaMapping(typeName = "Query", field = "allTaxis")
    public List<Taxi> findAll() {
        return taxiRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", field = "findOne")
    public Taxi findOne(@Argument String id) {
        return taxiRepository.findOne(id);
    }

    @SchemaMapping(typeName = "Query", field = "searchTaxis")
    public List<Taxi> searchTaxis(@Argument Float lat, @Argument Float lon) {
        System.out.println(lat + ", " + lon);
        return taxiRepository.findAll();
    }

}

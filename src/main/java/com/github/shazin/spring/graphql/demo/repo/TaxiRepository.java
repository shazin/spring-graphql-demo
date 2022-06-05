package com.github.shazin.spring.graphql.demo.repo;

import com.github.shazin.spring.graphql.demo.entities.Driver;
import com.github.shazin.spring.graphql.demo.entities.Taxi;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxiRepository {

    private final List<Taxi> taxis = new ArrayList<>();

    public List<Taxi> findAll() {
        return taxis;
    }

    public Taxi findOne(String id) {
        return findAll().stream().filter(t -> t.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Taxi with id "+id+" not found"));
    }

    @PostConstruct
    public void init() {
        taxis.add(new Taxi("1", "CAL-1332", "Suzuki", "WagonR", 4, new Driver("1", "Shazin", "Sadakath", 5)));

    }
}

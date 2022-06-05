package com.github.shazin.spring.graphql.demo.entities;

public record Taxi(String id, String number, String make, String model, int seats, Driver driver) {
}

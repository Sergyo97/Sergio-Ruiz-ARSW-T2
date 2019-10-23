package edu.eci.arsw.airports.persistence.repository;

import java.io.IOException;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * AirportRepository
 */
public interface AirportRepository {

    public String getInfoAirport(String city) throws UnirestException;
    
}
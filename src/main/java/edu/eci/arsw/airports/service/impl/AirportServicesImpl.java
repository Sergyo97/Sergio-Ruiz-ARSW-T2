package edu.eci.arsw.airports.service.impl;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.airports.persistence.repository.AirportRepository;
import edu.eci.arsw.airports.service.AiportServices;

/**
 * AirportServicesImpl
 */
@Service
public class AirportServicesImpl implements AiportServices {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public String getHttpConnection(String city) {
        try {
            return airportRepository.getInfoAirport(city);
        } catch (UnirestException e) {
            e.printStackTrace();
            return "Error searching that city" + city;
        }
    }

}
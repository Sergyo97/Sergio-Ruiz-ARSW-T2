package edu.eci.arsw.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.airports.service.AiportServices;

/**
 * AirportController
 */
@RestController
@RequestMapping("airport")
public class AirportController {

    @Autowired
    AiportServices aiportServices;

    @GetMapping("/{city}")
    public ResponseEntity<?> getAllLibraries(@PathVariable String city) {
        try {
            return new ResponseEntity<>(aiportServices.getHttpConnection(city), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error, no cinemas were found", HttpStatus.NOT_FOUND);
        }
    }
}

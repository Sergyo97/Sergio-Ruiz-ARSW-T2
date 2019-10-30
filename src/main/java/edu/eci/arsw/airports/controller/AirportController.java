package edu.eci.arsw.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.airports.service.AiportServices;

/**
 * AirportController
 */
@RestController

public class AirportController {

    @Autowired
    AiportServices aiportServices;

    @RequestMapping("/airport")
    public ResponseEntity<?> getAllLibraries(@RequestParam String city) {
        try {
            return new ResponseEntity<>(aiportServices.getHttpConnection(city), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error, no airports were found", HttpStatus.NOT_FOUND);
        }
    }
}

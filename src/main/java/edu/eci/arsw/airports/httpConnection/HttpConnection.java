package edu.eci.arsw.airports.httpConnection;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Component;

/**
 * HttpConnection
 */
@Component
public class HttpConnection {

    public String getHttpConnection(String city) throws UnirestException {

        return Unirest
                .get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + city)
                .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "263297421fmshd9a9ca080274e11p163de6jsnd448cee535e6").asString().getBody();

        
    }
}
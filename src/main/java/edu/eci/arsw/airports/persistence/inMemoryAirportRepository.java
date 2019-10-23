package edu.eci.arsw.airports.persistence;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.airports.httpConnection.HttpConnection;
import edu.eci.arsw.airports.persistence.repository.AirportRepository;

/**
 * inMemoryAirportRepository
 */
@Component
public class inMemoryAirportRepository implements AirportRepository {

    @Autowired
    HttpConnection connection;

    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Long> mapTime = new ConcurrentHashMap<>();

    @Override
    public String getInfoAirport(String city) throws UnirestException {
        long fiveMinutes = 1000000000 * 5;
		if(mapTime.contains(city)) {
			long time = System.nanoTime() - mapTime.get(city);
			if(time > fiveMinutes) {
				String newInfo = connection.getHttpConnection(city);
				Long  newTime = System.nanoTime();
				map.replace(city, newInfo);
				mapTime.replace(city, newTime);
				return newInfo;
			}else {
				return map.get(city);
			}
		}else {
			String newInfo = connection.getHttpConnection(city);
			Long  newTime = System.nanoTime();
			map.put(city, newInfo);
			mapTime.put(city, newTime);
			return newInfo;
		}
    }
}
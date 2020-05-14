package com.location.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.location.domain.Location;
import com.location.exception.LocationApiException;
import com.location.repository.LocationRepository;

@Service
public class LocationService {


  @Autowired
  LocationRepository repository;


  public Location createLocation(Location location) throws LocationApiException  {
    
    try {
      return repository.save(location);  
    }
    catch(Exception e){
      
      throw new LocationApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "save failed");
      
    }
    
  }

  public List<Location> getLocation(String duration) {

    Date givenDuration = null;
    LocalDateTime localDateTime = null;

    if (duration.toUpperCase().endsWith("M")) {

      String minutes = duration.toUpperCase().replace("M", "");

      localDateTime = LocalDateTime.now().minusMinutes(Long.parseLong(minutes));

    } else if (duration.toUpperCase().endsWith("H")) {
      String hours = duration.toUpperCase().replace("H", "");

      localDateTime = LocalDateTime.now().minusHours(Long.parseLong(hours));
    } else {

      throw new  InputMismatchException();
    }

      givenDuration = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
      
    
    return repository.findByupdatedTimeBetween(givenDuration,new Date());
  }
}

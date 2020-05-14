package com.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.location.domain.Location;
import com.location.repository.LocationRepository;

@Service
public class LocationService {

  
  @Autowired
  LocationRepository repository;
  
  
  public Location createLocation(Location location) {
    
    return repository.save(location);
  }
}

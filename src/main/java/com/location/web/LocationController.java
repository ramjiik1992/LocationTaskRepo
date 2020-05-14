package com.location.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.location.domain.Location;
import com.location.service.LocationService;

@RestController("api/v1")
public class LocationController {
  
  @Autowired
  private LocationService service;

  
  @PostMapping("/location")
  public ResponseEntity<Location> createLocationDetails(@RequestBody Location  location){
    
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createLocation(location));
    
  }
}

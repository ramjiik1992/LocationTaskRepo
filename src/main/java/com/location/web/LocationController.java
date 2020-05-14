package com.location.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.location.domain.Location;

@RestController("api/v1")
public class LocationController {

  
  @PostMapping("/location")
  public ResponseEntity<Location> createLocationDetails(@RequestBody Location  locationData){
    return null;
    
  }
}

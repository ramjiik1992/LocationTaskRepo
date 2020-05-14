package com.location.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.location.domain.Location;
import com.location.exception.LocationApiException;
import com.location.service.LocationService;

@RestController
@RequestMapping(path="api/v1")
public class LocationController {
  
  @Autowired
  private LocationService service;

  
  @PostMapping("/location")
  public ResponseEntity<Location> createLocationDetails(@RequestBody Location  location) throws LocationApiException{
    
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createLocation(location));
    
  }
  
  @GetMapping("/location")
  public ResponseEntity<List<Location>> getLocationDetails(@RequestParam String duration){
    
    return ResponseEntity.status(HttpStatus.OK).body(service.getLocation(duration));
    
  }
}

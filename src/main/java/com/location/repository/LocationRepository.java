package com.location.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.location.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

  List<Location> findByupdatedTimeBetween(Date givenTimeStamp,Date currentTimeStamp);
  
}

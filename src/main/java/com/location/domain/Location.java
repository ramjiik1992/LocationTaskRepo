package com.location.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String latitude;
  
  private String longitude;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date timeStamp;
  
  
  
}

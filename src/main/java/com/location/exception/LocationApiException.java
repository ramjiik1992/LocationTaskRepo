package com.location.exception;

public class LocationApiException extends Exception {

  private static final long serialVersionUID = 1L;
  public final int statusCode;

  public LocationApiException(int value, String message) {
    super(message);
    this.statusCode = value;
  }


}

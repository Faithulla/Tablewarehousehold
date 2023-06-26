package org.example.exception;

public class InvalidParameterArgumentsException extends RuntimeException {

  public InvalidParameterArgumentsException(String message) {
    super(message);
  }

  public InvalidParameterArgumentsException(String message, Throwable cause) {
    super(message, cause);
  }
}

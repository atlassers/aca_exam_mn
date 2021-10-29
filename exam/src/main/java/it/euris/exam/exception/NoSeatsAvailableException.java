package it.euris.exam.exception;

public class NoSeatsAvailableException extends RuntimeException {

  private static final long serialVersionUID = 1l;

  public NoSeatsAvailableException() {
    super("There are not seats available for this projection!");
   }

  public NoSeatsAvailableException(String message) {
    super(message);
  }

}

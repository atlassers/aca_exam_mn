package it.euris.exam.exception;

public class UnderAgeException extends RuntimeException {

  private static final long serialVersionUID = 1l;

  public UnderAgeException() {
    super("The customer cannot attend the projection of this movie because he is underage");
   }

  public UnderAgeException(String message) {
    super(message);
  }

}

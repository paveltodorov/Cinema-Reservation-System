package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class InvalidSeatException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidSeatException() {
		super();
	}

	public InvalidSeatException(String message) {
		super(message);
	}
}

package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class ExpiredProjectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public ExpiredProjectionException() {
		super();
	}

	public ExpiredProjectionException(String message) {
		super(message);
	}
}

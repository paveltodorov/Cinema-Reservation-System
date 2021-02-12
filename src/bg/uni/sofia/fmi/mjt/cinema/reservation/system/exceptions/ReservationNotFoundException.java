package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class ReservationNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ReservationNotFoundException() {
		super();
	}

	public ReservationNotFoundException(String message) {
		super(message);
	}
}

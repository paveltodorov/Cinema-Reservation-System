package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class AlreadyReservedException extends Exception {
	private static final long serialVersionUID = 1L;

	public AlreadyReservedException() {
		super();
	}

	public AlreadyReservedException(String message) {
		super(message);
	}
}

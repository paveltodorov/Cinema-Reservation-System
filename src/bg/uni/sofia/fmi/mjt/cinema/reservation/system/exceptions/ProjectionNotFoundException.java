package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class ProjectionNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProjectionNotFoundException() {
		super();
	}

	public ProjectionNotFoundException(String message) {
		super(message);
	}
}

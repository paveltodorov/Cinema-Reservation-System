package bg.uni.sofia.fmi.mjt.cinema.reservation.system;

import java.util.Collection;
import java.util.Collections;

import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Movie;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Projection;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Ticket;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.AlreadyReservedException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ExpiredProjectionException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.InvalidSeatException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ProjectionNotFoundException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ReservationNotFoundException;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CinemaCity implements CinemaReservationSystem {
	private Map<Movie, List<Projection>> cinemaProgram;
	private List<Ticket> tickets;

	public CinemaCity(Map<Movie, List<Projection>> cinemaProgram) {
		this.cinemaProgram = cinemaProgram;
		tickets = new ArrayList<>();
	}

	@Override
	public void bookTicket(Ticket ticket) throws AlreadyReservedException, ProjectionNotFoundException,
			InvalidSeatException, ExpiredProjectionException {
		Projection projection = ticket.getProjection();
		if (!containsProjection(projection)) {
			throw new ProjectionNotFoundException();
		}
		boolean expired = projection.getDate().isBefore(LocalDateTime.now());
		if (expired) {
			throw new ExpiredProjectionException();
		}
		projection.reserveSeat(ticket.getSeat());
		tickets.add(ticket);
	}

	public void cancelTicket(Ticket ticket) throws ReservationNotFoundException, ProjectionNotFoundException {
		Projection projection = ticket.getProjection();
		if (!containsProjection(projection)) {
			throw new ProjectionNotFoundException();
		}
		if (tickets.contains(ticket)) {
			tickets.remove(ticket);
			projection.cancelSeatReservation(ticket.getSeat());
		} else {
			throw new ReservationNotFoundException();
		}
	}

	public int getFreeSeats(Projection projection) throws ProjectionNotFoundException {
		if (!containsProjection(projection)) {
			throw new ProjectionNotFoundException();
		}
		return projection.getFreeSeats();
	}

	public Collection<Movie> getSortedMoviesByGenre() {
		List<Movie> movies = new ArrayList<>();
		movies.addAll(cinemaProgram.keySet());
		Collections.sort(movies);
		return movies;
	}

	public boolean containsProjection(Projection projection) {
		List<Projection> projectionList = cinemaProgram.get(projection.getMovie());
		if (projectionList == null) {
			return false;
		}
		int projectionIndex = projectionList.indexOf(projection);
		if (projectionIndex == -1) {
			return false;
		}
		return true;
	}
}

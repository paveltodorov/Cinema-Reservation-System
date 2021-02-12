package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

//import java.lang.reflect.Array;
import java.time.LocalDateTime;

import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.AlreadyReservedException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.InvalidSeatException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ReservationNotFoundException;

public class Projection {
	private Movie movie;
	private Hall hall;
	private LocalDateTime date;
	private int freeSeats;
	private boolean[][] seatsArray;

	public Projection(Movie movie, Hall hall, LocalDateTime date) {
		this.movie = movie;
		this.hall = hall;
		this.date = date;
		this.freeSeats = (hall.getRows() * hall.getRowSeats());
		seatsArray = new boolean[hall.getRows()][hall.getRowSeats()];
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projection other = (Projection) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hall == null) {
			if (other.hall != null)
				return false;
		} else if (!hall.equals(other.hall))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}

	public int getFreeSeats() {
		return freeSeats;
	}

	public void reserveSeat(Seat seat) throws InvalidSeatException, AlreadyReservedException {
		int row = seat.getRow();
		int column = seat.getSeat();
		row = row - 1;
		column = column - 1;
		if (row < 0 || column < 0 || row >= hall.getRows() || column >= hall.getRowSeats()) {
			throw new InvalidSeatException();
		}
		if (seatsArray[row][column] == true) {
			throw new AlreadyReservedException();
		}
		seatsArray[row][column] = true;
		this.freeSeats -= 1;
	}

	public void cancelSeatReservation(Seat seat) throws ReservationNotFoundException {
		int row = seat.getRow();
		int column = seat.getSeat();
		if (row < 0 || column < 0 || row >= hall.getRows() || column >= hall.getRowSeats()) {
			return;
		}
		row = row - 1;
		column = column - 1;
		if (seatsArray[row][column]) {
			seatsArray[row][column] = false;
			this.freeSeats += 1;
		} else {
			throw new ReservationNotFoundException();
		}
	}
}

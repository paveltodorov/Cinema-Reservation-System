package bg.uni.sofia.fmi.mjt.cinema.reservation.system;

import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Hall;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Movie;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.MovieGenre;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Projection;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Seat;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		//CinemaReservationCity city = new CinemaReservationCity
		Hall hall1 = new Hall(1,5,5);
        Seat seat = new Seat(1,1);
        Movie m1 = new Movie("m1", 5, MovieGenre.ACTION);
        //LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);    
        //Projection p =  new Projection( m1,hall1, now  );
	}

}

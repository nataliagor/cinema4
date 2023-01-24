package seancesManagement;

import java.util.ArrayList;
import java.util.Date;

public class CinemaRecourses implements IManageCinemaRecourses {
    private java.util.ArrayList<ScreeningRoom> screeningRoomsList = new ArrayList<>();
    private java.util.ArrayList<Movie> moviesList = new ArrayList<>();
    private int newMovieId = 1;
    private int newScreeningRoomId = 1;

    @Override
    public boolean addNewMovie(String title, int lengthInMinutes, String distributor, java.util.Date borrowDate,
                               java.util.Date returnDate, boolean hasLector, boolean hasDubbing, boolean is3D) {
        Movie movie = new Movie(newMovieId++, title, lengthInMinutes, distributor, borrowDate, returnDate, hasLector, hasDubbing, is3D);
        moviesList.add(movie);
        return true;
    }

    @Override
    public boolean addNewScreeningRoom(int amountOfRows, int amountOfColumns) {
        ScreeningRoom screeningRoom = new ScreeningRoom(newScreeningRoomId++, amountOfRows, amountOfColumns);
        screeningRoomsList.add(screeningRoom);
        return true;
    }

    @Override
    public ArrayList<ScreeningRoom> getScreeningRoomsList() {
        return screeningRoomsList;
    }

    @Override
    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    @Override
    public ScreeningRoom findScreeningRoom(int screeningRoomId) {
        for (ScreeningRoom screeningRoom : screeningRoomsList) {
            if (screeningRoom.getScreeningRoomId() == screeningRoomId) return screeningRoom;
        }
        return null;
    }

    @Override
    public Movie findMovie(int movieId) {
        for (Movie movie : moviesList) {
            if(movie.getMovieId() == movieId) return movie;
        }
        return null;
    }
}

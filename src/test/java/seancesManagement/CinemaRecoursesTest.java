package seancesManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class CinemaRecoursesTest {

    Dane dane;
    @BeforeEach
    void prepareData(){
        dane = new Dane();
    }

    //DODAWANIE FILMU
    @Test
    void addNewMovie_correctParameters_True() {
        Assertions.assertTrue(dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
               dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D));
    }

    @Test
    void addNewMovie_correctParameters_title() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        Assertions.assertEquals(dane.title, dane.cinemaRecourses.getMoviesList().get(0).getTitle());
    }

    @Test
    void addNewMovie_correctParameters_lengthInMinutes() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        Assertions.assertEquals(dane.lengthInMinutes, dane.cinemaRecourses.getMoviesList().get(0).getLengthInMinutes());
    }

    //DODAWANIE SALI
    @Test
    void addNewScreeningRoom_correctParameters_ture() {
        Assertions.assertTrue(dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns));
    }

    @Test
    void addNewScreeningRoom_correctParameters_amountOfSeats() {
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        Assertions.assertEquals(dane.amountOfSeats, dane.cinemaRecourses.getScreeningRoomsList().get(0).getAmountOfSeats());
    }

    //SZYKANIE SALI PO ID
    @Test
    void findScreeningRoom_correctId_ScreeningRoom() {
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        Assertions.assertEquals(dane.cinemaRecourses.getScreeningRoomsList().get(2), dane.cinemaRecourses.findScreeningRoom(3));
    }

    @Test
    void findScreeningRoom_wrongId_Null() {
        Assertions.assertEquals(null, dane.cinemaRecourses.findScreeningRoom(1));
    }

    //SZUKANIE FILMU PO ID
    @Test
    void findMovie_correctId_Movie() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        Assertions.assertEquals(dane.cinemaRecourses.getMoviesList().get(0), dane.cinemaRecourses.findMovie(1));
    }

    void findMovie_wrongId_Null() {
        Movie movie = Mockito.mock(Movie.class);
        Assertions.assertEquals(movie, dane.cinemaRecourses.findMovie(1));
    }
}
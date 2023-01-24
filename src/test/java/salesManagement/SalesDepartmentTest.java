package salesManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import seancesManagement.Movie;
import seancesManagement.Seance;
import usersManagement.Customer;
import usersManagement.User;

import static org.junit.jupiter.api.Assertions.*;

class SalesDepartmentTest {

    Dane dane;
    @BeforeEach
    void prepareData(){
        dane = new Dane();
    }

    //KUPOWANIE BILETU
    @Test
    void buyTickets_CorrectParameters_True() { //FreeSeats UserLogged SeancesExists
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t2);
        dane.seatsList.add(dane.t3);

        Assertions.assertTrue(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 3,
                1,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_notExistingSeance_False() { //FreeSeats UserLogged SeancesExists
        Seance seance = Mockito.mock(Seance.class);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t2);
        dane.seatsList.add(dane.t3);

        Assertions.assertFalse(dane.salesDepartment.buyTickets(seance, 3,
                1,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_SameSeats_False() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t3);

        Assertions.assertFalse(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 3,
                1,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_TakenSeat_False() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        dane.salesDepartment.buyTickets(dane.program.findSeance(1), 1,
                0,dane.usersData.findCustomer(1), dane.seatsList);

        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t3);

        Assertions.assertFalse(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 3,
                1,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_WrongSeatsAmount_False() {
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        Assertions.assertFalse(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 3,
                1,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_NotExistingSeance_False() {
        Seance seance = Mockito.mock(Seance.class);
        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);
        dane.seatsList.add(dane.t);

        Assertions.assertFalse(dane.salesDepartment.buyTickets(seance, 1,
                0,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_CustomerNotLoggedIn_True() { //FreeSeats UserLogged SeancesExists
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);

        dane.seatsList.add(dane.t);

        Assertions.assertTrue(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 1,
                0,dane.usersData.findCustomer(1), dane.seatsList));
    }

    @Test
    void buyTickets_EmployeeLoggedNotCustomer_True() { //FreeSeats UserLogged SeancesExists
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);

        Assertions.assertTrue(dane.salesDepartment.buyTickets(dane.program.findSeance(1), 1,
                0,dane.usersData.findEmployee(1), dane.seatsList));
    }


    //REZERWACJA BILETU
    @Test
    void bookTickets_CorrectParameters_True() { //FreeSeats UserLogged SeancesExists
        dane.cinemaRecourses.addNewMovie(dane.title, dane.lengthInMinutes, dane.distributor, dane.borrowDate,
                dane.returnDate, dane.hasLector, dane.hasDubbing, dane.is3D);
        dane.cinemaRecourses.addNewScreeningRoom(dane.amountOfRows, dane.amountOfColumns);
        dane.program.createNewSeance(dane.cinemaRecourses, 1, dane.ticketPrice, 1, dane.startTime,
                dane.endTime, dane.percentDiscount);

        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        dane.usersData.logIn(dane.login,dane.password);

        dane.seatsList.add(dane.t);
        dane.seatsList.add(dane.t2);
        dane.seatsList.add(dane.t3);

        Assertions.assertTrue(dane.salesDepartment.bookTickets(dane.program.findSeance(1),3,
                1, dane.usersData.findCustomer(1),  dane.seatsList));
    }

    @Test
    void cancelReservation() {
    }

    @Test
    void sellTickets() {
    }
}
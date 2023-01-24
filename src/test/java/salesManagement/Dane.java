package salesManagement;

import seancesManagement.CinemaRecourses;
import seancesManagement.Movie;
import seancesManagement.Program;
import usersManagement.UsersData;

import java.util.ArrayList;
import java.util.Date;

public class Dane {

    SalesDepartment salesDepartment = new SalesDepartment();
    CinemaRecourses cinemaRecourses = new CinemaRecourses();
    Program program = new Program();
    UsersData usersData = new UsersData();

    //dane do biletow
    java.util.ArrayList<Ticket> seatsList = new ArrayList<>();
    Ticket t = new Ticket(3,4);
    Ticket t2 = new Ticket(3,3);
    Ticket t3 = new Ticket(3,3);


    //dane do tworzenia filmu
    String title = "title1";
    int lengthInMinutes = 140;
    String distributor = "distributor1";
    Date borrowDate = new Date(1,2,2022);
    Date returnDate = new Date(2,5,2022);
    boolean hasLector = true;
    boolean hasDubbing = false;
    boolean is3D = false;

    //dane do tworzenia sali
    int amountOfRows = 20;
    int amountOfColumns = 10;
    int amountOfSeats = amountOfRows*amountOfColumns;

    //dane do tworzenia senasów
    double ticketPrice = 25.50;
    Date startTime =new Date(9,2,2022, 10,50);
    Date endTime =new Date(9,2,2022, 12,20);
    double percentDiscount = 0.30;

    //dane do logowania, tworzenia klienta, zatrudniania i zwalniania pracownika
    String login = "login1";
    String password = "password1";
    String name = "name1";
    String surname = "surname1";
    String phoneNumber = "234234234";
    Date hireDate = new Date(2,4,2020);
    Date fireDate = new Date(2,4,2020);

    //parametry pozycji
    String positionName = "positionName1";
    double salary = 5300.00;

}

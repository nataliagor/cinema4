import salesManagement.*;
import seancesManagement.*;
import usersManagement.*;

import java.util.ArrayList;
import java.util.Date;
import fitnesse.fixtures.ColumnFixtureTestFixture;
import fit.ColumnFixture;

public class Application extends ColumnFixtureTestFixture{
    private User currentUser;
    private IManageCinemaRecourses cinemaRecourses = new CinemaRecourses();
    private IManageProgram program = new Program();
    private IManageSales salesDepartment = new SalesDepartment();
    private IManageUsersData usersData = new UsersData();

    public User getCurrentUser() {return currentUser;}
    public IManageCinemaRecourses getCinemaRecourses() {return cinemaRecourses;}
    public IManageProgram getProgram() {return program;}
    public IManageSales getSalesDepartment() {return salesDepartment;}
    public IManageUsersData getUsersData() {return usersData;}

    public String title, distributor;
    public int lengthInMinutes, day1, month1, year1, day2, month2, year2;
    public java.util.Date borrowDate, returnDate;
    public boolean hasLector, hasDubbing, is3D;

    public static void main(String[] args) {
        Application app = new Application();
    }

    public void logIn(String login, String password){
        currentUser = usersData.logIn(login, password);
    }

    public void checkSeancesList(java.util.Date chosenDate){
        java.util.ArrayList<Seance> seancesList = program.checkSeancesList(chosenDate);
        if(seancesList.isEmpty())
            printMessage("Nie ma seansow na podany dzien");
        else
            printSeancesList(seancesList);
    }

    public void buyTickets(int seanceId, int amountOfTickets, int amountOfReducedTickets, java.util.ArrayList<Ticket> seatsList){
        boolean success = false;
        if(currentUser != null && currentUser.getClass() == Customer.class){
            Seance seance = program.findSeance(seanceId);
            success = salesDepartment.buyTickets(seance, amountOfTickets, amountOfReducedTickets, currentUser, seatsList);}

        if (success)
            printMessage("Zakup udany");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void bookTickets(int seanceId, int amountOfTickets, int amountOfReducedTickets, java.util.ArrayList<Ticket> seatsList){
        boolean success = false;
        if(currentUser != null && currentUser.getClass() == Customer.class){
            Seance seance = program.findSeance(seanceId);
            success = salesDepartment.bookTickets(seance, amountOfTickets, amountOfReducedTickets, currentUser, seatsList);}

        if (success)
            printMessage("Rezerwacja dokonana");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void cancelReservation(int seanceId, int ticketId){
        boolean success = false;
        if(currentUser != null && currentUser.getClass() == Customer.class){
            Seance seance = program.findSeance(seanceId);
            success = salesDepartment.cancelReservation(seance, ticketId, currentUser);}

        if (success)
            printMessage("Rezerwacja anulowana");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void sellTickets(int seanceId, int amountOfTickets, int amountOfReducedTickets, java.util.ArrayList<Ticket> seatsList){
        Seance seance = program.findSeance(seanceId);
        boolean success = false;
        if(currentUser.getClass() == Employee.class){
            success = salesDepartment.sellTickets(seance, amountOfTickets, amountOfReducedTickets, seatsList);}

        if (success)
            printMessage("Zakup udany");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void createSeance(java.util.Date startTime, java.util.Date endTime, int screeningRoomId, int movieId, double ticketPrice, double percentDiscount){
        boolean success = program.createNewSeance(cinemaRecourses, movieId, ticketPrice, screeningRoomId, startTime, endTime, percentDiscount);

        if (success)
            printMessage("Dodano seans");
        else
            printMessage("Niepowodzenie operacji");
    }

    public String addMovie(){
        borrowDate = crateDate(day1, month1, year1);
        returnDate = crateDate(day2, month2, year2);
        boolean success = cinemaRecourses.addNewMovie(title, lengthInMinutes, distributor, borrowDate, returnDate, hasLector, hasDubbing, is3D);
        if (success)
            return ("Dodano seans");
        else
            return ("Niepowodzenie operacji");
    }

    public void addNewScreeningRoom(int amountOfRows, int amountOfColumns){
        boolean success = cinemaRecourses.addNewScreeningRoom(amountOfRows, amountOfColumns);
        if (success)
            printMessage("Dodano sale");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void hireEmployee(java.util.Date hireDate, String login, String password, String name, String surname,
                            String phoneNumber, int positionId){
        boolean success = usersData.hireEmployee(hireDate, login, password, name, surname, phoneNumber, positionId);
        if (success)
            printMessage("Dodano pracownika");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void fireEmployee(int employeeId, java.util.Date fireDate){
        boolean success = usersData.fireEmployee(employeeId, fireDate);
        if (success)
            printMessage("Zwolniono pracownika");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void modifyEmployeeData(int employeeId, String name, String surname, String phoneNumber, int positionId){
        boolean success = usersData.modifyEmployeeData(employeeId, name, surname, phoneNumber, positionId);
        if (success)
                printMessage("Zaktualizowano dane pracownika");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void addNewPositions(String positionName, double salary){
        boolean success = usersData.addNewPositions(positionName, salary);
        if (success)
            printMessage("Dodano pozycje");
        else
            printMessage("Niepowodzenie operacji");
    }


    public void modifyPositions(int positionId, String positionName, int salary){
        boolean success = usersData.modifyPositions(positionId, positionName, salary);
        if (success)
            printMessage("Zmodyfikowano pozycję");
        else
            printMessage("Niepowodzenie operacji");
    }

    public void addNewCustomer(String login, String password, String name, String surname, String phoneNumber){
        boolean success = usersData.addNewCustomer(login, password, name, surname, phoneNumber);
        if (success)
            printMessage("Dodano klienta");
        else
            printMessage("Niepowodzenie operacji");
    }

    private void printMessage(String message){
        System.out.println(message);
    }

    private void printSeancesList(java.util.ArrayList<Seance> seancesList){
        System.out.println("Tytul filmu, czas rozpoczecia, cena bieltu, sala");
        for(Seance seance : seancesList){
            System.out.println(seance.getMovie().getTitle() + ", " +
                    seance.getStartTime().getDate() + "." + seance.getStartTime().getMonth() + "." + seance.getStartTime().getYear() + " " +
                    seance.getStartTime().getHours() + ":" + seance.getStartTime().getMinutes()
                    + ", " + seance.getTicketPrice() + ", " + seance.getScreeningRoom().getScreeningRoomId());
        }
    }

    public java.util.Date crateDate(int day, int month, int year){
        java.util.Date date = new Date(year, month, day);
        return date;
    }

    public java.util.Date crateDateWithTime(int day, int month, int year, int hour, int minutes){
        java.util.Date date = new Date(year, month, day, hour, minutes);
        return date;
    }
}

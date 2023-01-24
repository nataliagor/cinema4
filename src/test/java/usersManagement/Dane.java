package usersManagement;

import salesManagement.SalesDepartment;
import seancesManagement.CinemaRecourses;
import seancesManagement.Program;

import java.util.Date;

public class Dane {

    UsersData usersData = new UsersData();

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

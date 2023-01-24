package usersManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UsersDataTest {

    Dane dane;
    @BeforeEach
    void prepareData(){
        dane = new Dane();
    }

    //ZATRUDNIANIE PRACOWNIKA
    @Test
    void hireEmployee_correctParameters_True() {
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        Assertions.assertTrue(dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1));
    }

    @Test
    void hireEmployee_NotExistingPosition_False() {
        Assertions.assertFalse(dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1));
    }

    @Test
    void hireEmployee_ExistingEmployee_False() {
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1);
        Assertions.assertFalse(dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1));
    }

    @Test
    void hireEmployee_TakenLogin_False() {
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.addNewCustomer(dane.login,"password2","name2","surname2","234345456");
        Assertions.assertFalse(dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1));
    }

    //ZWALNIANIE PRACOWNIKA
    @Test
    void fireEmployee_CorrectParameters_True() {
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname, dane.phoneNumber, 1);
        Assertions.assertTrue(dane.usersData.fireEmployee(1,dane.fireDate));
    }

    @Test
    void fireEmployee_NotExistingEmployee_False() {
        Assertions.assertFalse(dane.usersData.fireEmployee(1,dane.fireDate));
    }

    //DODAWANIE NOWEJ POZYCJI
    @Test
    void addNewPositions_CorrectParameters_True() {
        Assertions.assertTrue(dane.usersData.addNewPositions(dane.positionName, dane.salary));
    }


    //DODAWANIE NOWEGO KLIENTA
    @Test
    void addNewCustomer__correctParameters_True() {
        Assertions.assertTrue(dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber));
    }


    @Test
    void addNewCustomer_AddExistingCustomer_False(){
        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        Assertions.assertFalse(dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber));
    }

    @Test
    void addNewCustomer_LoginIsEmpty_False(){
        String wrongLogin = "";
        Assertions.assertFalse(dane.usersData.addNewCustomer(wrongLogin,dane.password,dane.name,dane.surname,dane.phoneNumber));
    }

    @Test
    void addNewCustomer_PasswordIsEmpty_False(){
        String wrongPassword = "";
        Assertions.assertFalse(dane.usersData.addNewCustomer(dane.login, wrongPassword,dane.name,dane.surname,dane.phoneNumber));
    }

    //LOGOWANIE
    @Test
    void logIn_correctParametersLogCustomer_User(){
        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        Assertions.assertEquals(dane.usersData.logIn(dane.login,dane.password),dane.usersData.findCustomer(1));
    }

    @Test
    void logIn_wrongLoginCustomer_Null(){
        String wrongLogin = "login2";
        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        Assertions.assertEquals(null, dane.usersData.logIn(wrongLogin,dane.password));
    }

    @Test
    void logIn_wrongPasswordCustomer_Null(){
        String wrongPassword = "password2";
        dane.usersData.addNewCustomer(dane.login,dane.password,dane.name,dane.surname,dane.phoneNumber);
        Assertions.assertEquals(null, dane.usersData.logIn(dane.login,wrongPassword));
    }

    @Test
    void logIn_correctParametersLogEmployee_User(){
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1);
        Assertions.assertEquals(dane.usersData.logIn(dane.login,dane.password),dane.usersData.findEmployee(1));
    }

    @Test
    void logIn_wrongLoginEmployee_Null(){
        String wrongLogin = "login2";
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1);
        Assertions.assertEquals(null, dane.usersData.logIn(wrongLogin,dane.password));
    }

    @Test
    void logIn_wrongPasswordEmployee_Null(){
        String wrongPassword = "password2";
        dane.usersData.addNewPositions(dane.positionName, dane.salary);
        dane.usersData.hireEmployee(dane.hireDate, dane.login,dane.password,dane.name,dane.surname,
                dane.phoneNumber, 1);
        Assertions.assertEquals(null, dane.usersData.logIn(dane.login,wrongPassword));
    }

}
package usersManagement;

import java.util.Date;

public class Employee extends User{
    private int employeeId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private java.util.Date hireDate = null;
    private java.util.Date fireDate;
    private Position position;

    public Employee(int employeeId, String login, String password, String name, String surname, String phoneNumber, Date hireDate, Position position) {
        this.employeeId = employeeId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.position = position;
    }

    public int getId() {return employeeId;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public Date getHireDate() {return hireDate;}
    public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
    public Date getFireDate() {return fireDate;}
    public void setFireDate(Date fireDate) {this.fireDate = fireDate;}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
}

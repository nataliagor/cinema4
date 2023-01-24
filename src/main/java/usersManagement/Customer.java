package usersManagement;

public class Customer extends User{
    private int customerId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;

    public Customer(int customerId, String login, String password, String name, String surname, String phoneNumber) {
        this.customerId = customerId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {return customerId;}
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
}

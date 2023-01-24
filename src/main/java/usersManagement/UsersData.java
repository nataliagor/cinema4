package usersManagement;

import java.util.ArrayList;
import java.util.Date;

public class UsersData implements IManageUsersData{
    private java.util.ArrayList<Employee> employeesList = new ArrayList<>();
    private java.util.ArrayList<Customer> customersList = new ArrayList<>();
    private java.util.ArrayList<Position> positionsList = new ArrayList<>();
    private int newEmployeeId = 1;
    private int newCustomerId = 1;
    private int newPositionId = 1;


    @Override
    public boolean hireEmployee(Date hireDate, String login, String password, String name, String surname, String phoneNumber, int positionId) {
        if(!checkIfLoginAvailable(login)) return false;

        Position position = findPosition(positionId);
        if(position == null) return false;
        Employee newEmployee = new Employee(newEmployeeId++, login, password, name, surname, phoneNumber, hireDate, position);
        employeesList.add(newEmployee);
        return true;
    }

    @Override
    public boolean fireEmployee(int employeeId, Date hireDate) {
        Employee employee = findEmployee(employeeId);
        if(employee == null) return false;
        employee.setFireDate(hireDate);
        return true;

    }

    @Override
    public boolean modifyEmployeeData(int employeeId, String name, String surname, String phoneNumber, int positionId) {
        Employee employee = findEmployee(employeeId);
        if(employee == null) return false;
        Position position = findPosition(positionId);
        if(position == null) return false;

        employee.setName(name);
        employee.setSurname(surname);
        employee.setPhoneNumber(phoneNumber);
        employee.setPosition(position);
        return true;
    }

    @Override
    public boolean addNewPositions(String positionName, double salary) {
        Position position = new Position(newPositionId++, positionName, salary);
        positionsList.add(position);
        return true;
    }

    @Override
    public boolean modifyPositions(int positionId, String positionName, int salary) {
        Position position = findPosition(positionId);
        if(position == null) return false;

        position.setName(positionName);
        position.setSalary(salary);
        return false;
    }

    @Override
    public boolean addNewCustomer(String login, String password, String name, String surname, String phoneNumber) {
        if(login.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty() || phoneNumber.isEmpty()) return false;
        if(!checkIfLoginAvailable(login)) return false;

        Customer newCustomer = new Customer(newCustomerId++, login, password, name, surname, phoneNumber);
        customersList.add(newCustomer);
        return true;
    }

    @Override
    public User logIn(String login, String password) {
        User user = findUserByLogin(login);
        if(user == null) return null;
        if(user.getPassword() == password) return user;
        return null;
    }


    public Customer findCustomer(int customerId) {
        for (Customer customer:customersList) {
            if(customer.getId() == customerId) return customer;}
        return null;
    }

    private Position findPosition(int positionId){
        for(Position position : positionsList){
            if(position.getPositionId() == positionId)
                return position;
        }
        return null;
    }

    private boolean checkIfLoginAvailable(String login){
        for (Employee employee:employeesList) {
            if(employee.getLogin() == login) return false;}

        for (Customer customer:customersList) {
            if(customer.getLogin() == login) return false;}
        return true;
    }

    public Employee findEmployee(int employeeId){
        for (Employee employee : employeesList) {
            if(employee.getId() == employeeId) return employee;}
        return null;
    }

    private User findUserByLogin(String login){
        for (Employee employee:employeesList) {
            if(employee.getLogin() == login) return employee;}

        for (Customer customer:customersList) {
            if(customer.getLogin() == login) return customer;}

        return null;
    }

}

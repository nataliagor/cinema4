package usersManagement;

public class Position {
    private int positionId;
    private String name;
    private double salary;

    protected Position(int positionId, String name, double salary) {
        this.positionId = positionId;
        this.name = name;
        this.salary = salary;
    }

    public int getPositionId() {return positionId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}
}

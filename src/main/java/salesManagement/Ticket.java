package salesManagement;

import seancesManagement.Seance;
import usersManagement.Customer;
import usersManagement.User;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private int rowInRoom;
    private int columnInRoom;
    private boolean isReserved = false;
    private User user;
    private Seance seance;
    private boolean reducedPrice = false;

    public Ticket(Seance seance, int rowInRoom, int columnInRoom) {
        this.seance = seance;
        this.rowInRoom = rowInRoom;
        this.columnInRoom = columnInRoom;
        this.ticketId = rowInRoom * 1000 + columnInRoom;
    }

    public Ticket(int rowInRoom, int columnInRoom) {
        this.rowInRoom = rowInRoom;
        this.columnInRoom = columnInRoom;
        this.ticketId = rowInRoom * 1000 + columnInRoom;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getRowInRoom() {
        return rowInRoom;
    }

    public void setRowInRoom(int rowInRoom) {
        this.rowInRoom = rowInRoom;
    }

    public int getColumnInRoom() {
        return columnInRoom;
    }

    public void setColumnInRoom(int columnInRoom) {
        this.columnInRoom = columnInRoom;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public boolean isReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(boolean reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

}

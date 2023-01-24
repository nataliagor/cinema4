package salesManagement;

import usersManagement.Customer;
import usersManagement.User;

import java.util.ArrayList;

public class Transaction {
    private int transactionId;
    private double amount;
    private User user;
    private java.util.ArrayList<Ticket> ticketsList = new ArrayList<>();

    public Transaction(int transactionId, User user, ArrayList<Ticket> ticketsList) {
        this.transactionId = transactionId;
        this.user = user;
        this.ticketsList = ticketsList;
        calculateAmount(ticketsList);
    }

    public Transaction(int transactionId, ArrayList<Ticket> ticketsList) {
        this.transactionId = transactionId;
        this.ticketsList = ticketsList;
        calculateAmount(ticketsList);
    }

    private void calculateAmount(java.util.ArrayList<Ticket> ticketsList){
        double sum = 0.0;
        for (Ticket ticket : ticketsList) {
            if(ticket.isReducedPrice())
                sum += ticket.getSeance().getTicketPrice()*(1-ticket.getSeance().getPercentDiscount());
            else
                sum += ticket.getSeance().getTicketPrice();
        }
        amount = sum;
    }
}

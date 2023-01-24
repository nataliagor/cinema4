package salesManagement;

import seancesManagement.IManageProgram;
import seancesManagement.Seance;
import usersManagement.Customer;
import usersManagement.User;

import java.util.ArrayList;

public class SalesDepartment implements IManageSales{
    private java.util.ArrayList<Transaction> transactionsList = new ArrayList<>();
    private int newTransactionId;

    @Override
    public boolean buyTickets(Seance seance, int amountOfTickets, int amountOfReducedPriceTickets, User user, java.util.ArrayList<Ticket> seatsList) {
        java.util.ArrayList<Ticket> ticketsList = new ArrayList<>();
        if(amountOfTickets != seatsList.size()) return false;

        for(int i = 0; i < amountOfTickets; i++){
            Ticket ticket = chooseAvailableSeat(seance, seatsList.get(i).getRowInRoom(), seatsList.get(i).getColumnInRoom());
            if(ticket == null) return false;
            ticket.setUser(user);
            if(amountOfReducedPriceTickets !=0 ){
                ticket.setReducedPrice(true);
                amountOfReducedPriceTickets--;}
            ticketsList.add(ticket);
        }

        for (Ticket ticket : ticketsList) {
            seance.deleteFromAvailableTicketsList(ticket);
        }
        Transaction newTransaction = new Transaction(newTransactionId++,user, ticketsList);
        return true;
    }

    @Override
    public boolean bookTickets(Seance seance, int amountOfTickets, int amountOfReducedTickets, User user, java.util.ArrayList<Ticket> seatsList) {
        java.util.ArrayList<Ticket> ticketsList = new ArrayList<>();
        if(amountOfTickets != seatsList.size()) return false;

        for(int i = 0; i < amountOfTickets; i++){
            Ticket ticket = chooseAvailableSeat(seance, seatsList.get(i).getRowInRoom(), seatsList.get(i).getColumnInRoom());
            if(ticket == null) return false;
            ticket.setUser(user);
            ticket.setReserved(true);
            if(amountOfReducedTickets !=0 ){
                ticket.setReducedPrice(true);
                amountOfReducedTickets--;}
            ticketsList.add(ticket);
        }
        return true;
    }

    @Override
    public boolean cancelReservation(Seance seance, int ticketId, User user) {
        for (Ticket ticket : seance.getAvailableTicketsList()) {
            if (ticket.getTicketId() == ticketId && ticket.getUser() == user && ticket.isReserved()) {
                ticket.setUser(null);
                ticket.setReserved(false);
                ticket.setReducedPrice(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sellTickets(Seance seance, int amountOfTickets, int amountOfReducedTickets, java.util.ArrayList<Ticket> seatsList) {
        java.util.ArrayList<Ticket> ticketsList = new ArrayList<>();
        for(int i = 0; i < amountOfTickets; i++){
            Ticket ticket = chooseAvailableSeat(seance, seatsList.get(i).getRowInRoom(), seatsList.get(i).getColumnInRoom());
            if(ticket == null) return false;
            if(amountOfReducedTickets !=0 ){
                ticket.setReducedPrice(true);
                amountOfReducedTickets--;}
            ticketsList.add(ticket);
        }

        for (Ticket ticket : ticketsList) {
            seance.deleteFromAvailableTicketsList(ticket);
        }
        Transaction newTransaction = new Transaction(newTransactionId++, ticketsList);
        return true;
    }

    private Ticket chooseAvailableSeat(Seance seance, int row, int column){
        for(Ticket ticket : seance.getAvailableTicketsList()){
            if(ticket.getRowInRoom() == row && ticket.getColumnInRoom() == column && !ticket.isReserved()) return ticket;
            }
        return null;
    }
}

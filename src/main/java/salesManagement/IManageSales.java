package salesManagement;

import seancesManagement.IManageProgram;
import seancesManagement.Seance;
import usersManagement.Customer;
import usersManagement.User;

public interface IManageSales {

    public boolean buyTickets(Seance seance, int amountOfTickets, int amountOfReducedTickets, User user, java.util.ArrayList<Ticket> seatsList);
    public boolean bookTickets(Seance seance, int amountOfTickets, int amountOfReducedTickets, User user, java.util.ArrayList<Ticket> seatsList);
    public boolean cancelReservation(Seance seance, int ticketId, User user);
    public boolean sellTickets(Seance seance, int amountOfTickets, int amountOfReducedTickets, java.util.ArrayList<Ticket> seatsList);
}

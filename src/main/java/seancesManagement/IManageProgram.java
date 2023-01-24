package seancesManagement;

import salesManagement.Ticket;

import javax.xml.crypto.Data;
import java.util.Date;

public interface IManageProgram {

    public java.util.ArrayList<Seance> checkSeancesList(java.util.Date chosenData);
    public boolean createNewSeance(IManageCinemaRecourses cinemaRecourses, int movieId, double ticketPrice,
                                   int screeningRoomId, java.util.Date startTime, java.util.Date endTime, double percentDiscount);
    public java.util.ArrayList<Seance> getSeancesList();
    public Seance findSeance(int seanceId);
}

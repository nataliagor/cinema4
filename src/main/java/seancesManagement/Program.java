package seancesManagement;

import salesManagement.Ticket;

import java.util.ArrayList;
import java.util.Date;

public class Program implements IManageProgram{
    private java.util.ArrayList<Seance> seancesList = new ArrayList<>();
    private int newSeanceId = 1;

    @Override
    public java.util.ArrayList<Seance> checkSeancesList(java.util.Date chosenDate){
        java.util.ArrayList<Seance> dailySeancesList = new ArrayList<>();
        java.util.Date seanceDate;

        for(Seance seance : seancesList){
            seanceDate = seance.getStartTime();
            if(seanceDate.getDate() == chosenDate.getDate())
                dailySeancesList.add(seance);
        }
        return dailySeancesList;
    }

    @Override
    public boolean createNewSeance(IManageCinemaRecourses cinemaRecourses, int movieId, double ticketPrice, int screeningRoomId, Date startTime, Date endTime, double percentDiscount) {
        ScreeningRoom screeningRoom = cinemaRecourses.findScreeningRoom(screeningRoomId);
        Movie movie = cinemaRecourses.findMovie(movieId);
        if(movie == null || screeningRoom == null || !isScreeningRoomAvailable(startTime, endTime, screeningRoom)) return false;

        Seance newSeance = new Seance(newSeanceId++, startTime, endTime, ticketPrice, screeningRoom, movie, percentDiscount);
        seancesList.add(newSeance);
        return true;
    }

    @Override
    public ArrayList<Seance> getSeancesList() {
        return seancesList;
    }

    @Override
    public Seance findSeance(int seanceId) {
        for (Seance seance : seancesList) {
            if(seance.getSeanceId() == seanceId) return seance;
        }
        return null;
    }

    private boolean isScreeningRoomAvailable(Date startTime, Date endTime, ScreeningRoom screeningRoom){
        for (Seance seance : seancesList) {
            if (seance.getScreeningRoom().equals(screeningRoom) &&
                    !(seance.getEndTime().getTime() < startTime.getTime() || seance.getStartTime().getTime() > endTime.getTime()) ){
                return false;
            }
        }
        return true;
    }


}

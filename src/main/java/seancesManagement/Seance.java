package seancesManagement;

import salesManagement.Ticket;

import java.util.ArrayList;
import java.util.Date;

public class Seance {
    private int seanceId;
    private java.util.Date startTime;
    private java.util.Date endTime;
    private double ticketPrice;
    private double percentDiscount;
    private ScreeningRoom screeningRoom;
    private Movie movie;
    private java.util.ArrayList<Ticket> availableTicketsList;

    protected Seance(int seanceId, Date startTime, Date endTime, double ticketPrice, ScreeningRoom screeningRoom, Movie movie, double percentDiscount) {
        this.seanceId = seanceId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.screeningRoom = screeningRoom;
        this.movie = movie;
        this.percentDiscount = percentDiscount;
        createTicketsList(screeningRoom);
    }

    public double getPercentDiscount() {return percentDiscount;}
    public void setPercentDiscount(double percentDiscount) {this.percentDiscount = percentDiscount;}

    public int getSeanceId() { return seanceId;}
    public void setSeanceId(int seanceId) { this.seanceId = seanceId; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
    public ScreeningRoom getScreeningRoom() { return screeningRoom; }
    public void setScreeningRoom(ScreeningRoom screeningRoom) { this.screeningRoom = screeningRoom; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public ArrayList<Ticket> getAvailableTicketsList() { return availableTicketsList; }
    public void setAvailableTicketsList(ArrayList<Ticket> availableTicketsList) { this.availableTicketsList = availableTicketsList; }

    private void createTicketsList(ScreeningRoom screeningRoom){
        this.availableTicketsList = new ArrayList<>();
        for(int row = 1; row <= screeningRoom.getAmountOfRows(); row++){
            for(int column = 1; column <= screeningRoom.getAmountOfColumns(); column++ ){
                Ticket ticket = new Ticket(this, row, column);
                this.availableTicketsList.add(ticket);
            }
        }
    }

    public void deleteFromAvailableTicketsList(Ticket ticket){
        this.availableTicketsList.remove(ticket);
    }
}

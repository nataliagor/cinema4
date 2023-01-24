package seancesManagement;

import java.util.Date;

public class Movie {
    private int movieId;
    private String title;
    private int lengthInMinutes;
    private String distributor;
    private java.util.Date borrowDate;
    private java.util.Date returnDate;
    private boolean hasLector;
    private boolean hasDubbing;
    private boolean is3D;

    public Movie(int movieId, String title, int lengthInMinutes, String distributor, Date borrowDate, Date returnDate, boolean hasLector, boolean hasDubbing, boolean is3D) {
        this.movieId = movieId;
        this.title = title;
        this.lengthInMinutes = lengthInMinutes;
        this.distributor = distributor;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.hasLector = hasLector;
        this.hasDubbing = hasDubbing;
        this.is3D = is3D;
    }

    public int getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getLengthInMinutes() { return lengthInMinutes; }
    public void setLengthInMinutes(int lengthInMinutes) { this.lengthInMinutes = lengthInMinutes; }
    public String getDistributor() { return distributor; }
    public void setDistributor(String distributor) { this.distributor = distributor; }
    public Date getBorrowDate() { return borrowDate; }
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }
    public Date getReturnDate() { return returnDate;}
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate;}
    public boolean isHasLector() { return hasLector;}
    public void setHasLector(boolean hasLector) {this.hasLector = hasLector;}
    public boolean isHasDubbing() { return hasDubbing;}
    public void setHasDubbing(boolean hasDubbing) { this.hasDubbing = hasDubbing;}
    public boolean isIs3D() { return is3D;}
    public void setIs3D(boolean is3D) {this.is3D = is3D;}
}

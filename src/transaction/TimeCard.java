package transaction;

public class TimeCard {
    private Date itsDate;
    private double itsHours;

    public TimeCard(Date itsDate, double itsHours) {
        this.itsDate = itsDate;
        this.itsHours = itsHours;
    }

    public double getHours() {
        return itsHours;
    }

    public Date getDate() {
        return this.itsDate;
    }
}

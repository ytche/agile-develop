package transaction;

/**
 * @author cheyantao
 */
public class ServiceCharge {
    private double amount;
    private Date date;

    public ServiceCharge(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

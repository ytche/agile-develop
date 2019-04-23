package transaction;

/**
 * 小时分类
 * @author cheyantao
 */
public class HourlyClassification implements PaymentClassification {
    private double hourlyRate;
    private TimeCard timeCard;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public TimeCard getTimeCard(Date date) {
        return  this.timeCard;
    }

    public void addTimeCard(TimeCard timeCard) {
        this.timeCard=timeCard;
    }
}

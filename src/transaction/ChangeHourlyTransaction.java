package transaction;

/**
 * 更改小时类别
 */
public class ChangeHourlyTransaction extends ChangeClassificalTransaction {
    private double hourlyRate;

    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void change(Employee employee) {
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(this.hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}

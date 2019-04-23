package transaction;

/**
 * 小时工
 */
public class AddHourlyEmployee extends AddEmployeeTransaction{
    private double hourlyRate;
    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        this.hourlyRate=hourlyRate;
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

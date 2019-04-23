package transaction;

/**
 * @author cheyantao
 */
public class AddSalariedEmployee extends AddEmployeeTransaction{
    private Double itsSalary;
    public AddSalariedEmployee(int empId, String name, String address, double v) {
        super(empId, name, address);
        this.itsSalary =v;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}

package transaction;

public abstract class ChangeClassificalTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificalTransaction(int empId) {
        super(empId);
    }
    public abstract PaymentClassification getClassification();
    public abstract PaymentSchedule getSchedule();
}

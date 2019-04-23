package transaction;

/**
 * 带底薪并且有提成的销售人员
 * @author cheyantao
 */
public class AddCommissionedEmployee extends  AddEmployeeTransaction{
    private double salary;
    private double commissionedRate;
    public AddCommissionedEmployee(int empId, String name, String address,double salary,double commissionedRate) {
        super(empId, name, address);
        this.salary=salary;
        this.commissionedRate=commissionedRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(this.salary,this.commissionedRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiWeeklySchedule();
    }
}

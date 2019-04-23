package transaction;

/**
 * 会员收费处理
 * @author cheyantao
 */
public class SalesReceiptTransaction extends Transaction {
    private Date date;
    private double amount;
    private int empId;

    public SalesReceiptTransaction(Date date, double amount, int empId) {
        this.date = date;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee employee=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        CommissionedClassification cc= (CommissionedClassification) employee.getPaymentClassification();
        cc.addSalesReceipt(new SalesReceipt(date,amount));
    }
}

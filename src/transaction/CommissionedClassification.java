package transaction;

/**
 * 底薪+酬劳的发放分类
 * @author cheyantao
 */
public class CommissionedClassification implements PaymentClassification {
    private double salary;
    private double commissionRate;
    private SalesReceipt salesReceipt;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public double getSalary() {
        return this.salary;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        this.salesReceipt=salesReceipt;
    }

    public SalesReceipt getSalesReceipt() {
        return this.salesReceipt;
    }
}

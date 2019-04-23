package transaction;

/**
 * @author cheyantao
 */
public class SalariedClassification implements PaymentClassification {
    private Double itsSalary;
    public SalariedClassification() {
    }

    public SalariedClassification(Double itsSalary) {
        this.itsSalary=itsSalary;
    }

    public double getSalary() {
        return itsSalary;
    }
}
